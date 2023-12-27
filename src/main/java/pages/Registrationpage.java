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
	private By ddState = By.xpath("//div[@id='react-select-3-placeholder']");
	private By ddSelecteState = By.xpath("//div[text()='AK']");
	private By ddIndustry = By.xpath("//div[@id='react-select-2-placeholder']");
	private By ddSelecteIndustry = By.xpath("//div[text()='Accounting']");
	private By btnBrandingColor = By.xpath("//div[@class='update-brand-color-control']");
	private By txtBrandingColor = By.xpath("//input[contains(@id,'rc-editable-input')]");
	private By btnButtonColor = By.xpath("//div[@class='update-button-color-control']");
	private By txtButtonColor = By.xpath("//input[contains(@id,'rc-editable-input')]");
	private By btnIconImage = By.xpath("//div[@class='upload-icon-control']");
	private By chooseFileImage = By.id("filePicker");
	private By btnBrandLogo = By.xpath("//div[@class='upload-logo-control']");

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
		//commonPage.closePendoDialog();
		Eventhelper.sendkeys(driver, txtWebsite, "https://www.google.com/");
		Eventhelper.sendkeys(driver, txtYearFounded, "2022");
		//commonPage.closePendoDialog();
		Eventhelper.click(driver, ddIndustry);
		Eventhelper.click(driver, ddSelecteIndustry);
		Eventhelper.sendkeys(driver, txtCity, "lakesville");
		//commonPage.closePendoDialog();
		Eventhelper.click(driver, ddState);
		Eventhelper.click(driver, ddSelecteState);
		Eventhelper.sendkeys(driver, txtAboutYourCompany, "This textarea contains value about company");
	}

	public void enterBrandingInformation() {
		// Set branding Icon
		Eventhelper.click(driver, btnIconImage);
		WebElement chooseFile = Eventhelper.findElement(driver, chooseFileImage);
		chooseFile.sendKeys(Constants.IMAGEFOLDER);
		commonPage.clickOnButton("Save");
		// Set branding logo
		Eventhelper.click(driver, btnBrandLogo);
		WebElement chooseBrnadIcon = Eventhelper.findElement(driver, chooseFileImage);
		chooseBrnadIcon.sendKeys(Constants.IMAGEFOLDER);
		commonPage.clickOnButton("Save");
		// Set branding color
		Eventhelper.click(driver, btnBrandingColor);
		Eventhelper.explicitwait(driver, txtBrandingColor);
		for (int i = 1; i <= 7; i++) {
			Eventhelper.sendKeyboardKeys(driver, txtBrandingColor, "backspace");
		}
		Eventhelper.sendkeys(driver, txtBrandingColor, "#4D2165");
		commonPage.clickOnButton("Save");
		// Set button Color
		Eventhelper.click(driver, btnButtonColor);
		Eventhelper.explicitwait(driver, txtButtonColor);
		for (int i = 1; i <= 7; i++) {
			Eventhelper.sendKeyboardKeys(driver, txtButtonColor, "backspace");
		}
		Eventhelper.sendkeys(driver, txtButtonColor, "#0DE6DF");
		commonPage.clickOnButton("Save");
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
		enterCompanyDetails();
		commonPage.clickOnButton(Constants.CONTINUEBUTTON);
		enterBrandingInformation();
		commonPage.clickOnButton(Constants.CONTINUEBUTTON);
		commonPage.clickOnButton("Continue with free plan");
		commonPage.clickOnButton("Get Pro later");
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
		enterCompanyDetails();
		commonPage.clickOnButton(Constants.CONTINUEBUTTON);
		enterBrandingInformation();
		commonPage.clickOnButton(Constants.CONTINUEBUTTON);
		commonPage.clickOnButton("Continue with free plan");
		commonPage.clickOnButton("Get Pro later");
	}
}
