package steps;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.*;
import pages.Loginpage;
import utility.Driverhelper;

public class Loginsteps {
Loginpage loginpage = new Loginpage(Driverhelper.getDriver());
	
	@Then("User should see validation message for maximum attempts")
	public void user_should_see_text_on_the_screen() {
		boolean isAttemptText = loginpage.isAttemptTextDisplayed();
		assertTrue(isAttemptText);
		
	}
	@When("User login with {string} and {string} and click on {string} button")
	public void user_login_with_and_and_click_on_button(String email, String pass, String login) {
	   loginpage.doLogin(email, pass, login);
	}
}