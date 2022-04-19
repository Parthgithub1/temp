package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.*;

public class Loginpage {
	private   WebDriver driver;
	public Loginpage(WebDriver driver) {
		this.driver = driver;
	}
	  
	  public  boolean isAttemptTextDisplayed() {
		  By errorLocator = By.cssSelector(".LoginForm_field__content-error__2NPje.LoginForm_attempts-error__2pKNJ");   
		     return Eventhelper.isElementDisplayed(driver, errorLocator);
		  
	  }

}
