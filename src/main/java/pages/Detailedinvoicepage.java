package pages;

import org.openqa.selenium.*;
import com.github.javafaker.Faker;
import utility.*;

public class Detailedinvoicepage {

	private WebDriver driver;
	private By txtItemDescriptionForInvoice = By.xpath("//textarea[@name='description']");
	private By txtItemQuantity = By.xpath("//input[@name='quantity']");
	private By txtItemRate = By.xpath("//input[@name='rate']");
	private By btnDueDate = By.xpath("//div/input[@name='detailedDueDate']");
	private By btnInvoiceDate = By.xpath("//div/input[@name='detailedInvoiceDate']");
//	private By radioButtonOfTax = By.xpath("//input[@id='taxed']");
	private By amountTotal = By.xpath("//div[contains(@class,'InvoiceForm_itemAmount')]");
	private By txtSubTotal = By.xpath("//div[contains(@class,'InvoiceForm_invoice-sub_total')]//span");
	private By btnCloseInvoice = By.xpath("(//button[contains(@class,'CloseButton_close-button')])[1]");
	Faker faker = new Faker();
	String itemDescription = faker.food().ingredient();

	public Detailedinvoicepage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnDetailedInvoiceToggle(String invoiceType) {
		By toggleDetailedInvoiceButton = By.xpath("//label[normalize-space()='" + invoiceType + "']");
		Eventhelper.click(driver, toggleDetailedInvoiceButton);
	}

	public void clickOnAddTaxButtonAndEnterTax(String addTaxButton) {
		Eventhelper.click(driver, By.xpath("(//button[normalize-space()='" + addTaxButton + "'])[1]"));
		Eventhelper.sendkeys(driver, By.xpath("(//p[contains(text(),'Tax Rate')]/following-sibling::div//input)[1]"),
				"15");
	}

	public void enterDetailsOfItemForInvoice() {
		Eventhelper.sendkeys(driver, btnInvoiceDate, Eventhelper.getDate(0));
		Eventhelper.sendkeys(driver, btnDueDate, Eventhelper.getDate(0));
		Eventhelper.sendkeys(driver, txtItemDescriptionForInvoice, itemDescription);
		Eventhelper.sendkeys(driver, txtItemQuantity, "2");
		Eventhelper.sendkeys(driver, txtItemRate, "2");
//		Eventhelper.click(driver, radioButtonOfTax);
	}

	public Boolean isIteamAmountAndSubtotalAmountMatched() {
		return Eventhelper.getTextofElement(driver, amountTotal).replace("$", "")
				.equals(Eventhelper.getTextofElement(driver, txtSubTotal).replace("$", ""));
	}

	public Boolean isIteamAmountMatchedWithRateAndQty() {
		float expectedAmtValue = Float.parseFloat(Eventhelper.getValueOfAttribute(driver, txtItemQuantity, "value"))
				* Float.parseFloat(Eventhelper.getValueOfAttribute(driver, txtItemRate, "value"));
		float actualAmtValue = Float.parseFloat(Eventhelper.getTextofElement(driver, amountTotal).replace("$", ""));
		return expectedAmtValue == actualAmtValue;
	}

	public void viewInvoicewithDetailedView(String viewInvoiceLabel) {
		Eventhelper.click(driver, By.xpath("//div[contains(text(),'" + viewInvoiceLabel + "')]"));
	}

	public void closeInvoice() {
		Eventhelper.click(driver, btnCloseInvoice);
	}

	public Boolean verificationOfDeatilsAddedInInvoice() {
		By iteamName = By.xpath("(//table)[2]//tr//td//p[1]");
		return itemDescription.equals(Eventhelper.getTextofElement(driver, iteamName));
	}
}
