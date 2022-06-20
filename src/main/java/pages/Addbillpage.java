package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.github.javafaker.Faker;
import utility.*;

public class Addbillpage {
	private WebDriver driver;
	private Sendinvoicepage sendInvoicePage;
	private By txtVendor = By.xpath("//input[@name='vendor']");
	private By selectVendor = By.xpath("//span[contains(text(),'as a new business')]");
	private By txtContactName = By.xpath("//input[@name='contactName']");
	private By txtEmail = By.xpath("//input[@name='email']");
	private By txtAmount = By.xpath("//input[@name='amount']");
	private By txtInvoiceNumber = By.xpath("//input[@name='invoiceNumber']");
	private By txtDate = By.xpath("//input[@placeholder='MM/DD/YYYY']");
	private By txtMessage = By.xpath("//textarea[@name='message']");
	private By txtSearchBaronPayableTab = By.xpath("(//input[@aria-label='Search in the data grid'])[1]");
	private By btnCloseOfPayableCard = By.xpath("(//button[contains(@class,'close-btn')])[1]");
	private By lblNotification;
	Faker faker = new Faker();
	String vender;

	public Addbillpage(WebDriver driver) {
		this.driver = driver;
		sendInvoicePage = new Sendinvoicepage(driver);
	}

	public float addBill() {
		vender = faker.name().firstName();
		Eventhelper.sendkeys(driver, txtVendor, vender);
		Eventhelper.click(driver, selectVendor);
		Eventhelper.sendkeys(driver, txtContactName, vender);
		String tempEmail = vender + "@mailinator.com";
		Eventhelper.sendkeys(driver, txtEmail, tempEmail);
		Eventhelper.sendkeys(driver, txtAmount, "1");
		Eventhelper.sendkeys(driver, txtInvoiceNumber, "1001");
		Eventhelper.sendkeys(driver, txtDate, Eventhelper.getTodaysDateInSting());
		Eventhelper.sendkeys(driver, txtMessage, "This is the add bill details.");
		return (float) 1.0;
	}

	public void searchBusinessInSearchBar() {
		Eventhelper.sendkeys(driver, txtSearchBaronPayableTab, vender);
	}

	public void clearBusinessInSearchBar() {
		Eventhelper.threadWait(3000);
		Eventhelper.sendKeyboardKeys(driver, txtSearchBaronPayableTab, "backspace");
	}

	public boolean verifyNotificationOfPayOfAddedBill() {
		sendInvoicePage.switchToDashboard();
		lblNotification = By.xpath(
				"(//div[@class='card-content']//p[contains(text(),'It is on its way to')]//span[contains(text(),'"
						+ vender + "')])[1]");
		return Eventhelper.isElementDisplayed(driver, lblNotification);
	}

	public boolean verifyAddBillNotificationOnDashboard() {
		Eventhelper.threadWait(5000);
		sendInvoicePage.switchToDashboard();
		lblNotification = By.xpath(
				"(//div[@class='card-content']//p[contains(text(),'sent an invoice for')]//span[contains(text(),'"
						+ vender + "')])[1]");
		Eventhelper.explicitwait(driver, lblNotification);
		return Eventhelper.isElementDisplayed(driver, lblNotification);
	}

	public void clickonCloseIconfromPayableCard() {
		if (Eventhelper.isElementDisplayed(driver, btnCloseOfPayableCard)) {
			Eventhelper.click(driver, btnCloseOfPayableCard);
		}
	}
}
