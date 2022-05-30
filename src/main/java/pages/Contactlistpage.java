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
	private By listOfContact = By.xpath("//tr[contains(@class,'TableBody_table__row')]");


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
//		Eventhelper.threadWait(3000);
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
		Eventhelper.explicitwaitTextToBePresent(driver, lblBusinessNameinContactListGrid, bName);
		if (Eventhelper.getTextofElement(driver, lblBusinessNameinContactListGrid).contains(bName)) {
			Eventhelper.click(driver, btnOfMoreActionsGrid);
		}
	}

	public void clickOnDeleteOrRestoreContact(String string) {
		Eventhelper.explicitwaitTextToBePresent(driver, lblBusinessNameinContactListGrid, bName);
		if (Eventhelper.getTextofElement(driver, lblBusinessNameinContactListGrid).contains(bName)) {
			Eventhelper.click(driver, By.xpath("//div[text()='"+ string +"']"));
		}
	}
		
	public boolean searchResultWaitofcontact() {
		Eventhelper.explicitwaitTextToBePresent(driver, lblBusinessNameinContactListGrid, bName);
		return Eventhelper.isElementDisplayed(driver, lblBusinessNameinContactListGrid);
	}
	
//	public boolean seeDeleteContactinTrash() {
//		List<WebElement> listofNotificationsElements = Eventhelper.findElements(driver, listOfContact);
//		System.out.println(listofNotificationsElements);
//		List<String> listofNotificationsText = new ArrayList<String>();
//		boolean flag = false;
//		for (WebElement notificationsElements : listofNotificationsElements) {
//			listofNotificationsText.add(notificationsElements.getText());
//		}
//		if(flag = listofNotificationsText.contains(bName)){
//			flag = true;
//		}
//		return flag;
//	}
}
