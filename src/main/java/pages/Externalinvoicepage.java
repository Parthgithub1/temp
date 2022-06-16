package pages;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.github.javafaker.Faker;
import utility.*;

public class Externalinvoicepage {

	private WebDriver driver;
	private Sendinvoicepage sendInvoicePage;
	private By rowInvoiceTableGrid = By.xpath("(//table)[2]//tr[1]//td[1]//span[@class='id_receivable']");
	private By txtSearchBar = By.xpath("//input[@name='search']");
	private By txtSearchBarOnReceivable = By.xpath("(//input[@aria-label='Search in the data grid'])[2]");
	private By btnAddNewBusiness = By.xpath("//span[normalize-space()='as a new business']");
	private By txtCustomerBusinessName = By.xpath("//input[@name='customerBusinessName']");
	private By txtCustomerFirstName = By.xpath("//input[@name='customerFirstName']");
	private By txtCustomerLastName = By.xpath("//input[@name='customerLastName']");
	private By txtCustomerEmail = By.xpath("//input[@name='customerEmail']");
	private By lblnotification;
	private By btnCrossIcon = By.xpath("//button[@aria-label='Close']");
	private By lblBusinessNameOnDashboard= By.xpath("//p[contains(@class,'InfoHeader_header')][1]");
	private By lblBusinessNameOnExternalInvoice=By.xpath("//div[@class='handle']//span[1]");
	private String txtCustomerName, tempEmailAddress, url,BusinessNameOnDashboard,BusinessNameOnExternalInvoice;
	Faker faker = new Faker();
	private Verificationpage verificationPage;
	static Propertyreader propertyreader = new Propertyreader();
	static Properties property = propertyreader.init_prop();

	public Externalinvoicepage(WebDriver driver) {
		this.driver = driver;
		verificationPage = new Verificationpage(driver);
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
		sendInvoicePage.switchToDashboard();
		Log.info("The generated external url :- " + externalURl);
		return externalURl;
	}

	public boolean verifyExternalInvoiceNotificationOnDashboard(String notificationContent) {
		lblnotification = By.xpath("(//div[@class='card-content']//p[contains(text(),'" + notificationContent
				+ "')]//span[contains(text(),'" + txtCustomerName + "')])[1]");
		return Eventhelper.isElementDisplayed(driver, lblnotification);
	}

	public void closeDialogbox() {
		Eventhelper.click(driver, btnCrossIcon);
	}

	public void readBusinessNameOndashboard()
	{
		Eventhelper.explicitwait(driver, lblBusinessNameOnDashboard);
		BusinessNameOnDashboard=Eventhelper.getTextofElement(driver, lblBusinessNameOnDashboard).substring(1);
		Log.info("BusinessNameOnDashboard is -->"+BusinessNameOnDashboard);
	}
	
	public Boolean verifyExternalInvoiceSender()
	{
		Boolean flag=false;
		Eventhelper.explicitwait(driver, lblBusinessNameOnExternalInvoice);
		BusinessNameOnExternalInvoice=(Eventhelper.getTextofElement(driver, lblBusinessNameOnExternalInvoice)).substring(1);
		Log.info("BusinessNameOnExternalInvoice is -->"+BusinessNameOnExternalInvoice);
		if (BusinessNameOnDashboard.equals(BusinessNameOnExternalInvoice)) {
			flag=true;
		}
		return flag;
	}
}
