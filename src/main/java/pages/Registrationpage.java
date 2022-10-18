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
	private By txtAboutYourCompany = By.xpath("//textarea[@name='description']");
	private By txtWebsite = By.xpath("//input[@name='website']");
	private By txtCity = By.xpath("//input[@name='city']");
	private By txtYearFounded = By.xpath("//input[@name='yearFounded']");
	private By ddState = By.xpath("//div[@id='state']");
	private By ddSelecteState = By.xpath("//div[text()='AK']");
	private By ddIndustry = By.xpath("//div[@id='industry']");
	private By ddSelecteIndustry = By.xpath("//div[text()='Accounting']");
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

	public void enterCompanyDetails() {
		Eventhelper.sendkeys(driver, txtAboutYourCompany, "This textarea contains value about company");
	}

	public void enterAdditionalInformation() {
		Eventhelper.sendkeys(driver, txtWebsite, "https://www.google.com/");
		Eventhelper.sendkeys(driver, txtCity, "lakesville");
		Eventhelper.click(driver, ddState);
		Eventhelper.click(driver, ddSelecteState);
		Eventhelper.sendkeys(driver, txtYearFounded, "2022");
		Eventhelper.click(driver, ddIndustry);
		Eventhelper.click(driver, ddSelecteIndustry);
	}

	public Boolean isTextDisplayed(String text) {
		Eventhelper.threadWait(2000);
		By xpath = By.xpath("//*[contains(text(),'" + text + "')]");
		return Eventhelper.isElementDisplayed(driver, xpath);
	}

	public void clickOnTextbox() {
		Eventhelper.click(driver, txtEmailAddress);
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
		enterBusinessName("TestTP " + Eventhelper.generateRandomNumberWith1Prefix(4,9999));
		commonPage.enterPassword(property.getProperty("password"));
		commonPage.clickOnButton(Constants.CONTINUEBUTTON);
		enterCompanyDetails();
		commonPage.clickOnButton(Constants.CONTINUEBUTTON);
		enterAdditionalInformation();
		commonPage.clickOnButton("Done");
	}
}
