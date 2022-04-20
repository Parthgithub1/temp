package steps;

import static org.junit.Assert.assertTrue;
import io.cucumber.java.en.*;
import pages.Loginpage;
import utility.*;


public class loginSteps {
	
	Loginpage loginpage = new Loginpage(Driverhelper.getDriver());
	
	@Then("User should see validation message for maximum attempts")
	public void user_should_see_text_on_the_screen() {
		boolean isAttemptText = loginpage.isAttemptTextDisplayed();
		assertTrue(isAttemptText);
		
	}
	
}