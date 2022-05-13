package pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Eventhelper;

public class Sendinvoicepage {

	private WebDriver driver;
	private By txtSearchBar = By.xpath("//input[@name='search']");
	private By selectBusiness;
	private By txtAmount = By.xpath("//input[@name='customerAmount']");
	private By txtdate= By.xpath("//input[@placeholder='Due Date']");
	private By txtMessage = By.xpath(" //textarea[@placeholder='Message']");
	private By lblReceivableBalance = By.xpath("//span[contains(.,'Receivable')]/following-sibling::div/span[@id='amount_receivable']");
	private By lnkDashBoard = By.xpath("//a[contains(@class,'Logo_logo')]");
	private By lblNotification = By.xpath("(//p[contains(@class,'notifications-text')])[1]");
	private By lblreceivableBalanceonAccounting = By.xpath(
			"//div[@class='tableVisible']//div[contains(@class,'PayableReceivableContent_payable-receivable__amount__')]");
	private By txtSearchBarOnReceivable = By.xpath("(//input[@aria-label='Search in the data grid'])[2]");
	private By invoiceTableGrid = By.xpath("(//table)[2]//tr[1]//td");
	private By lnkSendInvoice = By.xpath("//span[contains(@class,'Button_btn__icon')]//*[name()='svg']");
	private By btnDueDateOnReceivable = By.xpath("(//p[contains(text(),'Due date')])[2]");
	String receivableBalanceOndashboard, receiableBlanaceOnAccountingPage;
	
	public Sendinvoicepage(WebDriver driver) {
		this.driver = driver;
	}

	public Float readReceivableBalanceOnDashBoard() {
		Eventhelper.threadWait(3000);
		receivableBalanceOndashboard = Eventhelper.getValueOfAttribute(driver,lblReceivableBalance ,"receivable-amount");
		String castToFloat = receivableBalanceOndashboard.substring(1);
		return Float.parseFloat(castToFloat);
	}

	public void searchBusiness(String businessName) {
		Eventhelper.sendkeys(driver, txtSearchBar, businessName);
		selectBusiness = By
				.xpath("//div[contains(@class,'CompanyCard_company')]//span[contains(text(),'" + businessName + "')]");
		Eventhelper.threadWait(3000);
		Eventhelper.click(driver, selectBusiness);
	}

	public void sendInvoice(int amount, String message) {
		Eventhelper.sendkeys(driver, txtAmount, String.valueOf(amount));
		Eventhelper.sendkeys(driver, txtdate, Eventhelper.getTodaysDateInSting());
		Eventhelper.sendkeys(driver, txtMessage, message);
	}

	public List<String> seeInvoice() {
		List<WebElement> columnElements = Eventhelper.findElements(driver, invoiceTableGrid);
		List<String> actualData = new ArrayList<String>();
		for (WebElement columnElement : columnElements) {
			actualData.add(columnElement.getText());
		}
		return actualData;
	}

	public float reciavableBalanceOnAccounting() {
		Eventhelper.isElementDisplayed(driver, lblreceivableBalanceonAccounting);
		String amount = Eventhelper.getValueOfAttribute(driver, lblreceivableBalanceonAccounting,"receivable-amount");
		String castToFloat = amount.substring(1);
		return Float.parseFloat(castToFloat);
	}

	public void switchToDashboard() {
		Eventhelper.click(driver, lnkDashBoard);
	}

	public String isNotificationSent() throws InterruptedException {
		return Eventhelper.getTextofElement(driver, lblNotification);
	}

	
	public void clickOnSendInvoice() {
		Eventhelper.click(driver, lnkSendInvoice);
	}

	public void sortWithDueDate() {
		Eventhelper.click(driver, btnDueDateOnReceivable);
	}
}
