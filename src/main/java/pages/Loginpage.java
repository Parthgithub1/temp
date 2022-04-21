package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.*;

public class Loginpage {
	private WebDriver driver;
	private Registrationpage registrationpage;

	public Loginpage(WebDriver driver) {
		this.driver = driver;
		registrationpage = new Registrationpage(driver);
	}

	public boolean isAttemptTextDisplayed() {
		By errorLocator = By.cssSelector(".LoginForm_field__content-error__2NPje.LoginForm_attempts-error__2pKNJ");
		return Eventhelper.isElementDisplayed(driver, errorLocator);
	}

	public void doLogin(String email, String pass, String login) {
		registrationpage.enterEmailAddress(email);
		registrationpage.enterPassword(pass);
		registrationpage.clickOnButton(login);
	}

}
