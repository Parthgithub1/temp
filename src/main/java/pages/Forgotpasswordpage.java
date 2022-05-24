package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.Eventhelper;

public class Forgotpasswordpage {
	
	private WebDriver driver;
	private By backIconfromForgotPasswordScreen = By.xpath("//button[@type='button']//*[name()='svg']");
	
	public Forgotpasswordpage(WebDriver driver) {
		this.driver = driver;
	}
	public void backIconClickfromForgotPasswordScreen() {
		Eventhelper.click(driver, backIconfromForgotPasswordScreen);
	}

}
