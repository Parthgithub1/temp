package steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddFundspage;
import pages.Registrationpage;
import utility.Driverhelper;
import utility.Log;

public class AddFundsteps {
	AddFundspage addFunds = new AddFundspage(Driverhelper.getDriver());
	Registrationpage registrationpage = new Registrationpage(Driverhelper.getDriver());
	float existingAmountBalance;

	@Then("the {string} button should be enabled | disabled")
	public void the_button_should_be_enabled(String btnName) {
		assertTrue(btnName +  " Button is not Enable" , addFunds.isButtonEnabled(btnName));
	}
	
	@Then("User should save Default amount")
	public void user_should_save_default_amount() {
		existingAmountBalance = addFunds.getexistingBalance();
	    
	}
	
	@Then("the {string} button should be {string}")
	public void the_button_should_be(String btnName, String isStatus) {
	  boolean buttonStatus = addFunds.isButtonEnabled(btnName);
	  if(isStatus.contains("enabled")){
		  assertTrue(btnName +  " Button is not Enable" , buttonStatus);
	  }
	  else {
		  assertTrue(btnName +  " Button is Enable" , !buttonStatus);
	  }
	}
	
	@Then("User should see {string} model open")
	public void user_should_see_model_open(String string) {
		boolean amountTextDisplay = addFunds.modalHeader(string) != null;
		assertTrue(amountTextDisplay);
	    
	}

	@When("User enter {int} in amount field")
	public void user_enter_in_amount_field1(int amount) {
		addFunds.addAmount(amount);
		Log.info("User is on enter Amount field value is " + amount);
	}
	
	@Then("User should see {string} amount on the screen")
	public void user_should_see_amount_on_the_screen(String expectedAmountTobeChanged) {
		float actualAmountDisplayed = addFunds.amtText();
		float totalExpectedAmountBalance = existingAmountBalance + Float.parseFloat(expectedAmountTobeChanged);
		Log.info(existingAmountBalance);
		assertEquals(totalExpectedAmountBalance, actualAmountDisplayed, 0);
	}
	
	@Then("User should see {string} amount on the screen for withdraw")
	public void user_should_see_amount_on_the_screen_for_withdraw(String string) {
		float actualAmountBalance = addFunds.amtText();
		float totalExpectedAmountBalance = existingAmountBalance - Float.parseFloat(string);
		Log.info(existingAmountBalance);
		assertEquals(totalExpectedAmountBalance, actualAmountBalance, 1);
	}
}