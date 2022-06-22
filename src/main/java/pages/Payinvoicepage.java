package pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Eventhelper;

public class Payinvoicepage {
	private WebDriver driver;
	private By btnCompleted = By.xpath("//button[normalize-space()='Completed']");
	private By btnDate = By.xpath("(//p[contains(text(),'Due date')])[3]");
	private By invoiceTableGrid = By.xpath("(//table)[3]//tr[1]//td");
	private By txtSearchBaronPayableTab = By.xpath("(//input[@aria-label='Search in the data grid'])[1]");
	private By notificationTableGridxPath = By.xpath("//div[contains(@class,'detail-notification-view')]/div//p");
	private Homepage homepage;

	public Payinvoicepage(WebDriver driver) {
		this.driver = driver;
		homepage = new Homepage(driver);
	}

	public void clickOnContanier(String contanierName) {
		By payableContanierxPath = By.xpath("//span[contains(.,'" + contanierName + "')]/following-sibling::div/span");
		Eventhelper.click(driver, payableContanierxPath);
	}

	public float getexistingBalanceofPayableonAccountingPage() {
		homepage.waitUntiAddFundsButtonEnabled();
		return Float.parseFloat(Eventhelper.getValueOfAttribute(driver,
				By.xpath("//*[contains(@class,'PayableReceivableContent_payable-receivable__amount__1OW1E')]"),
				"payable-amount").substring(1).replace(",", ""));
	}

	public float invoiceAmountUserPaying() {
		Eventhelper.threadWait(2000);
		return Float.parseFloat(Eventhelper
				.getTextofElement(driver,
						By.xpath("(//div[contains(@class,'InvoiceCard_transaction-card-header__amount')]/div[2])[1]"))
				.substring(1).replace(",", ""));
	}

	public void clickOnPayableContanier() {
		By payableContanierxpath = By.xpath("//span[contains(.,'Payable')]/following-sibling::div/span");
		Eventhelper.click(driver, payableContanierxpath);
	}

	public void clickOnInvoice() {
		Eventhelper.threadWait(2000);
		By invoicexpath = By.xpath("//*[contains(@class,'TransactionList_bizName__2vORu')]");
		Eventhelper.click(driver, invoicexpath);
	}

	public List<String> seeInvoice() {
		Eventhelper.click(driver, btnCompleted);
		Eventhelper.click(driver, btnDate);
		List<WebElement> columnElements = Eventhelper.findElements(driver, invoiceTableGrid);
		List<String> actualData = new ArrayList<String>();
		for (WebElement columnElement : columnElements) {
			actualData.add(columnElement.getText());
		}
		return actualData;
	}

	public void clickOnButton() {
		By btnxpath = By.xpath("//a[text()='Homepage']");
		Eventhelper.click(driver, btnxpath);
	}

	public float getexistingBalanceofCompletedPayables() {
		Eventhelper.threadWait(2000);
		return Float.parseFloat(Eventhelper
				.getTextofElement(driver,
						By.xpath("//*[contains(@class,'CompletedDashboard_completed-dashboard-item__amount__3En2r')]"))
				.substring(1).replace(",", ""));
	}

	public void enterInSearchBar(String searchPayables) {
		Eventhelper.sendkeys(driver, txtSearchBaronPayableTab, searchPayables);
	}

	public boolean seeNotifications() {
		List<WebElement> columnElements = Eventhelper.findElements(driver, notificationTableGridxPath);
		List<String> actualData = new ArrayList<String>();
		boolean flag = false;
		for (WebElement columnElement : columnElements) {
			actualData.add(columnElement.getText());
		}
		if (actualData.contains("You paid an invoice to hopsmokeautomation1llc for $1.00")) {
			flag = true;
		}
		return flag;
	}

	public void enterInSearchBar(String searchPayables, String accountingSection) {
		String xpath = null;
		if (accountingSection.equals("Payable")) {
			xpath = "(//input[@aria-label='Search in the data grid'])[1]";
		} else if (accountingSection.equals("Receivable")) {
			xpath = "(//input[@aria-label='Search in the data grid'])[2]";
		} else if (accountingSection.equals("Completed")) {
			xpath = "(//input[@aria-label='Search in the data grid'])[3]";
		}
		By txtSearchBaronAccountingSection = By.xpath(xpath);
		Eventhelper.sendkeys(driver, txtSearchBaronAccountingSection, searchPayables);
	}
}