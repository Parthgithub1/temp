package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.*;

public class Commonpage {

	private WebDriver driver;
	private By xPathofdropDown = By.xpath("//img[@alt='Company Logo']");
	private By txtEmailAddress = By.xpath("//input[contains(@name ,'email')]");
	private By txtPassword = By.xpath("//input[contains(@name ,'password')]");
	private By notificationTableGridxPath = By.xpath("//div[contains(@class,'detail-notification-view')]/div//p");

	public Commonpage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnLink(String linktext) {
		By linkxpath = By.partialLinkText(linktext);
		Eventhelper.click(driver, linkxpath);
	}
	
	public void clickOnButton(String buttonname) {
		By btnXpath = By.xpath("((//button[normalize-space()='"+ buttonname +"']))[1]");
		Eventhelper.threadWait(2000);
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

	public void clickonNotificationfromHeader(String linktext) {
		By btnxpath = By.xpath("(//*[name()='svg'])[4]");		
		Eventhelper.click(driver, btnxpath);
	}
	

	public boolean seeNotifications(String notificationMessage) {
		List<WebElement> listofNotificationsElements = Eventhelper.findElements(driver, notificationTableGridxPath);
		List<String> listofNotificationsText = new ArrayList<String>();
		boolean flag = false;
		for (WebElement notificationsElements : listofNotificationsElements) {
			listofNotificationsText.add(notificationsElements.getText());
		}
		if(flag = listofNotificationsText.contains(notificationMessage)){
			//System.out.println("Notification Matched");
			flag = true;
		}
		return flag;
	}


}
