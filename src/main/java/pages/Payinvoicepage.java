package pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Eventhelper;
import utility.Log;

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
		Log.info("Value of is data loaded before :-" + Eventhelper.getValueOfAttribute(driver,
				By.xpath("//div[contains(.,'Hopscotch Balance')]/following-sibling::div[@id='HopscotchBalance']"),
				"data-loaded"));
		//Eventhelper.threadWait(20000);
		homepage.waituntillDataLoadedOnTheDashboard();
		Log.info("Value of is data loaded after :-" + Eventhelper.getValueOfAttribute(driver,
				By.xpath("//div[contains(.,'Hopscotch Balance')]/following-sibling::div[@id='HopscotchBalance']"),
				"data-loaded"));
		By payableContanierxPath = By.xpath("//span[contains(.,'" + contanierName + "')]/following-sibling::div/div");
		Eventhelper.click(driver, payableContanierxPath);
	}

	public float getexistingBalanceofPayableonAccountingPage() {
		homepage.waitUntiAddFundsButtonEnabled();
		return Float.parseFloat(Eventhelper.getValueOfAttribute(driver,
				By.xpath("//*[contains(@class,'PayableReceivableContent_payable-receivable__amount__')]"),
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
		By invoicexpath = By.xpath("//*[contains(@class,'TransactionList_bizName__')]");
		Eventhelper.click(driver, invoicexpath);
	}

	public List<String> seeInvoice() {
		Eventhelper.click(driver, btnCompleted);
		Eventhelper.click(driver, btnDate);
		List<WebElement> columnElements = Eventhelper.findElements(driver, invoiceTableGrid);
		List<String> actualData = new ArrayList<>();
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
		List<String> actualData = new ArrayList<>();
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
		String xpath = searchBarExistIn(accountingSection);
		By txtSearchBaronAccountingSection = By.xpath(xpath);
		Eventhelper.sendkeys(driver, txtSearchBaronAccountingSection, searchPayables);
	}
	
	public String searchBarExistIn(String accountingSection)
	{
		String xpath = null;
		if (accountingSection.equals("Payable")) {
			xpath = "(//input[@aria-label='Search in the data grid'])[1]";
		} else if (accountingSection.equals("Receivable")) {
			xpath = "(//input[@aria-label='Search in the data grid'])[2]";
		} else if (accountingSection.equals("Completed")) {
			xpath = "(//input[@aria-label='Search in the data grid'])[3]";
		}
		return xpath;
	}
	
	public void cleanSearchBar(String accountingSection) {
		String xpath = searchBarExistIn(accountingSection);	
		By txtSearchBaronAccountingSection = By.xpath(xpath);
		Eventhelper.useActionClassOperation(driver, txtSearchBaronAccountingSection, "DoubleClick");
		Eventhelper.threadWait(1000);
		Eventhelper.sendKeyboardKeys(driver, txtSearchBaronAccountingSection, "backspace");
	}
}