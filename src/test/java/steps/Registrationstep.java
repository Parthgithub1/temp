package steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.*;
import pages.Registrationpage;
import utility.Driverhelper;
import utility.Log;

public class Registrationstep {

	Registrationpage registrationpage = new Registrationpage(Driverhelper.getDriver());

	@When("User click on {string} link")
	public void user_click_on_link(String linktext) {
		registrationpage.clickOnLink(linktext);
		Log.info("User is on registration page" + linktext);
	}

	@When("User enter {string} in email field")
	public void user_enter_in_email_field(String emailaddress) {
		registrationpage.enterEmailAddress(emailaddress);
		Log.info("User is on enter email field value is " + emailaddress);

	}

	@When("User click on {string} button")
	public void user_click_on_button(String buttoname) {
		registrationpage.clickOnButton(buttoname);
	}

	@When("User enter {string} in firstname field")
	public void user_enter_in_firstname_field(String firstname) {
		registrationpage.enterFirstName(firstname);
	}

	@When("User enter {string} in lastname field")
	public void user_enter_in_lastname_field(String lastname) {
		registrationpage.enterLastName(lastname);
	}

	@When("User enter {string} in businessname field")
	public void user_enter_in_businessname_field(String bname) {
		registrationpage.enterBusinessAddress(bname);
	}

	@When("User enter {string} in password field")
	public void user_enter_in_password_field(String password) {
		registrationpage.enterPassword(password);
	}

	@When("User enter otp on registration page")
	public void user_enter_otp_on_registration_page() {
		registrationpage.enterOTP();
	}

	@Then("User should see {string} text on the screen")
	public void user_should_see_text_on_the_screen(String expectedText) {
		boolean isTextDisplay = registrationpage.isTextDisplayed(expectedText);
		assertTrue(isTextDisplay);
	}

	@When("User click on the textbox of email")
	public void user_click_on_the_textbox_of_email() {
		registrationpage.clickOnTextbox();
	}

	@When("User press the tab button")
	public void user_press_the_tab_button() {
		registrationpage.sendTab();
	}
}
