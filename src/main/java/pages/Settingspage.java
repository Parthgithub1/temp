package pages;

import org.openqa.selenium.*;

import utility.Eventhelper;

public class Settingspage {
	private WebDriver driver;
	private By txtCurrentPassword = By.xpath(" //input[@name='currentPassword']");
	private By txtNewPassword = By.xpath(" //input[@name='newPassword']");
	private By txtConfirmPassword = By.xpath(" //input[@name='confirmNewPassword']");
	
	public Settingspage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterCurrentPassword(String value) {
		Eventhelper.sendkeys(driver, txtCurrentPassword, value);
	}
	
	public void enterNewAndConfirmPassword(String newPassword, String confirmPassword) {
		Eventhelper.sendkeys(driver, txtNewPassword, newPassword);
		Eventhelper.sendkeys(driver, txtConfirmPassword, newPassword);	
	}
}
