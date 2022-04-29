package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.Eventhelper;

public class Verificationpage {

	private WebDriver driver;

	Registrationpage registrationPage;
	private By txtLegalBusinessName = By.xpath("//input[@placeholder='Business name']");
	private By txtBusinessAddress = By.xpath("//input[@name='bizAddress']");
	private By ddBusinessAddress = By.xpath("//div[@class='pac-item'][1]");
	private By txtBusinessAppartement = By.xpath("//input[@name='bizAddressApt']");
	private By ddBusinessTaxType = By.xpath("//div[@id='taxId']");
	private By ddBusinessSelectTaxYype = By.xpath("//div[text()='SSN']");
	private By txtBusinessTaxID = By.xpath("//input[@id='idNumber']");
	private By btnAddBeneficial = By.xpath("//span[normalize-space()='Add beneficial owner']");
	private By txtAddBeneficialFirstName = By.xpath("//input[@name='ownerFirstName']");
	private By txtAddBeneficialLastName = By.xpath("//input[@name='ownerLastName']");
	private By txtAddBeneficialBirthDate = By.xpath("//input[@placeholder='Birthday']");
	private By txtAddBeneficialSSN = By.xpath("//input[@id='ownerSSN']");
	private By rbtnAddBeneficialSameAsLegalAddress = By
			.xpath("//label[normalize-space()='Same as legal business address']");
	private By lstIsBeneficialAdded = By.xpath("//p[contains(@class,'BeneficialOwner_name')]");
	private By verifiedIcon = By.cssSelector(".VerificationStar_active__2Y_Gu");
	private By btnAddBankDetails = By.xpath("//span[text()='Add and securely connect instantly']");
	private By frmIframe = By.xpath("//iframe");
	private By btnAddBankContinue = By.xpath("//*[@id=\"aut-button\"]");
	private By lstChase = By.xpath("(//*[text()='Chase'])");
	private By txtChaseUserName = By.xpath("//label[text()='Username']/following-sibling::input");
	private By txtChasePassword = By.xpath("//label[text()='Password']/following-sibling::input");
	private By rbtnAddBankPleidChecking = By.xpath("//input[@type='radio']");

	public Verificationpage(WebDriver driver) {
		this.driver = driver;
		registrationPage = new Registrationpage(driver);

	}

	public void enterLegalBusinessName(String legalbusnienssname) {
		Eventhelper.sendkeys(driver, txtLegalBusinessName, legalbusnienssname);
	}

	public void enterAddress() {
		Eventhelper.sendkeys(driver, txtBusinessAddress,"55 Fruit Street");
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

	public void addBeneficial() {
		Eventhelper.click(driver, btnAddBeneficial);
		Eventhelper.sendkeys(driver, txtAddBeneficialFirstName, "jack");
		Eventhelper.sendkeys(driver, txtAddBeneficialLastName, "denial");
		Eventhelper.sendkeys(driver, txtAddBeneficialBirthDate, "01012008");
		Eventhelper.sendkeys(driver, txtAddBeneficialSSN, Eventhelper.generateRandomNumber());
		registrationPage.clickOnButton("Next");
		Eventhelper.click(driver, rbtnAddBeneficialSameAsLegalAddress);
		registrationPage.clickOnButton("Save");
	}

	public boolean isBeneficialAdded() {
		return Eventhelper.isElementDisplayed(driver, lstIsBeneficialAdded);
	}

	public void addBank() {
		Eventhelper.threadWait(2000);
		Eventhelper.click(driver, btnAddBankDetails);
		Eventhelper.switchToFrame(driver, frmIframe);
		Eventhelper.isElementDisplayed(driver, btnAddBankContinue);
		registrationPage.clickOnButton("Continue");
		Eventhelper.click(driver, lstChase);
		Eventhelper.sendkeys(driver, txtChaseUserName, "user_good");
		Eventhelper.sendkeys(driver, txtChasePassword, "pass_good");
		registrationPage.clickOnButton("Submit");
		Eventhelper.click(driver, rbtnAddBankPleidChecking);
		Eventhelper.isElementDisplayed(driver, btnAddBankContinue);
		registrationPage.clickOnButton("Continue");
		registrationPage.clickOnButton("Continue");
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

}
