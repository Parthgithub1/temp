package pages;

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
	private By ddValueOfBusinessSearched = By
			.xpath("//div[contains(@class,'entity-short-card__info CompanyCard_company__name')]//span/span");
	Faker faker = new Faker();
	String tempEmail;
	String bName = faker.company().name();
	int countOfContactOnDashboard;

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
		tempEmail = firstName + lastName + Constants.MAILINATORDOTCOM;
		Eventhelper.sendkeys(driver, txtEmail, tempEmail);
	}

	public void enterContactDeatailsForAlreadyLinkedEmail() {
		Eventhelper.sendkeys(driver, txtBusinessName, bName);
		Eventhelper.click(driver, btnAddNewBusiness);
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		Eventhelper.sendkeys(driver, txtFirstName, firstName);
		Eventhelper.sendkeys(driver, txtLastName, lastName);
		Eventhelper.sendkeys(driver, txtEmail, "qatsmokeautomation031@mailinator.com");
	}

	public void enterBusinessName(String bName) {
		Eventhelper.sendkeys(driver, txtBusinessName, bName);
		By selectBusiness = By
				.xpath("//div[contains(@class,'CompanyCard_company')]//span[contains(text(),'" + bName + "')]");
		Eventhelper.explicitwaitTextToBePresent(driver, ddValueOfBusinessSearched, bName);
		Eventhelper.click(driver, selectBusiness);
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
		return Eventhelper.getTextofElement(driver, newContactAddedName).equalsIgnoreCase(bName);
	}

	public void clickOnBackButtonfromContactProfileScreen() {
		Eventhelper.click(driver, btnBackFromContactProfileScreen);
	}

	public void clickOnMoreOptionBesideContactInfo() {
		String rowXpath = waitTillContactPresent();
		if (rowXpath == null) {
			rowXpath = "";
		}
		By btnOfMoreActionsGrid = By.xpath(rowXpath + "//div[contains(@id,'actionPopup')]");
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
		return Eventhelper.getTextofElement(driver, By.xpath(xpath + "//td[2]")).equals(tempEmail);
	}

	public void readCountOfContactOndashboard() {
		Eventhelper.waitUntilAttribValueContains(driver,
				By.xpath("//div[contains(.,'Hopscotch Balance')]/following-sibling::div[@id='HopscotchBalance']"),
				"data-loaded", "true");
		By lblCountOfContactOnDashboard = By
				.xpath("//a[@href='/contacts' and contains(@class,'Link_link__2RtK3 CompanyInfo_client-link')]//span");
		String contactOnDashboard  = Eventhelper.getTextofElement(driver, lblCountOfContactOnDashboard);
		Log.info(contactOnDashboard);
		countOfContactOnDashboard = Integer
				.parseInt(contactOnDashboard.substring(contactOnDashboard.indexOf("(") + 1, contactOnDashboard.indexOf(")")));
		Log.info("Count of contact list on the dashboard:- " + countOfContactOnDashboard);
	}

	public boolean isContactCountMatchOnContactListPage() {
		By lblCountOfContactOnContactPage = By.xpath("//p[@class='contacts-amount']");
		String contactOnContactListPage = Eventhelper.getTextofElement(driver, lblCountOfContactOnContactPage);
		Log.info(contactOnContactListPage);
		return countOfContactOnDashboard == Integer
				.parseInt(contactOnContactListPage.substring(contactOnContactListPage.indexOf("(") + 1, contactOnContactListPage.indexOf(")")));
	}

	public boolean isCountOfTotalContactRowsMatched() {
		By contactRows = By.xpath("//tbody//tr");
		int count = Eventhelper.findElements(driver, contactRows).size();
		Log.info("Total rows on the contactlist are :-" + count);
		return count == countOfContactOnDashboard;
	}

}
