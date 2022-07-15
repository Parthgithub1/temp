package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.Constants;
import utility.Eventhelper;

public class Invoiceschedulingpage {
	private WebDriver driver;

	private By txtDatePicker = By.xpath("//input[@name='payDate']");
	private By logoOfSchedulerForInvoice = By.xpath("//span[contains(@class,'entity-logo__icon')]//div");

	public Invoiceschedulingpage(WebDriver driver) {
		this.driver = driver;
	}

	public void selectSchedulePaymentDate() {
		Eventhelper.click(driver, txtDatePicker);
		Eventhelper.useActionClassOperation(driver, txtDatePicker, Constants.DOUBLECLICK);
		Eventhelper.sendkeys(driver, txtDatePicker, Eventhelper.getDate(31));
	}

	public Boolean isInvoiceSchedule() {
		return Eventhelper.isElementDisplayed(driver, logoOfSchedulerForInvoice);
	}
}
