package pages;

import java.util.Properties;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;

import utility.Eventhelper;
import utility.Log;
import utility.Propertyreader;

public class Externalinvoicepage {

	private WebDriver driver;
	private Sendinvoicepage sendInvoicePage;
	private By tblInvoiceTableGrid = By.xpath("(//table)[2]//tr[1]//td");
	private By rowInvoiceTableGrid = By.xpath("(//table)[2]//tr[1]//td[1]//span[@class='id_receivable']");
	private By lnkSendInvoice = By.xpath("//span[contains(@class,'Button_btn__icon')]//*[name()='svg']");
	private By btnDueDateOnReceivable = By.xpath("(//p[contains(text(),'Due date')])[2]");
	private By txtSearchBar = By.xpath("//input[@name='search']");
	private By txtSearchBarOnReceivable = By.xpath("(//input[@aria-label='Search in the data grid'])[2]");
	private By btnAddNewBusiness = By.xpath("//span[normalize-space()='as a new business']");
	private By txtCustomerBusinessName = By.xpath("//input[@name='customerBusinessName']");
	private By txtCustomerFirstName = By.xpath("//input[@name='customerFirstName']");
	private By txtCustomerLastName = By.xpath("//input[@name='customerLastName']");
	private By txtCustomerEmail = By.xpath("//input[@name='customerEmail']");
	// private By txtInvoiceDate = By.xpath("//input[@placeholder='Due Date']");
	private By lblPagetitle = By.xpath("//title[normalize-space()='External Payment - Hopscotch']");
	private By lblAccounting = By.xpath("//h1[normalize-space()='Accounting']");
	private By lblnotification;
	private By btnCrossIcon= By.xpath("//button[@aria-label='Close']");
	private String txtCustomerName, tempEmailAddress, url;
	Faker faker = new Faker();
	Registrationpage registrationPage;
	Verificationpage verificationPage;
	static Propertyreader propertyreader = new Propertyreader();
	static Properties property = propertyreader.init_prop();

	public Externalinvoicepage(WebDriver driver) {
		this.driver = driver;
		registrationPage= new Registrationpage(driver);
		verificationPage= new Verificationpage(driver);
		sendInvoicePage = new Sendinvoicepage(driver);
	}

	public void clickToAddNewBusiness() {
		Eventhelper.sendkeys(driver, txtSearchBar, "Search for new business");
		Eventhelper.click(driver, btnAddNewBusiness);
	}

	public void enterCustomerDetails() {
		txtCustomerName = faker.name().firstName();
		Eventhelper.sendkeys(driver, txtCustomerBusinessName, txtCustomerName);
		Eventhelper.sendkeys(driver, txtCustomerFirstName, "Donald");
		Eventhelper.sendkeys(driver, txtCustomerLastName, "Trump");
		tempEmailAddress = txtCustomerName + "@mailinator.com";
		Eventhelper.sendkeys(driver, txtCustomerEmail, tempEmailAddress);
	}

	public void searchBusinessInGrid() {
		Log.info("Customer name is -->" + txtCustomerName);
		Eventhelper.sendkeys(driver, txtSearchBarOnReceivable, txtCustomerName);
		// Eventhelper.click(driver, btnDueDateOnReceivable);
		url = generateExternalurl();
	}
	
	public void setURL() {
		Eventhelper.getURL(driver, url);
	}
	
	public void enterOTP() {
		registrationPage.enterOTP();
	}
	
	public void addBankDetails() {
		verificationPage.addBankExternalInvoice();
	}

	public String generateExternalurl() {
		
		String fetchInvoiceid=Eventhelper.getValueOfAttribute(driver, rowInvoiceTableGrid, "id");
		String externalURl = "external-payment?invoiceId=" + fetchInvoiceid + "&invoiceeBizId=80f4125&emailId="
				+ tempEmailAddress;
		sendInvoicePage.switchToDashboard();
		// String externalURl=
		// "https://dev.zurohq.com/external-payment?invoiceId="+fetchInvoiceid()+"&dba=hopsmokeautomation1llc&emailId="+tempEmailAddress;
		return externalURl;
	}

	private String fetchInvoiceid() {
		return Eventhelper.getValueOfAttribute(driver, rowInvoiceTableGrid, "id");
	}
	
	public boolean verifyExternalInvoiceNotificationOnDashboard(String notificationContent) {
		//Eventhelper.threadWait(3000);
		lblnotification = By.xpath(
				"(//div[@class='card-content']//p[contains(text(),'"+notificationContent+"')]//span[contains(text(),'"
						+ txtCustomerName + "')])[1]");
	//	Eventhelper.explicitwait(driver, lblnotification);
		return Eventhelper.isElementDisplayed(driver, lblnotification);
	}
	public void closeDialogbox() {
		Eventhelper.click(driver, btnCrossIcon);
	}
	
	public void setLoginPageURL() {
		Eventhelper.getURL(driver, property.getProperty("dev") );
	}
}
