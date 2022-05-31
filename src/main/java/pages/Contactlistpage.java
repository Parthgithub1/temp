package pages;

import java.util.ArrayList;
import java.util.List;

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
	private By btnBackFromContactProfileScreen = By
			.xpath("//button[contains(@class,'Breadcrumbs_breadcrumbs')]//*[name()='svg'][1]");
	private By btnOfMoreActionsGrid = By.xpath("//tr[1]//div[contains(@id,'actionPopup')]");
	private By tblContactGridList = By
			.xpath("//div[contains(@class,'entity-short-card business_business_wrapper')]/div//p");

	Faker faker = new Faker();
	String vender, bName = faker.company().name();;

	public Contactlistpage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterContactDeatails() {

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
		Eventhelper.click(driver, txtSearchBarforContact);
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

	public void clickOnBackButtonfromContactProfileScreen() {
		Eventhelper.click(driver, btnBackFromContactProfileScreen);
	}

	public void clickOnMoreOptionBesideContactInfo() {
		Eventhelper.click(driver, btnOfMoreActionsGrid);
	}

	public void clickOnDeleteOrRestoreContact(String string) {
		Eventhelper.click(driver, By.xpath("//div[text()='" + string + "']"));
	}

	public boolean seeContacts() {
		List<WebElement> listOfContactElements = Eventhelper.findElements(driver, tblContactGridList);
		System.out.println(listOfContactElements);
		List<String> listOfContactText = new ArrayList<String>();
		System.out.println(listOfContactText);
		boolean flag = false;
		for (WebElement contactElement : listOfContactElements) {
			Eventhelper.waitUntilElementVisible(driver, contactElement);
			try {
				listOfContactText.add(contactElement.getText());
			} catch (StaleElementReferenceException e) {
				listOfContactText.add(contactElement.getText());
			}
		}
		if (flag = listOfContactText.contains(bName)) {
			flag = true;
		}
		return flag;
	}
}
