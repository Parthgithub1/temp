package pages;

import java.util.List;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Eventhelper;

public class Registrationpage {

	private WebDriver driver;
	private By fnametextbox = By.xpath(" //input[@name='firstName']");
	private By lnametextbox = By.xpath("//input[@name='lastName']");
	private By businessaddress = By.xpath("//input[@name='dbaName']");
	private By password = By.xpath("//input[contains(@name ,'password')]");
	private By emailaddress = By.xpath("//input[contains(@name ,'email')]");
	private By otpboxlocator = By.xpath("(//input[contains(@aria-label,'Digit')])");

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

}
