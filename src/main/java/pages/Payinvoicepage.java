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
    private By btnDate= By.xpath("(//p[contains(text(),'Due date')])[3]");
    private By invoiceTableGrid = By.xpath("(//table)[3]//tr[1]//td");
    private By txtsearchBaronPayableTab = By.xpath("(//input[@aria-label='Search in the data grid'])[1]");
    private By notificationTableGridxPath = By.xpath("//div[contains(@class,'detail-notification-view')]/div//p");
    private By payableContanierxpath;

	public Payinvoicepage(WebDriver driver) {
		this.driver = driver;		
	}
	
	public void clickOnContanier(String contanierName) {
		payableContanierxpath = By.xpath("//span[contains(.,'"+contanierName+"')]/following-sibling::div/span");
		Eventhelper.click(driver, payableContanierxpath);
	}
	
	public float getexistingBalanceofPayableofHomePage() {
		Eventhelper.threadWait(2000);
		float amountBalanceofPayablesonHomePage = Float.parseFloat(Eventhelper.getTextofElement(driver, By.xpath("//span[contains(.,'Payable')]/following-sibling::div/span")).substring(1));
		Log.info("Pay Amount on Home Page" + amountBalanceofPayablesonHomePage);
		return amountBalanceofPayablesonHomePage;
	}
	
	public float getexistingBalanceofPayableonAccountingPage() {
		Eventhelper.threadWait(2000);
		float amountBalanceonAccountingPageforPayables = Float.parseFloat(Eventhelper.getTextofElement(driver, By.xpath("//*[contains(@class,'PayableReceivableContent_payable-receivable__amount__1OW1E')]")).substring(1));
		Log.info("Pay Amount on Accounting Page" + amountBalanceonAccountingPageforPayables);
		return amountBalanceonAccountingPageforPayables;
	}
	
	public float invoiceAmountUserPaying() {
		Eventhelper.threadWait(2000);
		float newAmountonAccountingBalanceforPayables = Float.parseFloat(Eventhelper.getTextofElement(driver, By.xpath("(//div[contains(@class,'InvoiceCard_transaction-card-header__amount')]/div[2])[1]")).substring(1));
		Log.info("Pay Amount on Invoice Page" + newAmountonAccountingBalanceforPayables);
		return newAmountonAccountingBalanceforPayables;
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
		float amountBalance = Float.parseFloat(Eventhelper.getTextofElement(driver, By.xpath("//*[contains(@class,'CompletedDashboard_completed-dashboard-item__amount__3En2r')]")).substring(1));
		return amountBalance;
	}
	
	public void enterInSearchBar(String searchPayables) {
		Eventhelper.sendkeys(driver, txtsearchBaronPayableTab, searchPayables);
	}
	
	public void clickonNotificationfromHeader(String linktext) {
		By btnxpath = By.xpath("(//*[name()='svg'])[4]");		
		Eventhelper.click(driver, btnxpath);
	}
	

	public boolean seeNotifications() {
		List<WebElement> columnElements = Eventhelper.findElements(driver, notificationTableGridxPath);
		List<String> actualData = new ArrayList<String>();
		boolean flag = false;
		for (WebElement columnElement : columnElements) {
			actualData.add(columnElement.getText());
		}
		if(actualData.contains("You paid an invoice to hopsmokeautomation1llc for $1.00")){
			//System.out.println("Notification Matched");
			flag = true;
		}
		return flag;
	}


}
