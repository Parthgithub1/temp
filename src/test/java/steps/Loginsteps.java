package steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import io.cucumber.java.en.*;
import pages.*;
import utility.Driverhelper;

public class Loginsteps {
	Loginpage loginpage = new Loginpage(Driverhelper.getDriver());

	@Then("User should see validation message for maximum attempts")
	public void user_should_see_text_on_the_screen() {
		boolean isAttemptText = loginpage.isAttemptTextDisplayed();
		assertTrue(isAttemptText);
	}

	@Then("User should see {string} on the screen")
	public void user_should_see_on_the_screen(String expectedValidationMessage) {
		assertEquals(expectedValidationMessage, loginpage.isValidationDisplayed());
	}

	@Then("User should see {string} validation message for email format")
	public void user_should_see_validation_message_for_email_format(String expectedEmailValidationMessage) {
		assertEquals(expectedEmailValidationMessage, loginpage.isEmailEnterInCorrectFormat());
	}
}