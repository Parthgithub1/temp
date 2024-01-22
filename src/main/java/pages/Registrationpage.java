package pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.*;

public class Registrationpage {

	private WebDriver driver;
	static Propertyreader propertyreader = new Propertyreader();
	static Properties property = propertyreader.initProp();
	private By txtFirstName = By.xpath(" //input[@name='firstName']");
	private By txtLastName = By.xpath("//input[@name='lastName']");
	private By txtBusinessName = By.xpath("//input[@name='dbaName']");
	private By txtEmailAddress = By.xpath("//input[contains(@name ,'email')]");
	private By txtOtpBoxLocator = By.xpath("(//input[contains(@aria-label,'Digit')])");
	
	private Commonpage commonPage;

	public Registrationpage(WebDriver driver) {
		this.driver = driver;
		commonPage = new Commonpage(driver);
	}

	public void enterFirstName(String value) {
		Eventhelper.sendkeys(driver, txtFirstName, value);
	}

	public void enterLastName(String value) {
		Eventhelper.sendkeys(driver, txtLastName, value);
	}

	public void enterBusinessName(String value) {
		Eventhelper.sendkeys(driver, txtBusinessName, value);
	}

	public void enterOTP() {
		List<WebElement> otpboxes = Eventhelper.findElements(driver, txtOtpBoxLocator);
		for (int i = 1; i <= otpboxes.size(); i++) {
			String xpath = "(//input[contains(@aria-label,'Digit')])[" + i + "]";
			By otptextfield = By.xpath(xpath);
			Eventhelper.sendkeys(driver, otptextfield, "5");
		}
	}

	public void enterQuestionsDetails() {
		By ddIndustry = By.xpath("//div[@id='industry']");
		By selectIndustry = By.xpath("//div[contains(text(),\"Accounting\")]");
		By ddEmployee = By.xpath("//div[@id='numberOfEmployees']");
		By selectEmployee = By.xpath("//div[contains(text(),\"1-2\")]");
		By ddHowdDidYouHeard = By.xpath("//div[@id='howDidYouHear']");
		By selectHowdDidYouHear = By.xpath("//div[contains(text(),\"Blog post\")]");
		By txtAreaExistingAccountingMethod = By.xpath("//textarea[@name='currentInvoiceBillPayWorkflow']");

		Eventhelper.click(driver, ddIndustry);
		Eventhelper.click(driver, selectIndustry);
		Eventhelper.click(driver, ddEmployee);
		Eventhelper.click(driver, selectEmployee);
		Eventhelper.click(driver, ddHowdDidYouHeard);
		Eventhelper.click(driver, selectHowdDidYouHear);
		Eventhelper.sendkeys(driver, txtAreaExistingAccountingMethod, "All the accounting is done in a manual way");

	}

	public Boolean isTextDisplayed(String text) {
		Eventhelper.threadWait(2000);
		By xpath = By.xpath("//*[contains(text(),'" + text + "')]");
		return Eventhelper.isElementDisplayed(driver, xpath);
	}

	public void clickOnTextbox() {
		Eventhelper.click(driver, txtEmailAddress);
	}

	public void createUser(String email, String firstName, String businessName) {
		commonPage.clickOnLink("Sign up");
		commonPage.enterEmailAddress(email);
		commonPage.clickOnButton(Constants.CONTINUEBUTTON);
		enterOTP();
		commonPage.clickOnButton(Constants.CONTINUEBUTTON);
		enterFirstName(firstName);
		enterLastName("SolePropPass");
		enterBusinessName(businessName);
		commonPage.enterPassword(property.getProperty("password"));
		commonPage.clickOnButton(Constants.CONTINUEBUTTON);
		enterQuestionsDetails();
		commonPage.clickOnButton(Constants.CONTINUEBUTTON);
	}

	public void doRegister(String randomemail, String businessType) {
		String lastName = businessType.equalsIgnoreCase("Sole Proprietorship") ? "SolePropPass" : "BizPass";
		commonPage.clickOnLink("Sign up");
		commonPage.enterEmailAddress(randomemail);
		commonPage.clickOnButton(Constants.CONTINUEBUTTON);
		enterOTP();
		commonPage.clickOnButton(Constants.CONTINUEBUTTON);
		enterFirstName("Ronald");
		enterLastName(lastName);
		enterBusinessName("TestTP " + Eventhelper.generateRandomNumberWith1Prefix(4, 9999));
		commonPage.enterPassword(property.getProperty("password"));
		commonPage.clickOnButton(Constants.CONTINUEBUTTON);
		enterQuestionsDetails();
		commonPage.clickOnButton(Constants.CONTINUEBUTTON);
	}
}
