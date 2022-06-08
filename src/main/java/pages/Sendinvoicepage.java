package pages;

import java.util.*;
import org.openqa.selenium.*;

import utility.Eventhelper;

public class Sendinvoicepage {

	private WebDriver driver;
	private By txtSearchBar = By.xpath("//input[@name='search']");
	private By selectBusiness;
	private By txtAmount = By.xpath("//input[@name='customerAmount']");
	private By txtdate = By.xpath("//input[@placeholder='Due Date']");
	private By txtMessage = By.xpath(" //textarea[@placeholder='Message']");
	private By lblReceivableBalance = By
			.xpath("//span[contains(.,'Receivable')]/following-sibling::div/span[@id='amount_receivable']");
	private By lnkDashBoard = By.xpath("//a[contains(@class,'Logo_logo')]");
	private By lblreceivableBalanceonAccounting = By.xpath(
			"//div[@class='tableVisible']//div[contains(@class,'PayableReceivableContent_payable-receivable__amount__')]");
	private By invoiceTableGrid = By.xpath("(//table)[2]//tr[1]//td");
	private By lnkSendInvoice = By.xpath("//span[contains(@class,'Button_btn__icon')]//*[name()='svg']");
	private By btnDueDateOnReceivable = By.xpath("(//p[contains(text(),'Due date')])[2]");
	private By ddValueOfBusinessSearched = By
			.xpath("//div[contains(@class,'entity-short-card__info CompanyCard_company__name')]//span/span");
	String receivableBalanceOndashboard, receiableBlanaceOnAccountingPage;
	private By lblbusinessNameOnGrid = By.xpath("(//table)[2]//tr//td[1]");
	private Homepage homepage;

	public Sendinvoicepage(WebDriver driver) {
		this.driver = driver;
		homepage = new Homepage(driver);
	}

	public float readReceivableBalanceOnDashBoard() {
		homepage.waitUntilAddFundsButtonEnabled();
		return Float.parseFloat(
				Eventhelper.getValueOfAttribute(driver, lblreceivableBalanceonAccounting, "receivable-amount")
						.substring(1).replace(",", ""));
	}

	public void searchBusiness(String businessName) {
		Eventhelper.sendkeys(driver, txtSearchBar, businessName);
		selectBusiness = By
				.xpath("//div[contains(@class,'CompanyCard_company')]//span[contains(text(),'" + businessName + "')]");
		Eventhelper.explicitwaitTextToBePresent(driver, ddValueOfBusinessSearched, businessName);
		Eventhelper.click(driver, selectBusiness);
	}

	public void sendInvoice(int amount, String message) {
		Eventhelper.sendkeys(driver, txtAmount, String.valueOf(amount));
		Eventhelper.sendkeys(driver, txtdate, Eventhelper.getTodaysDateInSting());
		Eventhelper.sendkeys(driver, txtMessage, message);
	}

	public List<String> seeInvoice(String businessName) {
		Eventhelper.explicitwaitTextToBePresent(driver, lblbusinessNameOnGrid, businessName);
		List<WebElement> columnElements = Eventhelper.findElements(driver, invoiceTableGrid);
		List<String> actualData = new ArrayList<String>();
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

	public void switchToDashboard() {
		Eventhelper.click(driver, lnkDashBoard);
	}

	public void clickOnSendInvoice() {
		Eventhelper.explicitwait(driver, lnkSendInvoice);
		Eventhelper.click(driver, lnkSendInvoice);
	}

	public void sortWithDueDate() {
		Eventhelper.click(driver, btnDueDateOnReceivable);
	}
}
