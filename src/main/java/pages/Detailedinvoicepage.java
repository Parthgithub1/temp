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
	private By txtSubTotal = By.xpath("//div[contains(text(),'Sub-total')]//parent::div//following-sibling::div//div");
	private By btnCloseInvoice = By.xpath("(//button[contains(@class,'CloseButton_close-button')])[1]");
	private By txtTaxAmountAdded = By.xpath("//div[contains(text(),'Tax')]//parent::div//following-sibling::div//div");
	private By txtAddTaxRate = By.xpath("//input[@name='tax-rate']");
	private By txtDescriptionArea= By.xpath("//textarea[@name='description']");
	private By btnShareLinkInPayable= By.xpath("(//button[normalize-space()='Share Link'])[1]");
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
		Eventhelper.threadWait(2000);
	}

	public void enterMultipleItemsInBill() {
		int noOfRow = Eventhelper.findElements(driver, txtDescriptionArea).size();
		int quantity = 2;
		int rate = 2;
		for (int i = 1; i <= noOfRow; i++) {
			itemDescription = faker.food().ingredient();
			Eventhelper.sendkeys(driver, By.xpath("//tr[" + i + "]//textarea[@name='description']"), itemDescription);
			Eventhelper.sendkeys(driver, By.xpath("//tr[" + i + "]//input[@name='quantity']"),
					String.valueOf(quantity));
			Eventhelper.sendkeys(driver, By.xpath("//tr[" + i + "]//input[@name='rate']"), String.valueOf(rate));
			Eventhelper.click(driver, By.xpath("//tr[" + i + "]//div[contains(@class,'InvoiceForm_itemAmount')]"));
		}
		amountOfItems = quantity * rate * noOfRow;
		Log.info("Total value of amountOfItems "+amountOfItems);
	}
	
	public void enterMultipleItemsInDetailedInvoice() {
		int noOfRow = Eventhelper.findElements(driver, txtDescriptionArea).size();
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
		Log.info("Total value of amountOfItems "+amountOfItems);
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
		float expectedAmtValue = Float.parseFloat(Eventhelper.getValueOfAttribute(driver, txtItemQuantity, Constants.VALUE))
				* Float.parseFloat(Eventhelper.getValueOfAttribute(driver, txtItemRate, Constants.VALUE));

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
		countOfRowAdded = Eventhelper.findElements(driver, txtDescriptionArea).size();
		Eventhelper.sendkeys(driver, By.xpath("//tr[3]//textarea[@name='description']"), faker.food().ingredient());
		Eventhelper.click(driver, By.xpath("//tr[3]//button"));
	}

	public Boolean isRowDeleted() {
		// Here 1 is a count of deleted row of item in detailed invoice.
		Eventhelper.threadWait(2000);
		return (countOfRowAdded-1) == Eventhelper.findElements(driver, txtDescriptionArea).size();
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
				.equalsIgnoreCase(Eventhelper.getValueOfAttribute(driver, invoiceDueDate, Constants.VALUE));
	}
	
	public void clickOnShareLinkButtonInPayable()
	{
		Eventhelper.click(driver,btnShareLinkInPayable);
	}
}
