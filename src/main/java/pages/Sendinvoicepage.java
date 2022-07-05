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

	public List<String> seeInvoice(String businessName) {
		Eventhelper.explicitwaitTextToBePresent(driver, lblbusinessNameOnGrid, businessName);
		List<WebElement> columnElements = Eventhelper.findElements(driver, invoiceTableGrid);
		List<String> actualData = new ArrayList<>();
		for (WebElement columnElement : columnElements) {
			actualData.add(columnElement.getText());
		}
		return actualData;
	}

	public float receivableBalanceOnAccounting() {
		Eventhelper.threadWait(5000);
		return Float.parseFloat(
				Eventhelper.getValueOfAttribute(driver, lblreceivableBalanceonAccounting, "receivable-amount")
						.substring(1).replace(",", ""));
	}

	public float invoiceAmount(String accountingSection) {
		Eventhelper.threadWait(2000);
		int index = accountingSection.equalsIgnoreCase(Constants.PAYABLE) ? 1 : 2;
		Float amount = Float.parseFloat(Eventhelper.getTextofElement(driver, By
				.xpath("(//div[contains(@class,'InvoiceCard_transaction-card-header__amount')]/div[2])[" + index + "]"))
				.substring(1).replace(",", ""));
	Log.info("Balance on the opened card in receivable is :-" + amount);
		return amount;
	}

	public void clickOnPayOrGetPaid() {
		Eventhelper.explicitwait(driver, lnkPayOrGetPaid);
		Eventhelper.click(driver, lnkPayOrGetPaid);
	}

	public void sortWithDueDate(String accountingSection) {
		int index = accountingSection.equalsIgnoreCase(Constants.PAYABLE) ? 1 : 2;
		By btnDuedate = By.xpath("(//p[contains(text(),'Due date')])[" + index + "]");
		Eventhelper.click(driver, btnDuedate);
	}

	public void enterAmountOfInvoice(String amount) {
		Eventhelper.sendkeys(driver, txtAmount, amount);
	}

	public void clickOnMenuButtonOfCard(String accountingSection) {
		int index = accountingSection.equalsIgnoreCase(Constants.PAYABLE) ? 1 : 2;
		By btnMenuOnReceivableCard = By
				.xpath("(//div[contains(@class,'transaction-card-footer__actions-btn')])[" + index + "]");
		Eventhelper.click(driver, btnMenuOnReceivableCard);
		Log.info("clicked on menu");
	}

	public void clickOnSearchedCardReceivavle() {
		Eventhelper.click(driver, btnSearchedcardonreceivable);
	}

	public boolean isMessageOnCard(String message, String accountingSection) {
		int index = accountingSection.equalsIgnoreCase(Constants.PAYABLE) ? 1 : 2;
		By xpath = By.xpath("(//*[contains(text(),'" + message + "')])[" + index + "]");
		return Eventhelper.isElementDisplayed(driver, xpath);
	}

	public void clickOnConfirmButtonforMarkasInvoice(String buttonname) {
		By btnXpath = By.xpath("(//button[normalize-space()='" + buttonname + "'])[2]");
		Eventhelper.click(driver, btnXpath);
	}
	
	public void sendInvoiceForFutureDate(int amount, String message) {
		Eventhelper.sendkeys(driver, txtAmount, String.valueOf(amount));
		Eventhelper.useActionClassOperation(driver, txtdate, Constants.DOUBLECLICK);
		Eventhelper.sendkeys(driver, txtdate, Eventhelper.getDate(1));
		Eventhelper.sendkeys(driver, txtMessage, message);
	}
}