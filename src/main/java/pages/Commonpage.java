package pages;

import java.util.*;
import org.openqa.selenium.*;
import com.github.javafaker.Faker;
import utility.*;

public class Commonpage {
	enum Environment {
		QAT, UAT;

		public String getenv() {
			switch (this) {
			case QAT:
				return "qat";
			case UAT:
				return "uat";
			default:
				return "qat";
			}
		}
	}

	private WebDriver driver;
	private Homepage homePage;
	Faker faker = new Faker();
	static Propertyreader propertyreader = new Propertyreader();
	static Properties property = propertyreader.initProp();
	private By xPathofdropDown = By.xpath("//img[@alt='Company Logo']");
	private By txtEmailAddress = By.xpath("//input[contains(@name ,'email')]");
	private By txtPassword = By.xpath("//input[contains(@name ,'password')]");
	private By notificationTableGridxPath = By.xpath("//div[contains(@class,'detail-notification-view')]/div//p");
	private By closeIcon = By.xpath("//button[@aria-label='Close']");
	private By frmIframe = By.xpath("//iframe[contains(@id,'plaid-link')]");
	private By btnContinueforPlaidProcess = By.xpath("(//button[normalize-space()='Continue'][@role='button'] )[1]");
	private By txtbUserName = By
			.xpath("//label[text()='Username']/ancestor::div//input[@type=\"text\" and @autocomplete=\"off\"]");
	private By txtbPassword = By
			.xpath("//label[text()='Username']/ancestor::div//input[@type=\"password\" and @autocomplete=\"off\"]");
	private By rbtnAddBankPleidChecking = By.xpath("//div[contains(text(),'Checking')]");
	private By lnkDashBoard = By.xpath("//a[contains(@class,'Logo_logo')]");
	private By lblBusinessLogo = By.xpath("//img[@alt='avatar']");
    private By lblAnnualPlanOption = By.xpath("//label[@for='annual']");
	private By frmBillingCard=By.xpath("//iframe[@title='Billing information']");
	private By txtCardNumber= By.xpath("//input[@placeholder='13-19 digits']");
	private By txtCardexpiryDate= By.xpath("//input[@placeholder='MM / YY']");	
	private By txtCardCVV= By.xpath("//input[@placeholder='CVV']");
	
	public Commonpage(WebDriver driver) {
		this.driver = driver;
		homePage = new Homepage(driver);
	}

	public void clickOnLink(String linktext) {
		By linkxpath = By.partialLinkText(linktext);
		Eventhelper.click(driver, linkxpath);
	}

	public void clickOnButton(String buttonname) {
		By btnXpath = By.xpath("(//button[normalize-space()='" + buttonname + "'])[1]");
		Eventhelper.explicitwait(driver, btnXpath);
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
			value = (faker.name().firstName() + faker.name().lastName() + Constants.MAILINATORDOTCOM).toString()
					.toLowerCase();
			Log.info("Email id is -->" + value);
		}
		Eventhelper.sendkeys(driver, txtEmailAddress, value);
	}

	public void enterPassword(String value) {
		Eventhelper.sendkeys(driver, txtPassword, value);
	}

	public void clickonNotificationfromHeader() {
		By btnxpath = By.xpath("//a[@href='/notification']");
		homePage.waituntillDataLoadedOnTheDashboard();
		Eventhelper.click(driver, btnxpath);
	}

	public boolean isNotificationPresentInList(String notificationMessage) {
		List<WebElement> listofNotificationsElements = Eventhelper.findElements(driver, notificationTableGridxPath);
		List<String> listofNotificationsText = new ArrayList<>();
		for (WebElement notificationsElements : listofNotificationsElements) {
			listofNotificationsText.add(notificationsElements.getText());
		}
		return listofNotificationsText.contains(notificationMessage);
	}

	public Boolean isPopUpClose() {
		return Eventhelper.waitUntilElementInvisible(driver, closeIcon);
	}

	public void addBankInPlaid(String bankName) {
		By lstbankname = By.xpath("//*[contains(@aria-label, '" + bankName + "')]");
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
	
	public void addBOA()
	{
		By lstbankname = By.xpath("//*[contains(@aria-label, 'Bank of America')]");
		Eventhelper.switchToFrame(driver, frmIframe);
		Eventhelper.isElementDisplayed(driver, btnContinueforPlaidProcess);
		Eventhelper.click(driver, btnContinueforPlaidProcess);
	    Eventhelper.click(driver, lstbankname);
	    Eventhelper.click(driver, By.xpath("//button[@id='aut-button']"));
	    String winHandleBefore = driver.getWindowHandle();
	    for(String winHandle : driver.getWindowHandles()){
	        driver.switchTo().window(winHandle);
	    }
	    Eventhelper.isElementDisplayed(driver, By.xpath("//body[contains(@class ,'oauth-login')]"));
	    Eventhelper.click(driver, By.xpath("//button[@id='submit-credentials']"));
	    Eventhelper.click(driver, By.xpath("//button[@id='submit-device']"));
	    Eventhelper.click(driver, By.xpath("//button[@id='submit-code']"));
	    Eventhelper.click(driver, By.xpath("//div[normalize-space()='Plaid Checking']"));
	    Eventhelper.click(driver, By.xpath("//button[@id='submit-accounts']"));
	    Eventhelper.click(driver, By.xpath("//input[@id='terms']"));
	    Eventhelper.click(driver, By.xpath("//button[@id='submit-confirmation'] "));
	    driver.switchTo().window(winHandleBefore);
	    Eventhelper.switchToFrame(driver, frmIframe);
	    Eventhelper.click(driver, rbtnAddBankPleidChecking);
		Eventhelper.isElementDisplayed(driver, btnContinueforPlaidProcess);
		clickOnButton(Constants.CONTINUEBUTTON);
		clickOnButton(Constants.CONTINUEBUTTON);
		Eventhelper.switchToParentFrame(driver);
	}
	
	public void hoverOnButton(String buttonname) {
		By btnXpath = By.xpath("((//*[normalize-space()='" + buttonname + "']))[1]");
		Eventhelper.useActionClassOperation(driver, btnXpath, "Hover");
	}

	public String getEmailAsPerFeature(String feature) {

		String environment = (System.getProperty(Constants.ENVIRONMENT) == null) ? Environment.QAT.getenv()
				: System.getProperty(Constants.ENVIRONMENT);
		String credential = null;

		switch (feature) {
		case "addbill":
		case "deatiledInvoicePay":
		case "externalInvoice":
		case "Login":
		case "Funds":
			credential = environment.equals(Environment.QAT.getenv()) ? property.getProperty("qat11")
					: property.getProperty("uat1");
			break;
		case "deatiledInvoice":
			credential = environment.equals(Environment.QAT.getenv()) ? property.getProperty("qat20")
					: property.getProperty("uat1");
			break;
		case "InvoicePay":
			credential = environment.equals(Environment.QAT.getenv()) ? property.getProperty("qat13")
					: property.getProperty("uat2");
			break;
		case "InvoiceSend":
			credential = environment.equals(Environment.QAT.getenv()) ? property.getProperty("qat14")
					: property.getProperty("uat1");
			break;
		case "markReceivedInvoice":
		case "downloadInvoice":
			credential = environment.equals(Environment.QAT.getenv()) ? property.getProperty("qat21")
					: property.getProperty("uat3");
			break;
		case "cancelInvoice":
			credential = environment.equals(Environment.QAT.getenv()) ? property.getProperty("qat18")
					: property.getProperty("uat3");
			break;
		case "rejectInvoice":
			credential = environment.equals(Environment.QAT.getenv()) ? property.getProperty("qat19")
					: property.getProperty("uat3");
			break;
		case "futureDayInvoice":
			credential = environment.equals(Environment.QAT.getenv()) ? property.getProperty("qat17")
					: property.getProperty("uat3");
			break;
		case "contact":
		case "cancelInvoiceNotificationCheck":
			credential = environment.equals(Environment.QAT.getenv()) ? property.getProperty("qat15")
					: property.getProperty("uat1");
			break;
		case "Unverified":
			credential = environment.equals(Environment.QAT.getenv()) ? property.getProperty("qat4")
					: property.getProperty("uat4");
			break;
		case "Profile":
			credential = environment.equals(Environment.QAT.getenv()) ? property.getProperty("qat6")
					: property.getProperty("uat3");
			break;
		case "Settings":
		case "rejectInvoiceNotificationCheck":
		case "invoiceSchedulingSend":
			credential = environment.equals(Environment.QAT.getenv()) ? property.getProperty("qat16")
					: property.getProperty("uat3");
			break;
		case "FactorInvoiceSend":
			credential = environment.equals(Environment.QAT.getenv()) ? property.getProperty("crs1")
					: property.getProperty("uat4");
			break;
		case "FactorInvoicePay":
			credential = environment.equals(Environment.QAT.getenv()) ? property.getProperty("crs2")
					: property.getProperty("uat4");
			break;
		case "Overdue":
		case "2FA":
		case "SettingChangePassword":
			credential = environment.equals(Environment.QAT.getenv()) ? property.getProperty("qat071")
					: property.getProperty("uat3");
			break;
		case "invoiceScheduling":
			credential = environment.equals(Environment.QAT.getenv()) ? property.getProperty("qat23")
					: property.getProperty("uat4");
			break;
		case "invoiceUnScheduling":
			credential = environment.equals(Environment.QAT.getenv()) ? property.getProperty("qat22")
					: property.getProperty("uat4");
			break;
		default:
			credential = environment.equals(Environment.QAT.getenv()) ? property.getProperty("qat11")
					: property.getProperty("uat3");
		}
		return credential;
	}

	public void switchToDashboard() {
		Eventhelper.click(driver, lnkDashBoard);
	}

	public void clickOnTheBusinessLogoOnTheDashboard() {
		Eventhelper.click(driver, lblBusinessLogo);
	}

	public void closePendoDialog() {
		try {
			if (Eventhelper.isElementDisplayed(driver,
					By.xpath("//button[@aria-label='Close' or contains(@id,'pendo-close-guide')]"))) {
				Eventhelper.click(driver,
						By.xpath("//button[@aria-label='Close' or contains(@id,'pendo-close-guide')]"));
			}
		} catch (Exception e) {
			Log.info(e.getMessage());
		}
	}
	
	public void selectAnnualPlanOption()
	{
		Eventhelper.click(driver, lblAnnualPlanOption);
	}
	
	public void enterBillingCardDetails()
	{
		Eventhelper.switchToFrame(driver, frmBillingCard);
		Eventhelper.isElementDisplayed(driver, txtCardNumber);
		Eventhelper.sendkeys(driver, txtCardNumber, "4111111111111111");
		Eventhelper.sendkeys(driver, txtCardexpiryDate, "12/30");
		Eventhelper.sendkeys(driver, txtCardCVV, "123");
		Eventhelper.switchToParentFrame(driver);
	}
	
	public void switchToNextTab()
	{
		driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
	}
	
	public void closeUserFlowDialog()
	{
		By userFlowFrame = By.xpath("//iframe[contains(@class,'userflowjs-bubble__frame')]");
		By closeDialogButton= By.xpath("//button[@aria-label='Close guide']");
		
		try {
			if (Eventhelper.isElementDisplayed(driver,userFlowFrame)) {
				Eventhelper.switchToFrame(driver,userFlowFrame);
				Eventhelper.click(driver,closeDialogButton);
				Eventhelper.switchToParentFrame(driver);
			}
		} catch (Exception e) {
			Log.info(e.getMessage());
		}
	}
	
}
