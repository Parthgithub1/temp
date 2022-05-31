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

	private By txtSearchBarforContact = By.xpath("//input[contains(@name ,'search')]");
	private By newContactAddedName = By.xpath("//span[contains(@class,'InfoHeader_header')]");
	private By lblEmailIdinContactListGrid = By.xpath("//td[2]");
	private By btnBackFromContactProfileScreen = By
			.xpath("//button[contains(@class,'Breadcrumbs_breadcrumbs')]//*[name()='svg'][1]");
	private By btnOfMoreActionsGrid = By.xpath("//tr[1]//div[contains(@id,'actionPopup')]");
	private By tblContactGridList = By
			.xpath("//div[contains(@class,'entity-short-card business_business_wrapper')]/div//p");

	Faker faker = new Faker();
	String tempEmail;
	String bName = faker.company().name();

	public Contactlistpage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterContactDeatails() {

		Eventhelper.sendkeys(driver, txtBusinessName, bName);
		Eventhelper.click(driver, btnAddNewBusiness);
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		Eventhelper.sendkeys(driver, txtFirstName, firstName);
		Eventhelper.sendkeys(driver, txtLastName, lastName);
		tempEmail = firstName + lastName + "@mailinator.com";
		Eventhelper.sendkeys(driver, txtEmail, tempEmail);
		Log.info("Contact Email is :" + tempEmail);
	}

	public void clickOnAddNewBusinessButton() {
		Eventhelper.click(driver, btnAddNewBusiness);
	}

	public void searchNameInSearchBar() {
		Eventhelper.threadWait(1500);
		Eventhelper.click(driver, txtSearchBarforContact);
		Eventhelper.sendkeys(driver, txtSearchBarforContact, tempEmail);
		Eventhelper.threadWait(1500);
	}

	public void clickOnContactListSearchResult() {

		String rowXpath = waitTillContactPresent();
		if (rowXpath == null) {
			rowXpath = "";
		}
		By lstOfSearchforContact = By
				.xpath(rowXpath + "//div[contains(@class,'entity-short-card')]/following-sibling::p");
		Eventhelper.click(driver, lstOfSearchforContact);

	}

	public String waitTillContactPresent() {
		String rowxpath = null;
		boolean isEmailmatch;
		List<WebElement> listOfEle = Eventhelper.findElements(driver, lblEmailIdinContactListGrid);
		for (int i = 1; i < listOfEle.size(); i++) {
			for (WebElement ele : listOfEle) {

				try {
					isEmailmatch = ele.getText().equals(tempEmail);
				} catch (StaleElementReferenceException e) {
					Eventhelper.doRefresh(driver);
					searchNameInSearchBar();
					isEmailmatch = ele.getText().equals(tempEmail);
				}

				if (isEmailmatch) {
					rowxpath = "//tr[" + i + "]";
					break;
				}
			}
		}
		return rowxpath;
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
		String rowXpath = waitTillContactPresent();
		if (rowXpath == null) {
			rowXpath = "";
		}
		btnOfMoreActionsGrid = By.xpath(rowXpath + "//div[contains(@id,'actionPopup')]");
		Eventhelper.click(driver, btnOfMoreActionsGrid);
	}

	public void clickOnDeleteOrRestoreContact(String string) {
		Eventhelper.click(driver, By.xpath("//div[text()='" + string + "']"));
	}

	public boolean seeContacts() {
		String xpath = waitTillContactPresent();
		if (xpath == null) {
			xpath = "";
		}
		String emailXpath = xpath + "//td[2]";
		String email = Eventhelper.getTextofElement(driver, By.xpath(emailXpath));
		return email.equals(tempEmail);
	}
}
