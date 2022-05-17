package steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.*;
import pages.*;
import userdata.Fundsdata;
import utility.*;

public class Commonsteps {
	
	Commonpage commonPage = new Commonpage(Driverhelper.getDriver());
	AddFundspage addFunds = new AddFundspage(Driverhelper.getDriver());
	Fundsdata fundData = new Fundsdata();
	Loginpage loginPage = new Loginpage(Driverhelper.getDriver());
	
	@When("User click on {string} link")
	public void user_click_on_link(String linktext) {
		commonPage.clickOnLink(linktext);
		Log.info("User is on registration page" + linktext);
	}
	
	@When("User click on {string} button")
	public void user_click_on_button(String buttoname) {
		commonPage.clickOnButton(buttoname);
	}
	
	@Then("User should see {string} text on the screen")
	public void user_should_see_text_on_the_screen(String expectedText) {
		boolean isTextDisplay = commonPage.isTextDisplayed(expectedText);
		assertTrue(isTextDisplay);
	}
	
	@When("User click on Profile Drop Down")
	public void user_click_on_profile_drop_down() {
		commonPage.clickonDropDownofProfile();
	}
	
	@Then("User click on {string} option from Profile Drop-Down")
	public void user_click_on_option_from_profile_drop_down(String string) {
		commonPage.clickonLinkfromProfileDropDownOption(string);
	}
	
	@Then("User should navigate to dashboard of {string}")
	public void user_should_navigate_to_dashboard(String email) {
		boolean isTextDisplay = loginPage.isHompageDisplay(email);
		assertTrue(isTextDisplay);
	}
	
	
	@When("User enter {string} in email field")
	public void user_enter_in_email_field(String emailaddress) {
		commonPage.enterEmailAddress(emailaddress);
		Log.info("User is on enter email field value is " + emailaddress);

	}
	
	@When("User enter {string} in password field")
	public void user_enter_in_password_field(String password) {
		commonPage.enterPassword(password);
	}
	

	
	@When("User login with {string} and {string} and click on {string} button")
	public void user_login_with_and_and_click_on_button(String email, String pass, String login) {
		loginPage.doLogin(email, pass, login);
	}

	@Then("User should see {string} notification")
	public void user_should_see_notification(String notificationMessage) throws InterruptedException {
		boolean actualnotifiationcontent= commonPage.seeNotifications(notificationMessage);
	    assertEquals(notificationMessage != null, actualnotifiationcontent);
	}


}