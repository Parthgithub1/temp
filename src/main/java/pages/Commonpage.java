package pages;

import java.util.*;
import org.openqa.selenium.*;
import utility.*;

public class Commonpage {
	enum Environment {
		qat, uat, dev;
	}

	private WebDriver driver;
	static Propertyreader propertyreader = new Propertyreader();
	static Properties property = propertyreader.init_prop();
	private By xPathofdropDown = By.xpath("//img[@alt='Company Logo']");
	private By txtEmailAddress = By.xpath("//input[contains(@name ,'email')]");
	private By txtPassword = By.xpath("//input[contains(@name ,'password')]");
	private By notificationTableGridxPath = By.xpath("//div[contains(@class,'detail-notification-view')]/div//p");
	private By closeIcon = By.xpath("//button[@aria-label='Close']");
	private By frmIframe = By.xpath("//iframe[contains(@id,'plaid-link')]");
	private By btnContinueforPlaidProcess = By.xpath("(//button[normalize-space()='Continue'][@role='button'] )[1]");
	private By lstbankname;
	private By txtbUserName = By.xpath("//label[text()='Username']/following-sibling::input");
	private By txtbPassword = By.xpath("//label[text()='Password']/following-sibling::input");
	private By rbtnAddBankPleidChecking = By.xpath("//input[@type='radio']");
	private By lblToolTipText = By.xpath("//div[@class='tooltip-inner']");

	public Commonpage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnLink(String linktext) {
		By linkxpath = By.partialLinkText(linktext);
		Eventhelper.click(driver, linkxpath);
	}

	public void clickOnButton(String buttonname) {
		By btnXpath = By.xpath("(//button[normalize-space()='" + buttonname + "'])[1]");
		Eventhelper.click(driver, btnXpath);
	}

	public Boolean isTextDisplayed(String text) {
		By xpath = By.xpath("//*[contains(text(),'" + text + "')]");
		return Eventhelper.isElementDisplayed(driver, xpath); 
	}

	public Boolean isTextNotDisplayed(String text) {
		By xpath = By.xpath("//*[contains(text(),'" + text + "')]");
		return Eventhelper.waitUntilElementInvisible(driver, xpath);
	}

	public void clickonDropDownofProfile() {
		Eventhelper.click(driver, xPathofdropDown);
	}

	public void clickonLinkfromProfileDropDownOption(String text) {
		By btnxpath = By.xpath("//a[normalize-space()='" + text + "']");
		Eventhelper.click(driver, btnxpath);
	}

	public void enterEmailAddress(String value) {
		if (value.contains("random")) {
			value = UUID.randomUUID().toString() + Constants.HOPSCOTCHAUTOMATIONDOTCOM;
			Log.info("Email id is -->" + value);
		}
		Eventhelper.sendkeys(driver, txtEmailAddress, value);
	}

	public void enterPassword(String value) {
		Eventhelper.sendkeys(driver, txtPassword, value);
	}

	public void clickonNotificationfromHeader() {
		By btnxpath = By.xpath("//a[@href='/notification']");
		Eventhelper.click(driver, btnxpath);
	}

	public boolean isNotificationPresentInList(String notificationMessage) {
		List<WebElement> listofNotificationsElements = Eventhelper.findElements(driver, notificationTableGridxPath);
		List<String> listofNotificationsText = new ArrayList<String>();
		for (WebElement notificationsElements : listofNotificationsElements) {
			listofNotificationsText.add(notificationsElements.getText());
		}
		return listofNotificationsText.contains(notificationMessage);
	}

	public Boolean isPopUpClose() {
		return Eventhelper.waitUntilElementInvisible(driver, closeIcon);
	}

	public void addBankInPlaid(String bankName) {
		lstbankname = By.xpath("(//*[text()='" + bankName + "'])");
		Eventhelper.switchToFrame(driver, frmIframe);
		Eventhelper.isElementDisplayed(driver, btnContinueforPlaidProcess);
		Eventhelper.click(driver, btnContinueforPlaidProcess);
		Eventhelper.click(driver, lstbankname);
		Eventhelper.sendkeys(driver, txtbUserName, "user_good");
		Eventhelper.sendkeys(driver, txtbPassword, "pass_good");
		clickOnButton("Submit");
		Eventhelper.click(driver, rbtnAddBankPleidChecking);
		Eventhelper.isElementDisplayed(driver, btnContinueforPlaidProcess);
		Eventhelper.click(driver, btnContinueforPlaidProcess);
		Eventhelper.click(driver, btnContinueforPlaidProcess);
		Eventhelper.switchToParentFrame(driver);
	}

	public void hoverOnButton(String buttonname) {
		By btnXpath = By.xpath("((//*[normalize-space()='" + buttonname + "']))[1]");
		Eventhelper.useActionClassOperation(driver, btnXpath, "Hover");
	}

	public String getEmailAsPerFeature(String feature) {
		String environment = (System.getProperty(Constants.ENVIRONMENT) == null) ? Environment.qat.toString()
				: System.getProperty(Constants.ENVIRONMENT);
		String credential = null;

		switch (feature) {
		case "Login":
		case "addbill":
		case "Funds":
		case "externalInvoice":
		case "InvoiceSend":
			credential = environment.equals("qat") ? property.getProperty("qat3") : property.getProperty("uat1");
			break;
		case "Profile":
		case "paymentMethodSection":
			credential = environment.equals("qat") ? property.getProperty("qat6") : property.getProperty("uat2");
			break;
		case "twoFactorAuthentication":
		case "InvoicePay":
			credential = environment.equals("qat") ? property.getProperty("qat7") : property.getProperty("uat3");
			break;
		case "contact":
		case "changePassword":
		case "accountSection":
			credential = environment.equals("qat") ? property.getProperty("qat5") : property.getProperty("uat2");
			break;
		case "Unverified":
			credential = environment.equals("qat") ? property.getProperty("qat4") : property.getProperty("qat4");
			break;
		default:
			credential = environment.equals("qat") ? property.getProperty("qat3") : property.getProperty("uat3");
		}
		return credential;
	}
}
