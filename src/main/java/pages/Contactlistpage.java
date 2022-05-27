package pages;

import org.openqa.selenium.*;

import com.github.javafaker.Faker;

import utility.*;

public class Contactlistpage {

	private WebDriver driver;
	private By txtBusinessName = By.xpath("//input[contains(@name ,'vendor')]");
	private By txtFirstName = By.xpath(" //input[@name='firstName']");
	private By txtLastName = By.xpath("//input[@name='lastName']");
	private By txtEmail = By.xpath("//input[@name='email']");
	private By btnAddNewBusiness = By.xpath("//span[contains(text(),'as a new business')]");
	private By lstOfSearchforContact = By.xpath("//div[contains(@class,'entity-short-card')]/following-sibling::p");
	private By txtSearchBarforContact = By.xpath("//input[contains(@name ,'search')]");
	private By newContactAddedName = By.xpath("//span[contains(@class,'InfoHeader_header')]");
	private By lblBusinessNameinContactListGrid = By.xpath("//td[1]");

	Faker faker = new Faker();
	String vender, bName;

	public Contactlistpage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterContactDeatails() {
		bName = faker.company().name();
		Eventhelper.sendkeys(driver, txtBusinessName, bName);
		Eventhelper.click(driver, btnAddNewBusiness);
		vender = faker.name().firstName();
		Eventhelper.sendkeys(driver, txtFirstName, vender);
		Eventhelper.sendkeys(driver, txtLastName, faker.name().lastName());
		String tempEmail = vender + "@mailinator.com";
		Eventhelper.sendkeys(driver, txtEmail, tempEmail);
	}

	public void clickOnAddNewBusinessButton() {
		Eventhelper.click(driver, btnAddNewBusiness);
	}

	public void searchNameInSearchBar() {
		Eventhelper.explicitwait(driver, txtSearchBarforContact);
		Eventhelper.sendkeys(driver, txtSearchBarforContact, bName);
	}

	public void clickOnContactListSearchResult() {
		Eventhelper.explicitwaitTextToBePresent(driver, lblBusinessNameinContactListGrid, bName);
		if (Eventhelper.getTextofElement(driver, lblBusinessNameinContactListGrid).contains(bName)) {
			Eventhelper.click(driver, lstOfSearchforContact);
		}
	}

	public Boolean contactAddedVerification() {
		boolean flag = false;
		String actualText = Eventhelper.getTextofElement(driver, newContactAddedName);
		if (actualText.equalsIgnoreCase(bName)) {
			flag = true;
		}
		return flag;
	}
}
