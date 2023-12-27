package pages;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.github.javafaker.Faker;
import utility.*;

public class Externalinvoicepage {

	private WebDriver driver;
	private By rowInvoiceTableGrid = By
			.xpath("(//table[@role='presentation'])[2]//tr[1]//td[1]//span[contains(@class,'id_receivable')]");
	private By txtSearchBar = By.xpath("//input[@name='search']");
	private By txtSearchBarOnReceivable = By.xpath("//input[@id='receivableTabSearch']");
	private By btnAddNewBusiness = By.xpath("//span[contains(text(),'as a new contact')]");
	private By btnCrossIcon = By.xpath("//button[@aria-label='Close']");
	private By lblBusinessNameOnDashboard = By.xpath("//p[contains(@class,'InfoHeader_header')][1]");
	private By lblBusinessNameOnExternalInvoice = By
			.xpath("//div[contains(@class,'entity-short-card__info entity-short-card-info-title InvoicerDetails')]");
	private By txtbusinessname = By.xpath("//input[contains(@name ,'vendor')]");
	private By txtfirstname = By.xpath("//input[@name='firstName']");
	private By txtlastname = By.xpath("//input[contains(@name ,'lastName')]");
	private By txtemail = By.xpath("//input[@name='email']");
	private By txtCode = By.xpath("//input[@name='code']");
	private By btnCloseInvoiceInReceivable = By
			.xpath("//div[@class='InvoiceCard_transaction-card-header__wrapper__cpw4r']//button");
	private By btnGetPaidOnAddContact = By.xpath("//form//button[text()='Get paid']");
	private By lblCancelBanner = By.xpath("//p[@class='toast__message']");
	private By txtRoutingNumber = By.xpath("//input[@name='routingNumber']");
	private By txtAccountingNumber = By.xpath("//input[@name='accountNumber']");
	private By lblBankLogo = By.xpath("//img[contains(@class,'TextInput_input-icon')]");
	private By txtAccountingName = By.xpath("//input[@name='accountHoldersName']");
	private By lblInvoiceNoForCancelInvoice = By.xpath("(//span[contains(@class,'id_receivable')])[1]");

	private String txtCustomerName;
	private String tempEmailAddress;
	private String url;
	private String businessNameOnDashboard;
	private String fetchInvoiceid;

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
		Eventhelper.threadWait(1000);
		Log.info("Customer name is -->" + txtCustomerName);
		Eventhelper.useActionClassOperation(driver, txtSearchBarOnReceivable, Constants.DOUBLECLICK);
		// Eventhelper.sendkeys(driver, txtSearchBarOnReceivable, txtCustomerName);
		Eventhelper.sendkeywithJS(driver, txtSearchBarOnReceivable, txtCustomerName);
		Eventhelper.sendKeyboardKeys(driver, txtSearchBarOnReceivable, "backspace");
		url = generateExternalurl();
	}

	public void setURL() {
		Eventhelper.getURL(driver, url);
	}

	public void addBankDetails() {
		verificationPage.addBankExternalInvoice();
	}

	public String generateExternalurl() {
		Eventhelper.threadWait(2000);
		fetchInvoiceid = Eventhelper.getValueOfAttribute(driver, rowInvoiceTableGrid, "invoice-id");
		String fetchinvoiceeBizId = Eventhelper.getValueOfAttribute(driver, rowInvoiceTableGrid, "invoicee-biz-id");
		String externalURl = "external-payment?invoiceId=" + fetchInvoiceid + "&invoiceeBizId=" + fetchinvoiceeBizId
				+ "&emailId=" + tempEmailAddress;
		Log.info("The generated external url :- " + externalURl);
		String cancelInvoiceNo = Eventhelper.getValueOfAttribute(driver, lblInvoiceNoForCancelInvoice,
				"invoice-number");
		Log.info("Cancel invoice number is" + cancelInvoiceNo);
		return externalURl;
	}

	public boolean verifyExternalInvoiceNotificationOnDashboard(String typeOfNotificationForExternalInvoice) {
		if (typeOfNotificationForExternalInvoice.equalsIgnoreCase("SentExternalInvoice")) {
			return commonPage.isNotificationPresentInList(
					"You sent an invoice to " + txtCustomerName + ". We'll let you know once it's been paid.");
		} else if (typeOfNotificationForExternalInvoice.equalsIgnoreCase("MarkReceivedExternalInvoice")) {
			return commonPage.isNotificationPresentInList("An invoice to " + txtCustomerName
					+ " has been marked as paid. Didn't mean to do this? You can make changes on the Accounting page.");
		} else if (typeOfNotificationForExternalInvoice.equalsIgnoreCase("CancelledExternalInvoice")) {
			return commonPage.isNotificationPresentInList(
					"Invoice #" + fetchInvoiceid + " to " + txtCustomerName + " has been canceled.");
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
				.substring(0, Eventhelper.getTextofElement(driver, lblBusinessNameOnExternalInvoice).length());
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

	public void enterAuthCode() {
		Eventhelper.sendkeys(driver, txtCode, "5555");
	}

	public void selectPaymentMethod(String paymentMethod) {
		By btnPaymentMethod;
		if (paymentMethod.equalsIgnoreCase("Bank transfer")) {
			btnPaymentMethod = By.xpath("//span[normalize-space()='Bank transfer']");
		} else {
			btnPaymentMethod = By.xpath("//span[normalize-space()='Card payment']");
		}
		Eventhelper.clickElementwithjs(driver, btnPaymentMethod);
		Log.info("Clicked on is done ---->" + btnPaymentMethod);
	}

	public void selectBank(String bankType) {
		By btnBankType;
		commonPage.closePendoDialog();
		if (bankType.equalsIgnoreCase("plaid")) {
			btnBankType = By.xpath("//label[@for='Plaid']");
		} else {
			btnBankType = By.xpath("//label[@for='Direct']");
		}
		Eventhelper.waitUntilAttribValueContains(driver, By.xpath("//iframe[@title='Plaid Link']"), "title",
				"Plaid Link");
		Eventhelper.clickElementwithjs(driver, btnBankType);
		Log.info("Clicked on is done ---->" + btnBankType);
	}

	public void addBOAOauthBank() {
		commonPage.addBOA();
	}

	public void enterBankDetailManually(String buttonName) {
		By btnPayOrPaid;
		Eventhelper.sendkeys(driver, txtRoutingNumber, "063109935");
		Eventhelper.click(driver, txtAccountingNumber);
		Eventhelper.explicitwait(driver, lblBankLogo);
		Eventhelper.sendkeys(driver, txtAccountingNumber, "1454645465464");
		Eventhelper.sendkeys(driver, txtAccountingName, "Hop and company");
		if (buttonName.equalsIgnoreCase("Save and Pay")) {
			btnPayOrPaid = By.xpath("//button//span[contains(text(),'Pay')]");
		} else {
			btnPayOrPaid = By.xpath("//button//span[contains(text(),'paid')]");
		}
		Eventhelper.click(driver, btnPayOrPaid);
	}

	public void clickOnButton(String buttonName) {
		By btnName;
		if (buttonName.equalsIgnoreCase("Pay")) {
			btnName = By.xpath("//span[@class='label-pay']");
		} else {
			btnName = By.xpath("//span[@class='label-confirm-pay']");
		}
		Eventhelper.click(driver, btnName);
	}

	public void clickOnpay() {
		By btnName = By.xpath("//span[@class='label-confirm-pay']");
		Eventhelper.click(driver, btnName);
	}

	public void setEnvironmentURL() {
		Eventhelper.getURL(driver, "login");
	}

	public void clickonCloseIconfromReceivableCard() {
		if (Eventhelper.isElementDisplayed(driver, btnCloseInvoiceInReceivable)) {
			Eventhelper.click(driver, btnCloseInvoiceInReceivable);
		}
	}

	public void clickOnGetPaidButton() {
		Eventhelper.useActionClassOperation(driver, btnGetPaidOnAddContact, "Click");
	}

	public boolean isCancellBannerDisplayedOnTheScreen(String bannerMessage) {
		Log.info(bannerMessage);
		Log.info("This is the run time capture" + Eventhelper.getTextofElement(driver, lblCancelBanner));
		return bannerMessage.equals(Eventhelper.getTextofElement(driver, lblCancelBanner));
	}
}
