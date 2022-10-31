package pages;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.github.javafaker.Faker;
import utility.*;

public class Externalinvoicepage {

	private WebDriver driver;
	private By rowInvoiceTableGrid = By.xpath("(//table)[2]//tr[1]//td[1]//span[@class='id_receivable']");
	private By txtSearchBar = By.xpath("//input[@name='search']");
	private By txtSearchBarOnReceivable = By.xpath("(//input[@aria-label='Search in the data grid'])[2]");
	private By btnAddNewBusiness = By.xpath("//span[contains(text(),'as a new contact to pay or get paid')]");
	private By btnCrossIcon = By.xpath("//button[@aria-label='Close']");
	private By lblBusinessNameOnDashboard = By.xpath("//p[contains(@class,'InfoHeader_header')][1]");
	private By lblBusinessNameOnExternalInvoice = By.xpath("//div[@class='handle']//span[1]");
	private By txtbusinessname = By.xpath("//input[contains(@name ,'vendor')]");
	private By txtfirstname = By.xpath("//input[@name='firstName']");
	private By txtlastname = By.xpath("//input[contains(@name ,'lastName')]");
	private By txtemail = By.xpath("//input[@name='email']");
	private String txtCustomerName;
	private String tempEmailAddress;
	private String url;
	private String businessNameOnDashboard;

	Faker faker = new Faker();
	private Verificationpage verificationPage;
	private Commonpage commonPage;
	static Propertyreader propertyreader = new Propertyreader();
	static Properties property = propertyreader.initProp();

	public Externalinvoicepage(WebDriver driver) {
		this.driver = driver;
		verificationPage = new Verificationpage(driver);
		commonPage = new Commonpage(driver);
	}

	public void clickToAddNewBusiness() {
		Eventhelper.sendkeys(driver, txtSearchBar, "Search for new business");
		Eventhelper.click(driver, btnAddNewBusiness);
	}

	public void searchBusinessInGrid() {
		Log.info("Customer name is -->" + txtCustomerName);
		Eventhelper.sendkeys(driver, txtSearchBarOnReceivable, txtCustomerName);
		url = generateExternalurl();
	}

	public void setURL() {
		Eventhelper.getURL(driver, url);
	}

	public void addBankDetails() {
		verificationPage.addBankExternalInvoice();
	}

	public String generateExternalurl() {
		String fetchInvoiceid = Eventhelper.getValueOfAttribute(driver, rowInvoiceTableGrid, "invoice-id");
		String fetchinvoiceeBizId = Eventhelper.getValueOfAttribute(driver, rowInvoiceTableGrid, "invoicee-biz-id");
		String externalURl = "external-payment?invoiceId=" + fetchInvoiceid + "&invoiceeBizId=" + fetchinvoiceeBizId
				+ "&emailId=" + tempEmailAddress;
		Log.info("The generated external url :- " + externalURl);
		return externalURl;
	}

	public boolean verifyExternalInvoiceNotificationOnDashboard(String typeOfNotificationForExternalInvoice) {
		if (typeOfNotificationForExternalInvoice.equalsIgnoreCase("SentExternalInvoice")) {
			return commonPage.isNotificationPresentInList(
					"You sent an invoice to " + txtCustomerName + ". We'll let you know once it's been paid.");
		} else {
			return commonPage.isNotificationPresentInList(
					txtCustomerName + " paid your invoice. Your Hopscotch Balance has been updated.");
		}
	}

	public void closeDialogbox() {
		Eventhelper.click(driver, btnCrossIcon);
	}

	public void readBusinessNameOndashboard() {
		Eventhelper.explicitwait(driver, lblBusinessNameOnDashboard);
		businessNameOnDashboard = Eventhelper.getTextofElement(driver, lblBusinessNameOnDashboard).substring(1);
		Log.info("BusinessNameOnDashboard is -->" + businessNameOnDashboard);
	}

	public Boolean verifyExternalInvoiceSender() {
		Boolean flag = false;
		Eventhelper.explicitwait(driver, lblBusinessNameOnExternalInvoice);
		String businessNameOnExternalInvoice = (Eventhelper.getTextofElement(driver, lblBusinessNameOnExternalInvoice))
				.substring(1);
		Log.info("BusinessNameOnExternalInvoice is -->" + businessNameOnExternalInvoice);
		if (businessNameOnDashboard.equals(businessNameOnExternalInvoice)) {
			flag = true;
		}
		return flag;
	}

	public void enterConrtactDetails() {
		txtCustomerName = faker.name().firstName();
		Eventhelper.useActionClassOperation(driver, txtbusinessname, Constants.DOUBLECLICK);
		Eventhelper.sendkeys(driver, txtbusinessname, txtCustomerName);
		Eventhelper.sendkeys(driver, txtfirstname, faker.name().firstName());
		Eventhelper.sendkeys(driver, txtlastname, faker.name().lastName());
		tempEmailAddress = txtCustomerName + Constants.MAILINATORDOTCOM;
		Eventhelper.sendkeys(driver, txtemail, tempEmailAddress);
	}

	public void enterBusinessName(String businessName) {
		Eventhelper.useActionClassOperation(driver, txtbusinessname, Constants.DOUBLECLICK);
		Eventhelper.sendkeys(driver, txtbusinessname, businessName);
	}

	public void enterFirstName(String firstName) {
		Eventhelper.useActionClassOperation(driver, txtfirstname, Constants.DOUBLECLICK);
		Eventhelper.sendkeys(driver, txtfirstname, firstName);
	}

	public void enterLastName(String lastName) {
		Eventhelper.useActionClassOperation(driver, txtlastname, Constants.DOUBLECLICK);
		Eventhelper.sendkeys(driver, txtlastname, lastName);
	}

	public void enterEmail(String email) {
		Eventhelper.useActionClassOperation(driver, txtemail, Constants.DOUBLECLICK);
		Eventhelper.sendkeys(driver, txtemail, email);
	}

	public void performTabOnField(String field) {
		if (field.equalsIgnoreCase("first name")) {
			Eventhelper.sendKeyboardKeys(driver, txtfirstname, "tab");
		} else if (field.equalsIgnoreCase("last name")) {
			Eventhelper.sendKeyboardKeys(driver, txtlastname, "tab");
		} else if (field.equalsIgnoreCase("email")) {
			Eventhelper.sendKeyboardKeys(driver, txtemail, "tab");
		} else if (field.equalsIgnoreCase("businessname")) {
			Eventhelper.useActionClassOperation(driver, txtbusinessname, Constants.DOUBLECLICK);
			Eventhelper.sendKeyboardKeys(driver, txtbusinessname, "tab");
		}
	}
}
