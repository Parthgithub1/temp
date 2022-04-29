package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.Eventhelper;
import utility.Log;

public class Payinvoicepage {
	private WebDriver driver;

	public Payinvoicepage(WebDriver driver) {
		this.driver = driver;		
	}
	
	public float getexistingBalanceofPayableofHomePage() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String actualBalanceDisplayedofPayableonHomePage = Eventhelper.getTextofElement(driver, By.xpath("//span[contains(.,'Payable')]/following-sibling::div/span"));
	    String hopscotchBalanceofHomePageforPayables = actualBalanceDisplayedofPayableonHomePage.substring(1);
		float amountBalanceofPayablesonHomePage = Float.parseFloat(hopscotchBalanceofHomePageforPayables);
		Log.info("Pay Amount on Home Page" + amountBalanceofPayablesonHomePage);
		return amountBalanceofPayablesonHomePage;
	}
	
	public float getexistingBalanceofPayableonAccountingPage() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String actualBalanceDisplayedofPayableonAccountingPage = Eventhelper.getTextofElement(driver, By.xpath("//*[contains(@class,'PayableReceivableContent_payable-receivable__amount__1OW1E')]"));
	    String hopscotchBalanceonAccoutingPageforPayables = actualBalanceDisplayedofPayableonAccountingPage.substring(1);
		float amountBalanceonAccountingPageforPayables = Float.parseFloat(hopscotchBalanceonAccoutingPageforPayables);
		Log.info("Pay Amount on Accounting Page" + amountBalanceonAccountingPageforPayables);
		return amountBalanceonAccountingPageforPayables;
	}
	
	public float invoiceAmountUserPaying() {
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
	
	public void selectDate() {
		
	}

}
