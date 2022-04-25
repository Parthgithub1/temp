package pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.Eventhelper;
import utility.Log;

public class Verificationpage {

	private WebDriver driver;

	private By legalbusinessnametextbox = By.xpath("//input[@placeholder='Business name']");
	private By businessaddress = By.xpath("//input[@name='bizAddress']");
	private By businessapt = By.xpath("//input[@name='bizAddressApt']");
	private By businesscity = By.xpath("//input[@name='bizAddressCity']");
	private By businessstate = By.xpath("//div[@id='bizAddressState']");
	private By businessselectestate = By.xpath("//div[text()='AK']");
	private By businesszipcode = By.xpath("//input[@name='bizAddressZip']");
	private By businesstaxtype = By.xpath("//div[@id='taxId']");
	private By businessselecttaxtype = By.xpath("//div[text()='SSN']");
	private By businesstaxid = By.xpath("//input[@id='idNumber']");
	private By addbeneficial = By.xpath("//span[normalize-space()='Add beneficial owner']");
	private By addbeneficialfirstname = By.xpath("//input[@name='ownerFirstName']");
	private By addbeneficiallastname = By.xpath("//input[@name='ownerLastName']");
	private By addbeneficialBirthdate = By.xpath("//input[@placeholder='Birthday']");
	private By addbeneficialssn = By.xpath("//input[@id='ownerSSN']");
	private By addbeneficialnextbtn = By.xpath("//button[normalize-space()='Next']");
	private By addbeneficialsameaslegaladdress = By
			.xpath("//label[normalize-space()='Same as legal business address']");
	private By addbeneficialsavebtn = By.xpath("//button[normalize-space()='Save']");
	private By isbeneficialadded = By.xpath("//p[contains(@class,'BeneficialOwner_name')]");
	private By verifiedIcon = By.cssSelector(".VerificationStar_active__2Y_Gu");
	private By addbankde = By.xpath("//button[.='Add and securely connect instantly']");
	private By iframe = By.xpath("//iframe");
	private By continuebtn = By.xpath("//button[@id='aut-continue-button']");
	private By chase = By.xpath("(//p[text()='Chase'])");
	private By chaseusernme = By.xpath("//input[@id='username']");
	private By chasepassword = By.xpath("//input[@id='password']");
	private By submitbtn = By.xpath("//button[@id='aut-submit-button']");

	public Verificationpage(WebDriver driver) {
		this.driver = driver;

	}

	public void enterLegalBusinessName(String legalbusnienssname) {
		Eventhelper.sendkeys(driver, legalbusinessnametextbox, legalbusnienssname);
	}

	public void enterAddress() {
		Eventhelper.sendkeys(driver, businessaddress, "Home street");
		Eventhelper.sendkeys(driver, businessapt, "4th floor");
		Eventhelper.sendkeys(driver, businesscity, "Boston");
		Eventhelper.click(driver, businessstate);
		Eventhelper.click(driver, businessselectestate);
		Eventhelper.sendkeys(driver, businesszipcode, "02114");
	}

	public void enterBusinessTax() {
		Eventhelper.click(driver, businesstaxtype);
		Eventhelper.click(driver, businessselecttaxtype);
		Eventhelper.sendkeys(driver, businesstaxid, "444559999");
	}

	public void addBeneficial() {
		Eventhelper.click(driver, addbeneficial);
		Eventhelper.sendkeys(driver, addbeneficialfirstname, "jack");
		Eventhelper.sendkeys(driver, addbeneficiallastname, "denial");
		Eventhelper.sendkeys(driver, addbeneficialBirthdate, "01012008");
		Eventhelper.sendkeys(driver, addbeneficialssn, Eventhelper.generateRandomNumber());
		Eventhelper.click(driver, addbeneficialnextbtn);
		Eventhelper.click(driver, addbeneficialsameaslegaladdress);
		Eventhelper.click(driver, addbeneficialsavebtn);
	}

	public boolean isBeneficialAdded() {
		return Eventhelper.isElementDisplayed(driver, isbeneficialadded);
	}

	public void addBank() {
		Eventhelper.click(driver, addbankde);
		driver.switchTo().frame(Eventhelper.findElement(driver, iframe));
		Eventhelper.isElementDisplayed(driver, continuebtn);
		Eventhelper.click(driver, continuebtn);
		Eventhelper.click(driver, chase);
		Eventhelper.sendkeys(driver, chaseusernme, "user_good");
		Eventhelper.sendkeys(driver, chasepassword, "pass_good");
		Eventhelper.click(driver, submitbtn);
		Eventhelper.isElementDisplayed(driver, continuebtn);
		Eventhelper.click(driver, continuebtn);
		Eventhelper.click(driver, continuebtn);
		driver.switchTo().parentFrame();
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
