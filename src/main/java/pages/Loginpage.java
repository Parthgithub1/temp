package pages;

import org.openqa.selenium.*;
import utility.*;

public class Loginpage {
	private WebDriver driver;
	private Commonpage commonPage;

	public Loginpage(WebDriver driver) {
		this.driver = driver;
		commonPage = new Commonpage(driver);
	}

	public boolean isAttemptTextDisplayed() {
		By tstErrorLocator = By.cssSelector(".LoginForm_field__content-error__2NPje.LoginForm_attempts-error__2pKNJ");
		return Eventhelper.isElementDisplayed(driver, tstErrorLocator);
	}
	
	public void doLogin(String email, String pass, String login) {
		commonPage.enterEmailAddress(email);
		System.out.println("Email is :" + email);
		commonPage.enterPassword(pass);
		Eventhelper.threadWait(2000);
		commonPage.clickOnButton(login);
	}
	
	public boolean isHompageDisplay(String email) {
		By loginBtn = By.xpath("//button[@type='submit']");
		try {
			Eventhelper.waitUntilElementInvisible(driver, loginBtn);
		} catch (Exception e) {
			commonPage.clickOnLink("Reset your password");
			driver.navigate().back();
			doLogin(email, "Password1!", "Continue");
		}
		return Eventhelper.waitUntilElementInvisible(driver, loginBtn);
	}


}