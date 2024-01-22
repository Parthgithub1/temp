package pages;

import java.util.*;
import org.openqa.selenium.*;
import utility.*;

public class Settingspage {
	private WebDriver driver;
	private Commonpage commonPage;
	static Propertyreader propertyreader = new Propertyreader();
	static Properties property = propertyreader.initProp();
	private By txtCurrentPassword = By.xpath(" //input[@name='currentPassword']");
	private By txtNewPassword = By.xpath(" //input[@name='newPassword']");
	private By txtConfirmPassword = By.xpath(" //input[@name='confirmNewPassword']");
	private By txtMobileNumber = By.xpath("//input[@name='phone']");
	private By enterCodeforTwoFactorAuthentication = By.xpath("//input[@name='code']");
	private By bankNameCurrentlyAdded = By.xpath("//b[contains(@class,'AccountDetails_bank-name')]");
	private By btnBrandingColor = By.xpath("//div[@class='update-brand-color-control']");
	private By txtBrandingColor = By.xpath("//input[contains(@id,'rc-editable-input')]");
	private By btnButtonColor = By.xpath("//div[@class='update-button-color-control']");
	private By txtButtonColor = By.xpath("//input[contains(@id,'rc-editable-input')]");
	private By btnIconImage = By.xpath("//div[@class='upload-icon-control']");
	private By chooseFileImage = By.id("filePicker");
	private By btnBrandLogo = By.xpath("//div[@class='upload-logo-control']");
	String getPropertyOfPassword = property.getProperty("password");
	String getPropertyOfChangePassword = property.getProperty("changePassword");

	public Settingspage(WebDriver driver) {
		this.driver = driver;
		commonPage = new Commonpage(driver);
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
		commonPage.enterPassword(getPropertyOfChangePassword);
		Eventhelper.threadWait(2000);
		commonPage.clickOnButton(Constants.CONTINUEBUTTON);
	}

	public void enterMobileNumberforTwoFactorAuthentication(String mobileNumber) {
		Eventhelper.useActionClassOperation(driver, txtMobileNumber, Constants.DOUBLECLICK);
		Eventhelper.sendkeys(driver, txtMobileNumber, mobileNumber);
	}

	public void enterCodeForTwoFactorAuthentication() {
		Eventhelper.sendkeys(driver, enterCodeforTwoFactorAuthentication,
				Constants.ENTERCODEFORTWOFACTORAUTHENTICATION);
	}

	public void clickOnTwoFactorAuthenticationToggle(String twoFactorAuthenticationToggle) {
		Eventhelper.autoScrollWindow(driver);
		Eventhelper.click(driver, By.xpath("//*[contains(text(),'" + twoFactorAuthenticationToggle + "')]"));
	}

	public void clickOnMenuIconOfBank(String bankName) {
		Eventhelper.threadWait(1500);
		Eventhelper.click(driver, By.xpath("//b[text()='" + bankName
				+ "']/ancestor::div[contains(@class,'AccountDetails_payment-method-info__wrapper')]//following-sibling::div[contains(@class,'SettingsPaymentMethods_payment-method-menu')]"));
		Eventhelper.threadWait(5000);
	}

	public void switchToDashboard() {
		commonPage.switchToDashboard();
	}

	public boolean isAccountTypeSet(String bankname, String accontType) {
		return Eventhelper.isElementDisplayed(driver,
				By.xpath("//b[text()='" + bankname + "']/following-sibling::div/span[text()='" + accontType + "']"));
	}

	public void enterCurrentPassword() {
		Eventhelper.useActionClassOperation(driver, txtCurrentPassword, Constants.DOUBLECLICK);
		Eventhelper.sendKeyboardKeys(driver, txtCurrentPassword, "tab");
	}

	public void enterNewPassword() {
		Eventhelper.useActionClassOperation(driver, txtNewPassword, Constants.DOUBLECLICK);
		Eventhelper.sendKeyboardKeys(driver, txtNewPassword, "tab");
	}

	public void enterConfirmPassword() {
		Eventhelper.useActionClassOperation(driver, txtConfirmPassword, Constants.DOUBLECLICK);
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

	public void enterBrandingInformation() {
		// Set branding Icon
		try {
			commonPage.clickOnButton("Remove image");	
		} catch (Exception e) {
			Log.error(e.toString());
		}
		Eventhelper.click(driver, btnIconImage);
		WebElement chooseFile = Eventhelper.findElement(driver, chooseFileImage);
		chooseFile.sendKeys(Constants.IMAGEFOLDER);
		commonPage.clickOnButton("Save");
		// Set branding logo
		try {
			commonPage.clickOnButton("Remove image");	
		} catch (Exception e) {
			Log.error(e.toString());
		}
		Eventhelper.click(driver, btnBrandLogo);
		WebElement chooseBrnadIcon = Eventhelper.findElement(driver, chooseFileImage);
		chooseBrnadIcon.sendKeys(Constants.IMAGEFOLDER);
		commonPage.clickOnButton("Save");
		// Set branding color
		Eventhelper.click(driver, btnBrandingColor);
		Eventhelper.explicitwait(driver, txtBrandingColor);
		for (int i = 1; i <= 7; i++) {
			Eventhelper.sendKeyboardKeys(driver, txtBrandingColor, "backspace");
		}
		Eventhelper.sendkeys(driver, txtBrandingColor, "#4D2165");
		commonPage.clickOnButton("Save");
		// Set button Color
		Eventhelper.click(driver, btnButtonColor);
		Eventhelper.explicitwait(driver, txtButtonColor);
		for (int i = 1; i <= 7; i++) {
			Eventhelper.sendKeyboardKeys(driver, txtButtonColor, "backspace");
		}
		Eventhelper.sendkeys(driver, txtButtonColor, "#0DE6DF");
		commonPage.clickOnButton("Save");
	}

	public void checkRemoveOptionInBrandingOption(String imageOption) {
		if (imageOption.equalsIgnoreCase("Icon")) {
			Eventhelper.click(driver, btnIconImage);
			commonPage.isTextDisplayed("Remove image");
			commonPage.clickOnButton("Save");
		} else {
			Eventhelper.click(driver, btnBrandLogo);
			commonPage.isTextDisplayed("Remove image");
			commonPage.clickOnButton("Save");
		}
	}
}
