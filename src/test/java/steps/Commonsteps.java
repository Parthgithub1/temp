package steps;

import static org.junit.Assert.assertTrue;
import io.cucumber.java.en.*;
import pages.*;
import utility.*;

public class Commonsteps {

	Commonpage commonPage = new Commonpage(Driverhelper.getDriver());
	Loginpage loginPage = new Loginpage(Driverhelper.getDriver());
	AddFundspage addFunds = new AddFundspage(Driverhelper.getDriver());

	@When("User login for {string}")
	public void user_login_for(String feature) {
		loginPage.doLogin(commonPage.getEmailAsPerFeature(feature));
	}

	@Then("User should navigate to dashboard {string}")
	public void user_should_navigate_to_dashboard(String feature) {
		String email = commonPage.getEmailAsPerFeature(feature);
		assertTrue(loginPage.isHompageDisplay(email));
	}

	@When("User click on {string} link")
	public void user_click_on_link(String linktext) {
		commonPage.clickOnLink(linktext);
		Log.info("User clicking on " + linktext);
	}

	@When("User click on {string} button")
	public void user_click_on_button(String buttoname) {
		commonPage.clickOnButton(buttoname);
	}

	@Then("User should see {string} text on the screen")
	public void user_should_see_text_on_the_screen(String expectedText) {
		Eventhelper.threadWait(5000);
		assertTrue("Expected text not display :" + expectedText, commonPage.isTextDisplayed(expectedText));
	}

	@Then("User should not see {string} text on the screen")
	public void user_should_not_see_text_on_the_screen(String expectedText) {
		assertTrue("Expected text  display : " + expectedText, commonPage.isTextNotDisplayed(expectedText));
	}

	@When("User click on Profile Drop Down")
	public void user_click_on_profile_drop_down() {
		commonPage.clickonDropDownofProfile();
	}

	@When("User click on {string} option from Profile Drop-Down")
	public void user_click_on_option_from_profile_drop_down(String menuOption) {
		commonPage.clickonLinkfromProfileDropDownOption(menuOption);
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

	@Then("User should see {string} notification")
	public void user_should_see_notification(String notificationMessage) throws InterruptedException {
		assertTrue(commonPage.isNotificationPresentInList(notificationMessage));
	}

	@Then("User wait till pop up gets closed")
	public void user_wait_till_pop_up_gets_closed() {
		assertTrue(commonPage.isPopUpClose());
	}

	@When("User click on Notification option from Header")
	public void user_click_on_option_from_header() {
		commonPage.clickonNotificationfromHeader();
	}

	@When("User process add {string} bank screen")
	public void user_process_add_bank_screen(String bankName) {
		commonPage.addBankInPlaid(bankName);
	}

	@When("User hover on {string}")
	public void user_hover_on(String buttonName) {
		commonPage.hoverOnButton(buttonName);
	}

	@Then("The {string} button should be {string}")
	public void the_button_should_be(String btnName, String isStatus) {
		boolean buttonStatus = addFunds.isButtonEnabled(btnName);
		if (isStatus.contains("enabled")) {
			assertTrue(btnName + " Button is Enable", buttonStatus);
		} else {
			assertTrue(btnName + " Button is not Enable", !buttonStatus);
		}
	}

	@When("User click on the business logo on the dashboard")
	public void user_click_on_the_business_logo_on_the_dashboard() {
		commonPage.clickOnTheBusinessLogoOnTheDashboard();
	}

	@Then("User is moved to the next tab")
	public void user_is_moved_to_the_next_tab() {
		commonPage.switchToNextTab();
	}
	
	@When("User close the userflow dialog on the screen")
	public void user_close_the_userflow_dialog_on_the_screen() {
	   commonPage.closeUserFlowDialog();
	}
	
}
