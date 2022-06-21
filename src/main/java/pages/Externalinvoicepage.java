package pages;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.github.javafaker.Faker;
import utility.*;

public class Externalinvoicepage {

	private WebDriver driver;
	private Commonpage commonPage;
	private By rowInvoiceTableGrid = By.xpath("(//table)[2]//tr[1]//td[1]//span[@class='id_receivable']");
	private By txtSearchBar = By.xpath("//input[@name='search']");
	private By txtSearchBarOnReceivable = By.xpath("(//input[@aria-label='Search in the data grid'])[2]");
	private By btnAddNewBusiness = By.xpath("//span[normalize-space()='as a new business']");
	private By btnCrossIcon = By.xpath("//button[@aria-label='Close']");
	private By lblBusinessNameOnDashboard = By.xpath("//p[contains(@class,'InfoHeader_header')][1]");
	private By lblBusinessNameOnExternalInvoice = By.xpath("//div[@class='handle']//span[1]");
	private String txtCustomerName;
	private String tempEmailAddress;
	private String url;
	private String businessNameOnDashboard;

	Faker faker = new Faker();
	private Verificationpage verificationPage;
	static Propertyreader propertyreader = new Propertyreader();
	static Properties property = propertyreader.init_prop();

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
		commonPage.switchToDashboard();
		Log.info("The generated external url :- " + externalURl);
		return externalURl;
	}

	public boolean verifyExternalInvoiceNotificationOnDashboard(String notificationContent) {
		By lblnotification = By.xpath("(//div[@class='card-content']//p[contains(text(),'" + notificationContent
				+ "')]//span[contains(text(),'" + txtCustomerName + "')])[1]");
		return Eventhelper.isElementDisplayed(driver, lblnotification);
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
		By txtbusinessname = By.xpath("//input[contains(@name ,'vendor')]");
		By txtfirstname = By.xpath("//input[@name='firstName']");
		By txtlastname = By.xpath("//input[contains(@name ,'lastName')]");
		By txtemail = By.xpath("//input[@name='email']");
		txtCustomerName = faker.name().firstName();
		Eventhelper.useActionClassOperation(driver, txtbusinessname, Constants.DOUBLECLICK);
		Eventhelper.sendkeys(driver, txtbusinessname, txtCustomerName);
		Eventhelper.sendkeys(driver, txtfirstname, faker.name().firstName());
		Eventhelper.sendkeys(driver, txtlastname, faker.name().lastName());
		tempEmailAddress = txtCustomerName + Constants.MAILINATORDOTCOM;
		Eventhelper.sendkeys(driver, txtemail, tempEmailAddress);
	}
}
