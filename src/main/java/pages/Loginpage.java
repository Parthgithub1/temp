package pages;

import org.openqa.selenium.*;
import userdata.*;
import utility.*;

public class Loginpage {
	private WebDriver driver;
	private Registrationpage registrationpage;
	private By xPathofdropDown = By.xpath("//img[@alt='Company Logo']");

	public Loginpage(WebDriver driver) {
		this.driver = driver;
		registrationpage = new Registrationpage(driver);
	}

	public boolean isAttemptTextDisplayed() {
		By tstErrorLocator = By.cssSelector(".LoginForm_field__content-error__2NPje.LoginForm_attempts-error__2pKNJ");
		return Eventhelper.isElementDisplayed(driver, tstErrorLocator);
	}

	public void doLogin(String email, String pass, String login) {
		registrationpage.enterEmailAddress(email);
		registrationpage.enterPassword(pass);
		Eventhelper.threadWait(2000);
		registrationpage.clickOnButton(login);

	}

	public boolean isHompageDisplay(String email) {
		By loginBtn = By.xpath("//button[@type='submit']");
		try {
			Eventhelper.waitUntilElementInvisible(driver, loginBtn);
		} catch (Exception e) {
			registrationpage.clickOnLink("Forgot your password?");
			driver.navigate().back();
			doLogin(email, "Password1!", "Log in");
		}
		return Eventhelper.waitUntilElementInvisible(driver, loginBtn);
	}

	public void clickonDropDownofProfile() {
		Eventhelper.click(driver, xPathofdropDown);
	}

	public void clickonLogOutOptionfromProfileDropDown(String text) {
		By btnxpath = By.xpath("//a[normalize-space()='" + text + "']");
		Eventhelper.click(driver, btnxpath);
	}
}