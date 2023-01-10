package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.github.javafaker.Faker;
import utility.*;

public class Addbillpage {
	private WebDriver driver;
	private Commonpage commonPage;
	private By txtEmail = By.xpath("//input[@name='email']");
	private By txtAmount = By.xpath("//input[@name='amount']");
	private By txtInvoiceNumber = By.xpath("//input[@name='invoiceNumber']");
	private By txtDate = By.xpath("//input[@name='dueDate']");
	private By txtMessage = By.xpath("//textarea[@name='message']");
	private By txtSearchBaronPayableTab = By.xpath("(//input[@aria-label='Search in the data grid'])[1]");
	private By btnCloseOfPayableCard = By.xpath("(//button[contains(@class,'close-btn')])[1]");
	private By txtFirstName = By.xpath(" //input[@name='firstName']");
	private By txtLastName = By.xpath("//input[@name='lastName']");
	private By txtSearchBar = By.xpath("//input[@name='search']");
	private By btnAddNewBusiness = By.xpath("//span[contains(text(),'as a new contact')]");
	private By btnPayOnAddContact= By.xpath("(//form//button)[1]");

	private By lblNotification;
	Faker faker = new Faker();
	String vender;
	String tempEmail;
	String externalURlForBill;
	
	public Addbillpage(WebDriver driver) {
		this.driver = driver;
		commonPage = new Commonpage(driver);
	}

	public float addBill() {
		Eventhelper.sendkeys(driver, txtAmount, "2");
		Eventhelper.sendkeys(driver, txtInvoiceNumber, "1001");
		Eventhelper.sendkeys(driver, txtDate, Eventhelper.getDate(0));
		Eventhelper.sendkeys(driver, txtMessage, "This is the add bill details.");
		return (float) 2.0;
	}
	
	public void addOterDetailsForBill() {
		Eventhelper.sendkeys(driver, txtAmount, "43424242342");
		Eventhelper.sendkeys(driver, txtInvoiceNumber, "1001");
		Eventhelper.sendkeys(driver, txtDate, Eventhelper.getDate(0));
		Eventhelper.sendkeys(driver, txtMessage, "BusinessInvoiceLimit was exceeded. display on the screen when user click on add");
	}

	public void addBillContact() {
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		Eventhelper.sendkeys(driver, txtFirstName, firstName);
		Eventhelper.sendkeys(driver, txtLastName, lastName);
		tempEmail = firstName + lastName + "@mailinator.com";
		Eventhelper.sendkeys(driver, txtEmail, tempEmail);
		Eventhelper.sendKeyboardKeys(driver, txtEmail, "tab");
	}

	public void searchBusinessInSearchBar() {
		Eventhelper.click(driver, txtSearchBar);
		vender = faker.company().name();
		Eventhelper.sendkeys(driver, txtSearchBar, vender);
		Eventhelper.click(driver, btnAddNewBusiness);
	}

	public void clearBusinessInSearchBar() {
		Eventhelper.threadWait(3000);
		Eventhelper.sendKeyboardKeys(driver, txtSearchBaronPayableTab, "backspace");
	}

	public boolean verifyNotificationOfPayOfAddedBill() {
		return commonPage.isNotificationPresentInList("Your payment to " + vender + " is on its way!");
	}

	public boolean verifyAddBillNotificationOnDashboard() {
		Eventhelper.threadWait(5000);
		return commonPage.isNotificationPresentInList(vender + " sent you an invoice.");
	}

	public void clickonCloseIconfromPayableCard() {
		if (Eventhelper.isElementDisplayed(driver, btnCloseOfPayableCard)) {
			Eventhelper.click(driver, btnCloseOfPayableCard);
		}
	}

	public void enterInSearchBar() {
		By txtSearchBaronAccountingSection = By.xpath("(//input[@aria-label='Search in the data grid'])[1]");
		Eventhelper.sendkeys(driver, txtSearchBaronAccountingSection, vender);
		genererateBillURL();
	}
	
	public void genererateBillURL()
	{
		By rowBillInvoiceTableGrid = By.xpath("(//table)[1]//tr[1]//td[1]//span[contains(@class,'id_payable')]");
		String fetchInvoiceid = Eventhelper.getValueOfAttribute(driver, rowBillInvoiceTableGrid, "invoice-id");
		String fetchinvoiceeBizId = Eventhelper.getValueOfAttribute(driver, rowBillInvoiceTableGrid, "invoicee-biz-id");
	    externalURlForBill = "receivable-payment?invoiceId=" + fetchInvoiceid + "&invoicedBizId=" + fetchinvoiceeBizId
				+ "&emailId=" + tempEmail;
		Log.info("The generated external url for the bill is  :- " + externalURlForBill);
	}
	
	public void setURL()
	{
		Eventhelper.getURL(driver, externalURlForBill);
	}

	public void enterAmount(String amount) {
		Eventhelper.sendkeys(driver, txtAmount, amount);
	}

	public void enterInvoiceNumber(String invoiceNumber) {
		Eventhelper.sendkeys(driver, txtInvoiceNumber, invoiceNumber);
	}

	public boolean isDeleteInvoiceNotificationSent() {
		String deleteInvoiceNotificationText= "You rejected "+vender+"'s invoice.";	
		return commonPage.isNotificationPresentInList(deleteInvoiceNotificationText);
	}
	
	public void clickOnPayButtonOnAddContact()
	{
		Eventhelper.useActionClassOperation(driver,btnPayOnAddContact,"Click");
	}
}
