package pages;

import java.util.*;
import org.openqa.selenium.*;
import utility.Constants;
import utility.Eventhelper;
import utility.Log;

public class Sendinvoicepage {

	private WebDriver driver;
	private By txtSearchBar = By.xpath("//input[@name='search']");
	private By txtAmount = By.xpath("//input[@name='customerAmount']");
	private By txtdate = By.xpath("//input[@name='customerDueDate']");
	private By txtMessage = By.xpath("//textarea[@placeholder='Memo (optional)']");
	private By lblReceivableBalance = By
			.xpath("//span[contains(.,'Receivable')]/following-sibling::div/span[@id='amount_receivable']");
	private By lblreceivableBalanceonAccounting = By.xpath(
			"//div[@class='tableVisible']//div[contains(@class,'PayableReceivableContent_payable-receivable__amount__')]");
	private By invoiceTableGrid = By.xpath("(//table)[2]//tr[1]//td");
	private By lnkPayOrGetPaid = By.xpath("//header//a[contains(@href,'vendors')]");
	private By ddValueOfBusinessSearched = By
			.xpath("//div[contains(@class,'entity-short-card__info CompanyCard_company__name')]//span/span");
	String receiableBlanaceOnAccountingPage;
	private By lblbusinessNameOnGrid = By.xpath("(//table)[2]//tr//td[1]");
	private By btnSearchedcardonreceivable = By.xpath("(//table[@role='presentation'])[2]//tr[1]//td[1]");
	private Homepage homepage;

	public Sendinvoicepage(WebDriver driver) {
		this.driver = driver;
		homepage = new Homepage(driver);
	}

	public float readReceivableBalanceOnDashBoard() {
		homepage.waitUntiAddFundsButtonEnabled();
		return Float.parseFloat(Eventhelper.getValueOfAttribute(driver, lblReceivableBalance, "receivable-amount")
				.substring(1).replace(",", ""));
	}

	public void searchBusiness(String businessName) {
		Eventhelper.sendkeys(driver, txtSearchBar, businessName);
		Eventhelper.threadWait(1000);
		By selectBusiness = By
				.xpath("//div[contains(@class,'CompanyCard_company')]//span[contains(text(),'" + businessName + "')]");
		Eventhelper.explicitwaitTextToBePresent(driver, ddValueOfBusinessSearched, businessName);
		Eventhelper.click(driver, selectBusiness);
	}

	public void sendInvoice(int amount, String message) {
		Eventhelper.sendkeys(driver, txtAmount, String.valueOf(amount));
		Eventhelper.sendkeys(driver, txtdate, Eventhelper.getDate(0));
		Eventhelper.sendkeys(driver, txtMessage, message);
	}

	public List<List<String>> seeInvoice(String businessName) {
		Eventhelper.explicitwaitTextToBePresent(driver, lblbusinessNameOnGrid, businessName);
		int noofRows = Eventhelper.findElements(driver, By.xpath("(//table)[2]//tr")).size();

		List<String> rowData = null;
		List<WebElement> listwe;
		List<List<String>> allrowdata = new ArrayList<List<String>>();
		for (int i = 1; i < noofRows; i++) {
			rowData = new ArrayList<String>();
			listwe = Eventhelper.findElements(driver, By.xpath("(//table)[2]//tr[" + i + "]/td"));
			for (WebElement ele : listwe) {
				rowData.add(ele.getText());
			}
			allrowdata.add(rowData);
		}
		return allrowdata;
	}

	public float receivableBalanceOnAccounting() {
		Eventhelper.threadWait(5000);
		return Float.parseFloat(
				Eventhelper.getValueOfAttribute(driver, lblreceivableBalanceonAccounting, "receivable-amount")
						.substring(1).replace(",", ""));
	}

	public float invoiceAmount(String accountingSection) {
		Eventhelper.threadWait(2000);
		int index = accountingSection.equalsIgnoreCase(Constants.PAYABLE) ? 1 : accountingSection.equalsIgnoreCase(Constants.RECEIVABLE)? 2:3;
		float amount = Float.parseFloat(Eventhelper.getTextofElement(driver, By
				.xpath("(//div[contains(@class,'InvoiceCard_transaction-card-header__amount')]/div[2])[" + index + "]"))
				.substring(1).replace(",", ""));
		Log.info("Balance on the opened card in receivable is :- " + amount);
		return amount;
	}

	public void clickOnPayOrGetPaid() {
		Eventhelper.explicitwait(driver, lnkPayOrGetPaid);
		Eventhelper.click(driver, lnkPayOrGetPaid);
	}

	public void sortWithDueDate(String accountingSection) {
		int index = accountingSection.equalsIgnoreCase(Constants.PAYABLE) ? 1 : accountingSection.equalsIgnoreCase(Constants.RECEIVABLE)? 2:3;
		By btnDuedate = By.xpath("(//p[contains(text(),'Due date')])[" + index + "]");
		Eventhelper.click(driver, btnDuedate);
	}

	public void enterAmountOfInvoice(String amount) {
		Eventhelper.sendkeys(driver, txtAmount, amount);
	}

	public void clickOnMenuButtonOfCard(String accountingSection) {
		int index = accountingSection.equalsIgnoreCase(Constants.PAYABLE) ? 1 : accountingSection.equalsIgnoreCase(Constants.RECEIVABLE)? 2:3;
		By btnMenuOnReceivableCard = By
				.xpath("(//div[contains(@class,'transaction-card-footer__actions-btn')])[" + index + "]");
		Eventhelper.click(driver, btnMenuOnReceivableCard);
		Log.info("clicked on menu");
	}

	public void clickOnSearchedCardReceivavle() {
		Eventhelper.click(driver, btnSearchedcardonreceivable);
	}

	public boolean isMessageOnCard(String message, String accountingSection) {
		int index = accountingSection.equalsIgnoreCase(Constants.PAYABLE) ? 1 : accountingSection.equalsIgnoreCase(Constants.RECEIVABLE)? 2:3;
		By xpath = By.xpath("(//div[contains(@class,'InvoiceCard_transaction-card__wrapper')]//*[text()='"+message+"'])["+index+"]");
		return Eventhelper.isElementDisplayed(driver, xpath);
	}

	public void clickOnConfirmButtonforMarkasInvoice(String buttonname) {
		By btnXpath = By.xpath("(//button[normalize-space()='" + buttonname + "'])[2]");
		Eventhelper.click(driver, btnXpath);
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

	public void clickOnInvoice(String accountingSection)
	{
		int index= accountingSection.equalsIgnoreCase(Constants.PAYABLE) ? 1 : accountingSection.equalsIgnoreCase(Constants.RECEIVABLE)? 2:3;
		By invoice= By.xpath("(//table[@role='presentation'])["+index+"]//tr[1]//td[1]");
		Eventhelper.click(driver, invoice);
	}
	
	public float flowedAmountOnCompletedInvoice()
	{
		Eventhelper.threadWait(1000);
		float amt= Float.parseFloat(Eventhelper.getTextofElement(driver, By.xpath("(//table[@role='presentation'])[3]//tr[1]//td[3]//span"))
				.substring(2).replace(",", ""));
		Log.info("amt value is :- "+amt);
		return amt;
	}

}
