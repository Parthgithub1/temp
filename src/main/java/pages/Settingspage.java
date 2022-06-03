package pages;

import java.util.*;
import org.openqa.selenium.*;
import utility.*;

public class Settingspage {
	private WebDriver driver;
	private Commonpage commonPage;
	private Sendinvoicepage sendInvoicePage;
	static Propertyreader propertyreader = new Propertyreader();
	static Properties property = propertyreader.init_prop();

	private By txtCurrentPassword = By.xpath(" //input[@name='currentPassword']");
	private By txtNewPassword = By.xpath(" //input[@name='newPassword']");
	private By txtConfirmPassword = By.xpath(" //input[@name='confirmNewPassword']");
	private By txtMobileNumber = By.xpath("//input[@name='phone']");
	private By enterCodeforTwoFactorAuthentication = By.xpath("//input[@name='code']");
	private By toggleOfTwoFactorAuthentication;
	private By menuIcon, lblBankAccountType;

	public Settingspage(WebDriver driver) {
		this.driver = driver;
		commonPage = new Commonpage(driver);
		sendInvoicePage = new Sendinvoicepage(driver);
	}

	public void changePassword() {
		Eventhelper.sendkeys(driver, txtCurrentPassword, property.getProperty("password"));
		Eventhelper.sendkeys(driver, txtNewPassword, property.getProperty("changePassword"));
		Eventhelper.sendkeys(driver, txtConfirmPassword, property.getProperty("changePassword"));
	}

	public void resetPassword() {
		Eventhelper.sendkeys(driver, txtCurrentPassword, property.getProperty("changePassword"));
		Eventhelper.sendkeys(driver, txtNewPassword, property.getProperty("password"));
		Eventhelper.sendkeys(driver, txtConfirmPassword, property.getProperty("password"));
	}

	public void doLoginafterChangePassword(String email, String login) {
		commonPage.enterEmailAddress(email);
		System.out.println("Email is :" + email);
		commonPage.enterPassword(property.getProperty("changePassword"));
		Eventhelper.threadWait(2000);
		commonPage.clickOnButton(login);
	}
	
	public void enterMobileNumberforTwoFactorAuthentication(String mobileNumber) {
		Eventhelper.clearTextwithdoubleClickusingActionClass(driver, txtMobileNumber);
		Eventhelper.sendkeys(driver, txtMobileNumber, mobileNumber);
	}
	
	public void enterCodeForTwoFactorAuthentication() {
		Eventhelper.sendkeys(driver, enterCodeforTwoFactorAuthentication, Constants.enterCodeforTwoFactorAuthentication);
	}

	public void clickOnTwoFactorAuthenticationToggle(String twoFactorAuthenticationToggle) {
		toggleOfTwoFactorAuthentication = By.xpath("//*[contains(text(),'" + twoFactorAuthenticationToggle + "')]");
		Eventhelper.click(driver, toggleOfTwoFactorAuthentication);
	}

	public void clickOnMenuIconOfBank(String bankName) {
		menuIcon = By.xpath("//b[text()='" + bankName
				+ "']/ancestor::div[contains(@class,'AccountDetails_payment-method-info__wrapper')]/parent::div/following-sibling::div");
		Eventhelper.click(driver, menuIcon);
	}

	public void switchToDashboard() {
		sendInvoicePage.switchToDashboard();
	}

	public boolean isAccountTypeSet(String bankname, String accontType) {
		lblBankAccountType = By
				.xpath("//b[text()='" + bankname + "']/following-sibling::div/span[text()='" + accontType + "']");
		return Eventhelper.isElementDisplayed(driver, lblBankAccountType);
	}
}
