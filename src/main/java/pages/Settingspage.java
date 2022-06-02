package pages;

import org.openqa.selenium.*;

import utility.Eventhelper;

public class Settingspage {
	private WebDriver driver;
	private Sendinvoicepage sendInvoicePage;
	private By txtCurrentPassword = By.xpath(" //input[@name='currentPassword']");
	private By txtNewPassword = By.xpath(" //input[@name='newPassword']");
	private By txtConfirmPassword = By.xpath(" //input[@name='confirmNewPassword']");
	private By menuIcon, lblBankAccountType;
	
	public Settingspage(WebDriver driver) {
		this.driver = driver;
		sendInvoicePage = new Sendinvoicepage(driver);
	}

	public void enterCurrentPassword(String value) {
		Eventhelper.sendkeys(driver, txtCurrentPassword, value);
	}

	public void enterNewAndConfirmPassword(String newPassword, String confirmPassword) {
		Eventhelper.sendkeys(driver, txtNewPassword, newPassword);
		Eventhelper.sendkeys(driver, txtConfirmPassword, newPassword);
	}

	public void clickOnMenuIconOfBank(String bankName) {
		menuIcon = By.xpath(
				"//b[text()='"+bankName+"']/ancestor::div[contains(@class,'AccountDetails_payment-method-info__wrapper')]/parent::div/following-sibling::div");
		Eventhelper.click(driver, menuIcon);
	}

	public void switchToDashboard() {
		sendInvoicePage.switchToDashboard();
	}
	
	public boolean isAccountTypeSet(String bankname, String accontType)
	{
		lblBankAccountType= By.xpath("//b[text()='"+bankname+"']/following-sibling::div/span[text()='"+accontType+"']");
		return Eventhelper.isElementDisplayed(driver, lblBankAccountType);
	}
}
