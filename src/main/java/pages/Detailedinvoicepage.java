package pages;

import org.openqa.selenium.*;
import com.github.javafaker.Faker;
import utility.*;

public class Detailedinvoicepage {

	private WebDriver driver;
	private By invoiceDateSelector = By.xpath("//input[@name='detailedInvoiceDate']");
	private By invoiceDueDate = By.xpath("//input[@name='detailedDueDate']");
	private By drpPaymentTerms = By.xpath("//div[contains(@class,'select__form-field__placeholder')]");
	private By txtItemQuantity = By.xpath("//input[@name='quantity']");
	private By txtItemRate = By.xpath("//input[@name='rate']");
	private By amountTotal = By.xpath("//div[contains(@class,'InvoiceForm_itemAmount')]");
	private By txtSubTotal = By.xpath("//div[contains(@class,'InvoiceForm_invoice-sub_total')]//span");
	private By btnCloseInvoice = By.xpath("(//button[contains(@class,'CloseButton_close-button')])[1]");
	private By txtTaxAmountAdded = By.xpath("(//div[contains(@class,'InvoiceForm_invoice-tax')])[1]//span");
	private By txtAddTaxRate = By.xpath("(//p[contains(text(),'Tax Rate')]/following-sibling::div//input)[1]");
	Faker faker = new Faker();
	int amountOfItems;
	int countOfRowAdded;
	float taxRateAmount;
	String itemDescription;

	public Detailedinvoicepage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnDetailedInvoiceToggle(String invoiceType) {
		By toggleDetailedInvoiceButton = By.xpath("//label[normalize-space()='" + invoiceType + "']");
		Eventhelper.click(driver, toggleDetailedInvoiceButton);
	}

	public void clickOnAddTaxButtonAndEnterTax(String addTaxButton, float taxRate) {
		Eventhelper.click(driver, By.xpath("(//button[normalize-space()='" + addTaxButton + "'])[1]"));
		taxRateAmount = taxRate;
		Eventhelper.sendkeys(driver, txtAddTaxRate, String.valueOf(taxRate));
	}

	public void enterMultipleItemsInInvoice() {
		int noOfRow = Eventhelper.findElements(driver, By.xpath("//textarea[@name='description']")).size();
		int quantity = 2;
		int rate = 2;
		for (int i = 1; i <= noOfRow; i++) {
			itemDescription = faker.food().ingredient();
			Eventhelper.sendkeys(driver, By.xpath("//tr[" + i + "]//textarea[@name='description']"), itemDescription);
			Eventhelper.sendkeys(driver, By.xpath("//tr[" + i + "]//input[@name='quantity']"),
					String.valueOf(quantity));
			Eventhelper.sendkeys(driver, By.xpath("//tr[" + i + "]//input[@name='rate']"), String.valueOf(rate));
			Eventhelper.click(driver, By.xpath("//tr[" + i + "]//div[contains(@class,'Checkbox_checkbox-control')]"));
			Eventhelper.click(driver, By.xpath("//tr[" + i + "]//div[contains(@class,'InvoiceForm_itemAmount')]"));
		}
		amountOfItems = quantity * rate * noOfRow;
	}

	public Boolean isIteamAmountAndSubtotalAmountMatched() {
		String subtotal = Eventhelper.getTextofElement(driver, txtSubTotal).replace("$", "");
		return amountOfItems == Integer.parseInt(subtotal.substring(0, subtotal.indexOf(".")));
	}

	public Boolean isTaxAmountAdded() {
		return (amountOfItems * taxRateAmount) / 100 == Float
				.parseFloat(Eventhelper.getTextofElement(driver, txtTaxAmountAdded).replace("$", ""));
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
		By iteamName = By.xpath("(//p[contains(text(),'" + itemDescription + "')])[1]");
		return itemDescription.equals(Eventhelper.getTextofElement(driver, iteamName));
	}

	public void deleteRowAdded() {
		countOfRowAdded = Eventhelper.findElements(driver, By.xpath("//textarea[@name='description']")).size();
		Eventhelper.sendkeys(driver, By.xpath("//tr[3]//textarea[@name='description']"), faker.food().ingredient());
		Eventhelper.click(driver, By.xpath("(//button[@type='button'])[4]"));
	}

	public Boolean isRowDeleted() {
		// Here 1 is a count of deleted row of item in detailed invoice.
		return (countOfRowAdded - 1) == Eventhelper.findElements(driver, By.xpath("//textarea[@name='description']"))
				.size();
	}

	public void setDateForInvoices(int paymentTermsPeriod) {
		Eventhelper.click(driver, invoiceDateSelector);
		Eventhelper.sendkeys(driver, invoiceDateSelector, Eventhelper.getDate(0));
		Eventhelper.click(driver, drpPaymentTerms);
		By paymentTerms = By.xpath("//div[text()='Net " + paymentTermsPeriod + "']");
		Eventhelper.click(driver, paymentTerms);
	}

	public Boolean paymentTermsDate(int dueDate) {
		return Eventhelper.getDate(dueDate)
				.equalsIgnoreCase(Eventhelper.getValueOfAttribute(driver, invoiceDueDate, "value"));
	}
}
