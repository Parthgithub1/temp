package pages;

import java.util.*;
import org.openqa.selenium.*;
import utility.Constants;
import utility.Eventhelper;
import utility.Log;

public class Sendinvoicepage {

	private WebDriver driver;
	private By txtSearchBar = By.xpath("//input[@name='search']");
	private By txtAmount = By.xpath("//input[@name='amount']");
	private By txtdate = By.xpath("//input[@name='dueDate']");
	private By txtMessage = By.xpath("//textarea[contains(@class,'TextInput_field-input__')]");
	private By lblReceivableBalance = By
			.xpath("//span[contains(.,'Receivable')]/following-sibling::div/span[@id='amount_receivable']");
	private By lblreceivableBalanceonAccounting = By.xpath("//div[@id='amount_receivable']");
	private By lnkPayOrGetPaid = By.xpath("//header//a[contains(@href,'vendors')]");
	private By ddValueOfBusinessSearched = By
			.xpath("//div[contains(@class,'entity-short-card CompanyCard_company')]//span/span");
	String receiableBlanaceOnAccountingPage;
	String cancelInvoiceNo;
	String cancelNotification;
	String invoiceId;

	private By lblbusinessNameOnGrid = By.xpath("(//div[@id='receivable']//table)[2]//tbody//tr[2]//td[2]");
	private By btnSearchedcardonreceivable = By.xpath("(//table[@role='presentation'])[2]//tr[2]//td[3]");
	private By btnCloseFlowDialogBox = By.xpath("//button[@aria-label='Close']//*[name()='svg']");
	private By lblInvoiceNoForCancelInvoice = By.xpath("(//span[contains(@class,'id_receivable')])[1]");
	private By btnShareLinkInReceivable = By.xpath("(//div[@id='receivable']//table)[2]//tbody//tr[2]//td[2]//span//div[contains(@class,'quick-action-icons')]//div[1]");
	private By lblInvoiceID = By.xpath("//span[contains(@class,'InvoiceCard_entity-short-card-help-text')]");
	private By lblInvoiceNoOnExternalInvoice = By.xpath("//div[@class='invoice-action__num']");
	private Homepage homepage;
	private Commonpage commonPage;

	public Sendinvoicepage(WebDriver driver) {
		this.driver = driver;
		homepage = new Homepage(driver);
		commonPage = new Commonpage(driver);
	}

	public float readReceivableBalanceOnDashBoard() {
		homepage.waitUntiAddFundsButtonEnabled();
		return Float.parseFloat(Eventhelper.getValueOfAttribute(driver, lblReceivableBalance, "receivable-amount")
				.substring(1).replace(",", ""));
	}

	public void searchBusiness(String businessName) {
		if (businessName.equals("Search the business")) {
			Eventhelper.sendkeys(driver, txtSearchBar, businessName);
		} else {
			Eventhelper.sendkeys(driver, txtSearchBar, businessName);
			Eventhelper.threadWait(1000);
			By selectBusiness = By.xpath(
					"//div[contains(@class,'CompanyCard_company')]//span[contains(text(),'" + businessName + "')]");
			Eventhelper.explicitwaitTextToBePresent(driver, ddValueOfBusinessSearched, businessName);
			Eventhelper.click(driver, selectBusiness);
		}
	}

	public void sendInvoice(int amount, String message) {
		Eventhelper.sendkeys(driver, txtAmount, String.valueOf(amount));
		Eventhelper.sendkeys(driver, txtdate, Eventhelper.getDate(0));
		Eventhelper.sendkeys(driver, txtMessage, message);
	}

	public ArrayList<ArrayList<String>> seeInvoice(String businessName) {
		Eventhelper.explicitwaitTextToBePresent(driver, lblbusinessNameOnGrid, businessName);
		int noofRows = Eventhelper.findElements(driver, By.xpath("(//div[@id='receivable']//table)[2]//tbody")).size();
		ArrayList<String> rowData = null;
		List<WebElement> listwe;
		ArrayList<ArrayList<String>> allrowdata = new ArrayList<ArrayList<String>>();
		for (int i = 2; i <= noofRows + 1; i++) {
			rowData = new ArrayList<String>();
			listwe = Eventhelper.findElements(driver,
					By.xpath("(//div[@id='receivable']//table)[2]//tbody//tr[" + i + "]"));
			for (WebElement ele : listwe) {
				rowData.add(ele.getText().trim());
			}
			allrowdata.add(rowData);
		}
		return allrowdata;
	}

	public float receivableBalanceOnAccounting() {
		Eventhelper.threadWait(5000);
		Log.info("The original value is :-  "
				+ Eventhelper.getValueOfAttribute(driver, lblreceivableBalanceonAccounting, "data-balance"));
		return Float.parseFloat(Eventhelper
				.getValueOfAttribute(driver, lblreceivableBalanceonAccounting, "data-balance").replace(",", ""));
	}

	public int getIndex(String accountingSection) {
		if (accountingSection.equalsIgnoreCase(Constants.PAYABLE)) {
			return 1;
		}
		return accountingSection.equalsIgnoreCase(Constants.RECEIVABLE) ? 2 : 3;
	}

	public float invoiceAmount(String accountingSection) {
		Eventhelper.threadWait(2000);
		//int index = getIndex(accountingSection);
		float amount = Float.parseFloat(Eventhelper.getTextofElement(driver, By
				.xpath("//div[contains(@class,'InvoiceCard_bill-amount')]"))
				.substring(1).replace(",", ""));
		Log.info("Balance on the opened card in receivable is :- " + amount +"In the section"+ accountingSection);
		return amount;
	}

	public void clickOnPayOrGetPaid() {
		Eventhelper.explicitwait(driver, lnkPayOrGetPaid);
		Eventhelper.click(driver, lnkPayOrGetPaid);
	}

	public void sortWithDueDate(String accountingSection) {
		int index = getIndex(accountingSection);
		Eventhelper.threadWait(1000);
		By btnDuedate = By.xpath("(//p[contains(text(),'Due date')])[" + index + "]");
		Eventhelper.click(driver, btnDuedate);
	}

	public void enterAmountOfInvoice(String amount) {
		Eventhelper.sendkeys(driver, txtAmount, amount);
	}

	public void clickOnMenuButtonOfCard(String accountingSection) {
		/*
		 * int index = getIndex(accountingSection); // By btnMenuOnReceivableCard = By
		 * // .xpath("(//div[contains(@class,'transaction-card-footer__actions-btn')])["
		 * + // index + "]");
		 * 
		 * Note:- As per the current UI implementation there is only one xpath is used
		 * for the menu icon in the invoice card. But will observe the behaviour for the
		 * payable and completed and then refactor this method
		 */
		By btnMenuOnReceivableCard = By.xpath("//div[@class='transaction-card-footer__actions-btn']");
		Eventhelper.click(driver, btnMenuOnReceivableCard);
		Log.info("clicked on menu"+accountingSection);
	}

	public void clickOnSearchedCardReceivavle() {
		Eventhelper.click(driver, btnSearchedcardonreceivable);
	}

	public boolean isMessageOnCard(String message, String accountingSection) {
		/*int index = getIndex(accountingSection);
		By xpath = By.xpath("(//div[contains(@class,'InvoiceCard_transaction-card__wrapper')]//*[text()='" + message
				+ "'])[" + index + "]");
		*/
		By xpath = By.xpath("(//div[contains(@class,'InvoiceCard_transaction-card__wrapper')]//*[text()='" + message
				+ "'])");
		Log.info("Message "+message +"on accounting section"+accountingSection);
		return Eventhelper.isElementDisplayed(driver, xpath);
	}

	public void clickOnConfirmButtonforMarkasInvoice(String buttonname) {
		By btnXpath = By.xpath("//button[normalize-space()='" + buttonname + "']");
		Eventhelper.explicitwait(driver, btnXpath);
		Eventhelper.click(driver, btnXpath);
		Eventhelper.waitUntilElementInvisible(driver, btnXpath);
	}

	public void sendInvoiceForFutureDate(int amount, String message) {
		int date = message.equalsIgnoreCase("Factor invoice") ? 33 : 1;
		Eventhelper.sendkeys(driver, txtAmount, String.valueOf(amount));
		Eventhelper.useActionClassOperation(driver, txtdate, Constants.DOUBLECLICK);
		Eventhelper.sendkeys(driver, txtdate, Eventhelper.getDate(date));
		Eventhelper.sendkeys(driver, txtMessage, message);
	}

	public void clickOnFlowButton() {
		By btnflow = By.xpath("(//button[@type='button'][normalize-space()='Flow'])[2]");
		Eventhelper.click(driver, btnflow);
	}

	public float flowedAmount() {
		Eventhelper.threadWait(2000);
		float amount = Float.parseFloat(Eventhelper.getTextofElement(driver, By.xpath("(//h2[@class='decimal'])[2]"))
				.substring(1).replace(",", "").replace(" ", ""));
		Log.info("Flowed amount is" + amount);
		return amount;
	}

	public void clickOnGetButton() {
		By btnget = By.xpath("(//button[contains(text(),'Get')])[1]");
		Eventhelper.click(driver, btnget);
	}

	public void clickOnAcceptAndAgree() {
		By lblAcceptAndAgree = By.xpath("//label[normalize-space()='Agree & accept']");
		Eventhelper.click(driver, lblAcceptAndAgree);
	}

	public void clickOnInvoice(String accountingSection) {
		int index = getIndex(accountingSection);
		By invoice = By.xpath("(//table[@role='presentation'])[" + index + "]//tr[1]//td[1]");
		Eventhelper.click(driver, invoice);
	}

	public float flowedAmountOnCompletedInvoice() {
		Eventhelper.threadWait(1000);
		float amt = Float.parseFloat(
				Eventhelper.getTextofElement(driver, By.xpath("(//table[@role='presentation'])[3]//tr[1]//td[3]//span"))
						.substring(2).replace(",", ""));
		Log.info("amt value is :- " + amt);
		return amt;
	}

	public void clickOnCloseOfFlowDialogBox() {
		Eventhelper.click(driver, btnCloseFlowDialogBox);
	}

	public void readInvoiceNumberForCancellInvoice() {
		cancelInvoiceNo = Eventhelper.getValueOfAttribute(driver, lblInvoiceNoForCancelInvoice, "invoice-id");
		Log.info("Invoice number is" + cancelInvoiceNo);
	}

	public boolean isCancelNotificationExistInNotificationList() {
		cancelNotification = "Invoice #" + cancelInvoiceNo + " to qatsmokeautomation15 has been canceled.";
		return commonPage.isNotificationPresentInList(cancelNotification);
	}

	public void moveToShareLinkButtonInReceivableCardandHoverOnIt() {
		Eventhelper.autoScrollWindow(driver);
		Eventhelper.explicitwaitclickable(driver, btnShareLinkInReceivable);
		Eventhelper.clickElementwithjs(driver, btnShareLinkInReceivable);
		Eventhelper.useActionClassOperation(driver, btnShareLinkInReceivable, "Hover");
	}

	public void setCopiedLinkInBrowser() {
		String actualCopiedText = Eventhelper.readDataFromClipboard();
		Log.info("String from Clipboard is -->:" + actualCopiedText);
		Log.info("The invoice no in generated url --> "
				+ actualCopiedText.substring((actualCopiedText.lastIndexOf("/")) + 1));
		Eventhelper.doRefresh(driver);
		Eventhelper.getURL(driver, actualCopiedText.substring(23));
	}

	public void readInvoiceId() {
		invoiceId = Eventhelper.getTextofElement(driver, lblInvoiceID).substring(9);
		Log.info("Invoice number is ->" + invoiceId);
	}

	public boolean isInvoiceNoPresentOnTheInvoiceCard() {
		return Eventhelper.getTextofElement(driver, lblInvoiceID).equalsIgnoreCase(("Invoice #"+invoiceId));
	}

	public boolean isInvoiceNoDisplayOnTheScreen() {
		return Eventhelper.getTextofElement(driver, lblInvoiceNoOnExternalInvoice)
				.equalsIgnoreCase("Invoice # " + invoiceId);
	}

	public boolean isPlaceHolderPresentInSearchBusiness() {
		return Eventhelper.getValueOfAttribute(driver, txtSearchBar, "placeholder")
				.equals("Find or add a business here");
	}
}
