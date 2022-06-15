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

	public void doLogin(String email) {
		commonPage.enterEmailAddress(email);
		System.out.println("Email is :" + email);
		commonPage.enterPassword(Constants.PASSWORD);
		Eventhelper.threadWait(2000);
		commonPage.clickOnButton(Constants.CONTINUEBUTTON);
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

	public boolean isAttemptTextDisplayed() {
		return Eventhelper.isElementDisplayed(driver,
				By.xpath("(//p[contains(text(),'"+ Constants.NUMBEROFATTEMPTSVALIDATIONMESSAGE +"')])"));
	}

	public String isValidationDisplayed() {
		return Eventhelper.getTextofElement(driver, By.xpath("//div[contains(@class,'LoginForm_signin-error')]"));
	}

	public String isEmailEnterInCorrectFormat() {
		return Eventhelper.getTextofElement(driver,
				By.xpath("//div[contains(@class,'TextInput_form-errors-wrapper__2LlfN')]"));
	}
}