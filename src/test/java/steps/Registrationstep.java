package steps;

import io.cucumber.java.en.*;
import pages.*;
import utility.*;

public class Registrationstep {

	Registrationpage registrationpage = new Registrationpage(Driverhelper.getDriver());

	@When("User enter {string} in firstname field")
	public void user_enter_in_firstname_field(String firstname) {
		registrationpage.enterFirstName(firstname);
	}

	@When("User enter {string} in lastname field")
	public void user_enter_in_lastname_field(String lastname) {
		registrationpage.enterLastName(lastname);
	}

	@When("User enter {string} in businessname field")
	public void user_enter_in_businessname_field(String bName) {
		registrationpage.enterBusinessName(bName);
	}

	@When("User enter otp on screen")
	public void user_enter_otp_on_screen() {
		registrationpage.enterOTP();
	}

	@When("User click on the textbox of email")
	public void user_click_on_the_textbox_of_email() {
		registrationpage.clickOnTextbox();
	}

	@When("User register with {string} email for {string}")
	public void user_register_with_email_for(String email, String businessType) {
		registrationpage.doRegister(email, businessType);
	}

	@When("User enter question details")
	public void user_enter_question_details() {
		registrationpage.enterQuestionsDetails();
	}
	
	@When("user register user with email as {string} and {string} as firstname and {string} as businessname")
	public void user_register_user_with_email_as_and_as_firstname_and_as_businessname(String email, String firstName, String businessName) {
	    registrationpage.createUser(email, firstName, businessName);
	}

}
