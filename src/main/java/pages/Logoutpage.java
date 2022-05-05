package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.Eventhelper;

public class Logoutpage {
	private WebDriver driver;
	private By xPathofdropDown = By.xpath("//img[@alt='Company Logo']");
	
	public Logoutpage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickonDropDownofProfile(){
		Eventhelper.click(driver, xPathofdropDown);
	}
	
	public void clickonLogOutOptionfromProfileDropDown(String text) {
		By btnxpath = By.xpath("//a[normalize-space()='" + text + "']");
		Eventhelper.click(driver, btnxpath);
	}

}
