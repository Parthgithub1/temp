package pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utility.Eventhelper;
import utility.Log;

public class Verificationpage {

	private WebDriver driver;

	private By legalbusinessnametextbox = By.xpath("//input[@placeholder='Business name']");
	private By businessaddress = By.xpath("//input[@name='bizAddress']");
	private By selectbusinessaddress = By.xpath("//div[@class='pac-container pac-logo']//div[@class='pac-item'][1]");
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

	private By isbeneficialadded = By.xpath("//p[@class='BeneficialOwner_name__3kfE1']");

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

		Random random = new Random();
		int number = random.nextInt(999999999);
		String ssn = String.valueOf(number);

		Eventhelper.click(driver, addbeneficial);
		Eventhelper.sendkeys(driver, addbeneficialfirstname, "jack");
		Eventhelper.sendkeys(driver, addbeneficiallastname, "denial");
		Eventhelper.sendkeys(driver, addbeneficialBirthdate, "01012008");
		Eventhelper.sendkeys(driver, addbeneficialssn, ssn);
		Eventhelper.click(driver, addbeneficialnextbtn);
		Eventhelper.click(driver, addbeneficialsameaslegaladdress);
		Eventhelper.click(driver, addbeneficialsavebtn);

	}

	public String isBeneficialAdded() {

		return Eventhelper.getTextofElement(driver, isbeneficialadded);
	}

}
