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

	public Payinvoicepage(WebDriver driver) {
		this.driver = driver;		
	}
	
	public float getexistingBalanceofPayableofHomePage() {
		Eventhelper.threadWait(2000);
		String actualBalanceDisplayedofPayableonHomePage = Eventhelper.getTextofElement(driver, By.xpath("//span[contains(.,'Payable')]/following-sibling::div/span"));
	    String hopscotchBalanceofHomePageforPayables = actualBalanceDisplayedofPayableonHomePage.substring(1);
		float amountBalanceofPayablesonHomePage = Float.parseFloat(hopscotchBalanceofHomePageforPayables);
		Log.info("Pay Amount on Home Page" + amountBalanceofPayablesonHomePage);
		return amountBalanceofPayablesonHomePage;
	}
	
	public float getexistingBalanceofPayableonAccountingPage() {
		Eventhelper.threadWait(2000);
		String actualBalanceDisplayedofPayableonAccountingPage = Eventhelper.getTextofElement(driver, By.xpath("//*[contains(@class,'PayableReceivableContent_payable-receivable__amount__1OW1E')]"));
	    String hopscotchBalanceonAccoutingPageforPayables = actualBalanceDisplayedofPayableonAccountingPage.substring(1);
		float amountBalanceonAccountingPageforPayables = Float.parseFloat(hopscotchBalanceonAccoutingPageforPayables);
		Log.info("Pay Amount on Accounting Page" + amountBalanceonAccountingPageforPayables);
		return amountBalanceonAccountingPageforPayables;
	}
	
	public float invoiceAmountUserPaying() {
		Eventhelper.threadWait(2000);
		String invoiceAmountUserPaying = Eventhelper.getTextofElement(driver, By.xpath("(//div[contains(@class,'InvoiceCard_transaction-card-header__amount')]/div[2])[1]"));
	    String payableAmountreflected = invoiceAmountUserPaying.substring(1);
		float newAmountonAccountingBalanceforPayables = Float.parseFloat(payableAmountreflected);
		Log.info("Pay Amount on Invoice Page" + newAmountonAccountingBalanceforPayables);
		return newAmountonAccountingBalanceforPayables;
	}
	
	public void clickOnPayableContanier() {
		By payableContanierxpath = By.xpath("//span[contains(.,'Payable')]/following-sibling::div/span");
		Eventhelper.click(driver, payableContanierxpath);
	}
	
	public void clickOnInvoice() {
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
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String actualBalanceDisplayed = Eventhelper.getTextofElement(driver, By.xpath("//*[contains(@class,'CompletedDashboard_completed-dashboard-item__amount__3En2r')]"));
	    String hopscotchBalance = actualBalanceDisplayed.substring(1);
		float amountBalance = Float.parseFloat(hopscotchBalance);
		return amountBalance;
	}
	
	public void enterInSearchBar(String searchPayables) {
		Eventhelper.sendkeys(driver, txtsearchBaronPayableTab, searchPayables);
	}

}
