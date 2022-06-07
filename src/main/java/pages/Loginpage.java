package pages;

import java.util.Properties;
import org.openqa.selenium.*;
import io.cucumber.java.*;
import utility.*;

public class Loginpage {
	private WebDriver driver;
	private Commonpage commonPage;
	static Propertyreader propertyreader = new Propertyreader();
	static Properties property = propertyreader.init_prop();
	Scenario scenario;

	public Loginpage(WebDriver driver) {
		this.driver = driver;
		commonPage = new Commonpage(driver);
	}

	public boolean isAttemptTextDisplayed() {
		By tstErrorLocator = By.cssSelector(".LoginForm_field__content-error__2NPje.LoginForm_attempts-error__2pKNJ");
		return Eventhelper.isElementDisplayed(driver, tstErrorLocator);
	}

	public void doLogin(String email) {
		commonPage.enterEmailAddress(email);
		System.out.println("Email is :" + email);
		commonPage.enterPassword(Constants.PASSWORD);
		Eventhelper.threadWait(2000);
		commonPage.clickOnButton(Constants.CONTINUEBUTOON);
	}

	public boolean isHompageDisplay(String email) {
		By loginBtn = By.xpath("//button[@type='submit']");
		try {
			Eventhelper.waitUntilElementInvisible(driver, loginBtn);
		} catch (Exception e) {
			commonPage.clickOnLink("Reset your password");
			driver.navigate().back();
			doLogin(email);
		}
		return Eventhelper.waitUntilElementInvisible(driver, loginBtn);
	}

}