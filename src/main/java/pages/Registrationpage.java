package pages;

import java.util.List;
import java.util.UUID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Eventhelper;
import utility.Log;

public class Registrationpage {

	private WebDriver driver;
	private By fnametextbox = By.xpath(" //input[@name='firstName']");
	private By lnametextbox = By.xpath("//input[@name='lastName']");
	private By businessaddress = By.xpath("//input[@name='dbaName']");
	private By password = By.xpath("//input[contains(@name ,'password')]");
	private By emailaddress = By.xpath("//input[contains(@name ,'email')]");
	private By otpboxlocator = By.xpath("(//input[contains(@aria-label,'Digit')])");
	private By aboutyourcompany = By.xpath("//textarea[@name='description']");
	private By website = By.xpath("//input[@name='website']");
	private By city = By.xpath("//input[@name='city']");
	private By yearfounded = By.xpath("//input[@name='yearFounded']");
	private By state = By.xpath("//div[@id='state']");
	private By selectestate = By.xpath("//div[text()='AK']");
	private By industry = By.xpath("//div[@id='industry']");
	private By selecteindustry = By.xpath("//div[text()='Accounting']");

	public Registrationpage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnLink(String linktext) {
		By linkxpath = By.partialLinkText(linktext);
		Eventhelper.click(driver, linkxpath);
	}

	public void clickOnButton(String buttonname) {
		By btnxpath = By.xpath("(//button[normalize-space()='" + buttonname + "'])[1]");
			Eventhelper.click(driver, btnxpath);
	}

	public void enterEmailAddress(String value) {
		if (value.contains("random")) {
			value = UUID.randomUUID().toString() + "@hopscotchautomation.com";
			Log.info("Email id is -->" + value);
		}
		Eventhelper.sendkeys(driver, emailaddress, value);
	}

	public void enterFirstName(String value) {
		Eventhelper.sendkeys(driver, fnametextbox, value);
	}

	public void enterLastName(String value) {
		Eventhelper.sendkeys(driver, lnametextbox, value);
	}

	public void enterBusinessAddress(String value) {
		Eventhelper.sendkeys(driver, businessaddress, value);
	}

	public void enterPassword(String value) {
		Eventhelper.sendkeys(driver, password, value);
	}

	public void enterOTP() {
		List<WebElement> otpboxes = Eventhelper.findElements(driver, otpboxlocator);
		for (int i = 1; i <= otpboxes.size(); i++) {
			String xpath = "(//input[contains(@aria-label,'Digit')])[" + i + "]";
			By otptextfield = By.xpath(xpath);
			Eventhelper.sendkeys(driver, otptextfield, "5");
		}
	}

	public void enterCompanyDetails() {
		Eventhelper.sendkeys(driver, aboutyourcompany, "This textare contains value about company");
	}

	public void enterAdditionalInformation() {
		Eventhelper.sendkeys(driver, website, "https://www.google.com/");
		Eventhelper.sendkeys(driver, city, "lakesville");
		Eventhelper.click(driver, state);
		Eventhelper.click(driver, selectestate);
		Eventhelper.sendkeys(driver, yearfounded, "2022");
		Eventhelper.click(driver, industry);
		Eventhelper.click(driver, selecteindustry);
	}

	public Boolean isTextDisplayed(String text) {
		By xpath = By.xpath("//*[contains(text(),'" + text + "')]");
		return Eventhelper.isElementDisplayed(driver, xpath);
	}

	public void clickOnTextbox() {
		Eventhelper.click(driver, emailaddress);
	}

	public void sendTab() {
		Eventhelper.sendTab(driver, emailaddress);
	}

	public void doRegister(String randomemail) {
		clickOnLink("Register here");
		enterEmailAddress(randomemail);
		clickOnButton("Continue");
		enterFirstName("Ronald");
		enterLastName("Reagan");
		enterBusinessAddress("The Ronald Reagan");
		enterPassword("Test@123");
		clickOnButton("Continue");
		enterOTP();
		clickOnButton("Continue");
		enterAdditionalInformation();
		clickOnButton("Submit");
	}
}
