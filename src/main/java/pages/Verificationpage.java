package pages;

import org.openqa.selenium.*;

import utility.*;

public class Verificationpage {

	private WebDriver driver;
	private Commonpage commonPage;
	private By txtLegalBusinessName = By.xpath("//input[@name='legalName']");
	private By txtBusinessAddress = By.xpath("//input[@name='bizAddress']");
	private By ddBusinessAddress = By.xpath("//div[@class='pac-item'][1]");
	private By txtBusinessAppartement = By.xpath("//input[@name='bizAddressApt']");
	private By ddBusinessTaxType = By.xpath("//div[@id='taxId']");
	private By ddBusinessSelectTaxYype = By.xpath("//div[text()='SSN']");
	private By txtBusinessTaxID = By.xpath("//input[@id='idNumber']");
	private By btnAddBeneficial = By.xpath("//span[text()='Add beneficial owner']");
	private By txtAddBeneficialFirstName = By.xpath("//input[@name='ownerFirstName']");
	private By txtAddBeneficialLastName = By.xpath("//input[@name='ownerLastName']");
	private By txtAddBeneficialBirthDate = By.xpath("//input[@name='birthday']");
	private By txtAddBeneficialSSN = By.xpath("//input[@id='ownerSSN']");
	private By rbtnAddBeneficialSameAsLegalAddress = By
			.xpath("//label[normalize-space()='Click this if your business and home address are the same.']");
	private By lstIsBeneficialAdded = By.xpath("//p[contains(@class,'BeneficialOwner_name')]");
	private By verifiedIcon = By.cssSelector(".VerificationStar_active__2Y_Gu");
	private By btnAddBankDetails = By.xpath("//span[normalize-space()='Add and connect instantly']");
	private By frmIframe = By.xpath("//iframe[@title='Plaid Link']");
	private By btnAddBankContinue = By.xpath("//*[@id=\"aut-button\"]");
	private By lstBankName = By.xpath("//button[contains(@aria-label, 'Huntington Bank')]");
	private By txtBankUserName = By.xpath("//label[text()='Username']/ancestor::div//input[@type=\"text\" and @autocomplete=\"off\"]");
	private By txtBankPassword = By.xpath("//label[text()='Username']/ancestor::div//input[@type=\"password\" and @autocomplete=\"off\"]");
	private By rbtnAddBankPleidChecking = By.xpath("//input[@type='radio']");
	private By dropDownofBusinessType1 = By.xpath("//div[contains(@class,'select__form-field__value-container css')]");
	private By verificationText = By.xpath("//div[contains(@class,'VerificationStatus_title')]");

	public Verificationpage(WebDriver driver) {
		this.driver = driver;
		commonPage = new Commonpage(driver);

	}

	public void enterLegalBusinessName(String legalbusnienssname) {
		Eventhelper.threadWait(1000);
		Eventhelper.sendkeys(driver, txtLegalBusinessName, legalbusnienssname);
	}

	public void enterAddress() {
		Eventhelper.sendkeys(driver, txtBusinessAddress, "660 Madison Avenue");
		Eventhelper.threadWait(1000);
		Eventhelper.click(driver, txtBusinessAppartement);
		Eventhelper.click(driver, txtBusinessAddress);
		Eventhelper.threadWait(1000);
		Eventhelper.click(driver, ddBusinessAddress);
	}

	public void enterBusinessTax() {
		Eventhelper.click(driver, ddBusinessTaxType);
		Eventhelper.click(driver, ddBusinessSelectTaxYype);
		Eventhelper.sendkeys(driver, txtBusinessTaxID, "444559999");
	}

	public boolean isBeneficialAdded() {
		Eventhelper.explicitwait(driver, lstIsBeneficialAdded);
		return Eventhelper.isElementDisplayed(driver, lstIsBeneficialAdded);
	}

	public void addBank() {
		Eventhelper.threadWait(2000);
		Eventhelper.waitUntilAttribValueContains(driver, By.xpath("//iframe[@title='Plaid Link']"),"title","Plaid Link");
		Eventhelper.click(driver, btnAddBankDetails);
		Eventhelper.switchToFrame(driver, frmIframe);
		Eventhelper.isElementDisplayed(driver, btnAddBankContinue);
		commonPage.clickOnButton(Constants.CONTINUEBUTTON);
		Eventhelper.click(driver, lstBankName);
		Eventhelper.sendkeys(driver, txtBankUserName, "user_good");
		Eventhelper.sendkeys(driver, txtBankPassword, "pass_good");
		commonPage.clickOnButton("Submit");
		Eventhelper.click(driver, rbtnAddBankPleidChecking);
		Eventhelper.isElementDisplayed(driver, btnAddBankContinue);
		commonPage.clickOnButton(Constants.CONTINUEBUTTON);
		commonPage.clickOnButton(Constants.CONTINUEBUTTON);
		Eventhelper.switchToParentFrame(driver);
	}

	public void addBankExternalInvoice() {
		Eventhelper.switchToFrame(driver, frmIframe);
		Eventhelper.isElementDisplayed(driver, btnAddBankContinue);
		commonPage.clickOnButton(Constants.CONTINUEBUTTON);
		Eventhelper.click(driver, lstBankName);
		Eventhelper.sendkeys(driver, txtBankUserName, "user_good");
		Eventhelper.sendkeys(driver, txtBankPassword, "pass_good");
		commonPage.clickOnButton("Submit");
		Eventhelper.click(driver, rbtnAddBankPleidChecking);
		Eventhelper.isElementDisplayed(driver, btnAddBankContinue);
		commonPage.clickOnButton(Constants.CONTINUEBUTTON);
		commonPage.clickOnButton(Constants.CONTINUEBUTTON);
		Eventhelper.switchToParentFrame(driver);
	}

	public boolean isLinkDisplay(String linktext) {
		By linkxpath = By.partialLinkText(linktext);
		return Eventhelper.isElementDisplayed(driver, linkxpath);
	}

	public boolean isUserverified() {
		return Eventhelper.isElementDisplayed(driver, verifiedIcon);
	}

	public void setURL(String url) {
		Eventhelper.getURL(driver, url);
	}

	public void selectDropDownforBusinessType(String valuefromDropDown) {
		Eventhelper.click(driver, dropDownofBusinessType1);
		By ddSelecteBusinessType = By.xpath("//div[text()='" + valuefromDropDown + "']");
		Eventhelper.click(driver, ddSelecteBusinessType);
	}

	public void enterTaxID(int taxNumber) {
		Eventhelper.sendkeys(driver, txtBusinessTaxID, String.valueOf(taxNumber));
	}

	public void addBeneficial() {
		Eventhelper.click(driver, btnAddBeneficial);
		Eventhelper.sendkeys(driver, txtAddBeneficialFirstName, "jack");
		Eventhelper.sendkeys(driver, txtAddBeneficialLastName, "denial");
		Eventhelper.sendkeys(driver, txtAddBeneficialBirthDate, "01012002");
		Eventhelper.sendkeys(driver, txtAddBeneficialSSN, Eventhelper.generateRandomNumberWith1Prefix(8, 99999999));
		commonPage.clickOnButton(Constants.CONTINUEBUTTON);
		Eventhelper.click(driver, rbtnAddBeneficialSameAsLegalAddress);
		commonPage.clickOnButton(Constants.CONTINUEBUTTON);
	}

	public boolean verificationConfirmation() {
		boolean flag = false;
		if (Eventhelper.getTextofElement(driver, verificationText).equalsIgnoreCase("Verification is complete")
				|| Eventhelper.getTextofElement(driver, verificationText).equalsIgnoreCase("Verification is pending")) {
			flag = true;
		}
		return flag;
	}

	public void enterDateOfBirthdateofSoleProprietorship() {
		Eventhelper.threadWait(2000);
		Eventhelper.sendkeys(driver, txtAddBeneficialBirthDate, "01012001");
	}
}
