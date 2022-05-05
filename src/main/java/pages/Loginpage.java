package pages;

import org.openqa.selenium.*;
import userdata.*;
import utility.*;

public class Loginpage {
	private WebDriver driver;
	private Registrationpage registrationpage;
	Payinvoicedata payData = new Payinvoicedata();
	Logindata logData;

	public Loginpage(WebDriver driver) {
		this.driver = driver;
		registrationpage = new Registrationpage(driver);
		logData = new Logindata();
	}

	public boolean isAttemptTextDisplayed() {
		By tstErrorLocator = By.cssSelector(".LoginForm_field__content-error__2NPje.LoginForm_attempts-error__2pKNJ");
		return Eventhelper.isElementDisplayed(driver, tstErrorLocator);
	}

	public void doLogin(String email, String pass, String login) {
		registrationpage.enterEmailAddress(email);
		//logData.setEmail(email);
		registrationpage.enterPassword(pass);
		//logData.setPassword(pass);
		registrationpage.clickOnButton(login);
	}

	public boolean isHompageDisplay() {
		By loginBtn = By.xpath("//button[@type='submit']");
		try {
			Eventhelper.waitUntilElementInvisible(driver, loginBtn);
		} catch (Exception e) {
			registrationpage.clickOnLink("Forgot your password?");
			driver.navigate().back();
			//String email = logData.getEmail();
			//String pass = logData.getPassword();
			//doLogin(email, pass, "Log in");
			doLogin("hopsmokeautomation2@mailinator.com", "Password1!", "Log in");
		}
		return Eventhelper.waitUntilElementInvisible(driver, loginBtn);
	}
}