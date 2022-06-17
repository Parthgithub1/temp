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
	private By bankNameCurrentlyAdded = By.xpath("//b[contains(@class,'AccountDetails_bank-name')]");
	String getPropertyOfPassword = property.getProperty("password");
	String getPropertyOfChangePassword = property.getProperty("changePassword");

	public Settingspage(WebDriver driver) {
		this.driver = driver;
		commonPage = new Commonpage(driver);
		sendInvoicePage = new Sendinvoicepage(driver);
	}

	public String getNameOfCurrentBankAdded() {
		return Eventhelper.getTextofElement(driver, bankNameCurrentlyAdded);
	}

	public void changePassword() {
		Eventhelper.sendkeys(driver, txtCurrentPassword, getPropertyOfPassword);
		Eventhelper.sendkeys(driver, txtNewPassword, getPropertyOfChangePassword);
		Eventhelper.sendkeys(driver, txtConfirmPassword, getPropertyOfChangePassword);
	}

	public void enterConfirmPasswordNotMatch() {
		Eventhelper.sendkeys(driver, txtCurrentPassword, getPropertyOfPassword);
		Eventhelper.sendkeys(driver, txtNewPassword, getPropertyOfChangePassword);
		Eventhelper.sendkeys(driver, txtConfirmPassword, getPropertyOfPassword);
		Eventhelper.sendKeyboardKeys(driver, txtConfirmPassword, "tab");
	}

	public void resetPassword() {
		Eventhelper.sendkeys(driver, txtCurrentPassword, getPropertyOfChangePassword);
		Eventhelper.sendkeys(driver, txtNewPassword, getPropertyOfPassword);
		Eventhelper.sendkeys(driver, txtConfirmPassword, getPropertyOfPassword);
	}

	public void doLoginafterChangePassword(String email) {
		commonPage.enterEmailAddress(email);
		commonPage.enterPassword(getPropertyOfPassword);
		Eventhelper.threadWait(2000);
		commonPage.clickOnButton(Constants.CONTINUEBUTTON);
	}

	public void enterMobileNumberforTwoFactorAuthentication(String mobileNumber) {
		Eventhelper.useActionClassOperation(driver, txtMobileNumber, "DoubleClick");
		Eventhelper.sendkeys(driver, txtMobileNumber, mobileNumber);
	}

	public void enterCodeForTwoFactorAuthentication() {
		Eventhelper.sendkeys(driver, enterCodeforTwoFactorAuthentication,
				Constants.ENTERCODEFORTWOFACTORAUTHENTICATION);
	}

	public void clickOnTwoFactorAuthenticationToggle(String twoFactorAuthenticationToggle) {
		Eventhelper.click(driver, By.xpath("//*[contains(text(),'" + twoFactorAuthenticationToggle + "')]"));
	}

	public void clickOnMenuIconOfBank(String bankName) {
		Eventhelper.click(driver, By.xpath("//b[text()='" + bankName
				+ "']/ancestor::div[contains(@class,'AccountDetails_payment-method-info__wrapper')]/parent::div/following-sibling::div"));
	}

	public void switchToDashboard() {
		sendInvoicePage.switchToDashboard();
	}

	public boolean isAccountTypeSet(String bankname, String accontType) {
		return Eventhelper.isElementDisplayed(driver,
				By.xpath("//b[text()='" + bankname + "']/following-sibling::div/span[text()='" + accontType + "']"));
	}

	public void editChangePasswordValidationCheck() {
		Eventhelper.sendkeys(driver, txtCurrentPassword, getPropertyOfChangePassword);
		Eventhelper.sendkeys(driver, txtNewPassword, getPropertyOfPassword);
		Eventhelper.sendkeys(driver, txtConfirmPassword, getPropertyOfPassword);
	}

	public void enterCurrentPassword() {
		Eventhelper.useActionClassOperation(driver, txtCurrentPassword, "DoubleClick");
		Eventhelper.sendKeyboardKeys(driver, txtCurrentPassword, "tab");
	}

	public void enterNewPassword() {
		Eventhelper.useActionClassOperation(driver, txtNewPassword, "DoubleClick");
		Eventhelper.sendKeyboardKeys(driver, txtNewPassword, "tab");
	}

	public void enterConfirmPassword() {
		Eventhelper.useActionClassOperation(driver, txtConfirmPassword, "DoubleClick");
		Eventhelper.sendKeyboardKeys(driver, txtConfirmPassword, "tab");
	}

	public void enterWrongFormatNewPassword(String wrongFormatNewPassword) {
		Eventhelper.sendkeys(driver, txtNewPassword, wrongFormatNewPassword);
		Eventhelper.sendKeyboardKeys(driver, txtNewPassword, "tab");
	}

	public void enterWrongCodeForTwoFactorAuthentication() {
		Eventhelper.sendkeys(driver, enterCodeforTwoFactorAuthentication,
				Constants.ENTERWRONGCODEFORVALIDATIONOFTWOFACTORAUTHENTICATION);
	}
}
