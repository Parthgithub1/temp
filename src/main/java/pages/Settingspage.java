package pages;

import java.util.*;
import org.openqa.selenium.*;

import com.github.javafaker.Faker;

import utility.*;

public class Settingspage {
	private WebDriver driver;
	private Commonpage commonPage;
	private Sendinvoicepage sendInvoicePage;
	static Propertyreader propertyreader = new Propertyreader();
	static Properties property = propertyreader.init_prop();
	Faker faker = new Faker();
	String firstName;
	String lastName;

	private By txtCurrentPassword = By.xpath(" //input[@name='currentPassword']");
	private By txtNewPassword = By.xpath(" //input[@name='newPassword']");
	private By txtConfirmPassword = By.xpath(" //input[@name='confirmNewPassword']");
	private By txtMobileNumber = By.xpath("//input[@name='phone']");
	private By enterCodeforTwoFactorAuthentication = By.xpath("//input[@name='code']");
	private By txtFirstName = By.xpath("//input[@name='firstName']");
	private By txtLastName = By.xpath("//input[@name='lastName']");
	private By toggleOfTwoFactorAuthentication;
	private By menuIcon, lblBankAccountType;
	
	public Settingspage(WebDriver driver) {
		this.driver = driver;
		commonPage = new Commonpage(driver);
		sendInvoicePage = new Sendinvoicepage(driver);
	}
	
	public void enterFirstAndLastName() {
		Eventhelper.useActionClassOperation(driver, txtFirstName, "DoubleClick");
		firstName = faker.name().firstName();
		Eventhelper.sendkeys(driver, txtFirstName, firstName);
		Eventhelper.useActionClassOperation(driver, txtLastName, "DoubleClick");
		lastName = faker.name().lastName();
		Eventhelper.sendkeys(driver, txtLastName, lastName);
		Eventhelper.autoScrollWindow(driver, Eventhelper.findElement(driver, txtMobileNumber));
	}
	
	public boolean verificationOfDataForFirstAndLastName() {
		return Eventhelper.getValueOfAttribute(driver, txtLastName, "value").equalsIgnoreCase(lastName) && Eventhelper.getValueOfAttribute(driver, txtFirstName, "value").equalsIgnoreCase(firstName);
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

	public void doLoginafterChangePassword(String email) {
		commonPage.enterEmailAddress(email);
		System.out.println("Email is :" + email);
		commonPage.enterPassword(Constants.CHANGEPASSWORD);
		Eventhelper.threadWait(2000);
		commonPage.clickOnButton(Constants.CONTINUEBUTTON);
	}
	
	public void enterMobileNumberforTwoFactorAuthentication(String mobileNumber) {
		Eventhelper.useActionClassOperation(driver, txtMobileNumber, "DoubleClick");
		Eventhelper.sendkeys(driver, txtMobileNumber, mobileNumber);
	}
	
	public void enterCodeForTwoFactorAuthentication() {
		Eventhelper.sendkeys(driver, enterCodeforTwoFactorAuthentication, Constants.ENTERCODEFORTWOFACTORAUTHENTICATION);
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