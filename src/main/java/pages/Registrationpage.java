package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.Eventhelper;
import utility.Log;

public class Registrationpage {

	private WebDriver driver;
	private By fnametextbox = By.xpath("//input[@placeholder='Your first name']");
	private By lnametextbox = By.xpath("//input[@placeholder='Your last name']");
	private By businessaddress = By.xpath("//input[@placeholder='The name you’re known by']");
	private By password = By.xpath("//input[contains(@name ,'password')]");
	private By emailaddress = By.xpath("//input[contains(@name ,'email')]");

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
		for (int i = 1; i <= 4; i++) {
			String xpath = "(//input[contains(@aria-label,'Digit')])[" + i + "]";
			Log.info(xpath);
			By otptextfield = By.xpath(xpath);

			Eventhelper.sendkeys(driver, otptextfield, "5");

		}
	}

	public String getWelcomeText(String text) {
		By xpath = By.xpath("//*[contains(text(),'" + text + "')]");
		return Eventhelper.getTextofElement(driver, xpath);
	}
}
