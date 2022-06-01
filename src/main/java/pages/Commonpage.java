package pages;

import java.util.*;
import org.openqa.selenium.*;
import utility.*;

public class Commonpage {

	private WebDriver driver;
	private By xPathofdropDown = By.xpath("//img[@alt='Company Logo']");
	private By txtEmailAddress = By.xpath("//input[contains(@name ,'email')]");
	private By txtPassword = By.xpath("//input[contains(@name ,'password')]");
	private By notificationTableGridxPath = By.xpath("//div[contains(@class,'detail-notification-view')]/div//p");
	private By closeIcon = By.xpath("//button[@aria-label='Close']");

	public Commonpage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnLink(String linktext) {
		By linkxpath = By.partialLinkText(linktext);
		Eventhelper.click(driver, linkxpath);
	}

	public void clickOnButton(String buttonname) {
		By btnXpath = By.xpath("((//button[normalize-space()='" + buttonname + "']))[1]");
		Eventhelper.explicitwait(driver, btnXpath);
		Eventhelper.click(driver, btnXpath);
	}

	public Boolean isTextDisplayed(String text) {
		By xpath = By.xpath("//*[contains(text(),'" + text + "')]");
		return Eventhelper.isElementDisplayed(driver, xpath);
	}

	public void clickonDropDownofProfile() {
		Eventhelper.click(driver, xPathofdropDown);
	}

	public void clickonLinkfromProfileDropDownOption(String text) {
		By btnxpath = By.xpath("//a[normalize-space()='" + text + "']");
		Eventhelper.click(driver, btnxpath);
	}

	public void enterEmailAddress(String value) {
		if (value.contains("random")) {
			value = UUID.randomUUID().toString() + "@hopscotchautomation.com";
			Log.info("Email id is -->" + value);
		}
		Eventhelper.sendkeys(driver, txtEmailAddress, value);
	}

	public void enterPassword(String value) {
		Eventhelper.sendkeys(driver, txtPassword, value);
	}

	public void clickonNotificationfromHeader() {
		By btnxpath = By.xpath("//a[@href='/notification']");
		Eventhelper.click(driver, btnxpath);
	}

	public boolean isNotificationPresentInList(String notificationMessage) {
		List<WebElement> listofNotificationsElements = Eventhelper.findElements(driver, notificationTableGridxPath);
		List<String> listofNotificationsText = new ArrayList<String>();
		for (WebElement notificationsElements : listofNotificationsElements) {
			listofNotificationsText.add(notificationsElements.getText());
		}
		return listofNotificationsText.contains(notificationMessage);
	}

	public Boolean isPopUpClose() {
		return Eventhelper.waitUntilElementInvisible(driver, closeIcon);
	}
}
