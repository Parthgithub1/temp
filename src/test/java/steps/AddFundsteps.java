package steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddFundspage;
import pages.Registrationpage;
import userdata.Fundsdata;
import utility.Driverhelper;
import utility.Eventhelper;
import utility.Log;

public class AddFundsteps {
	AddFundspage addFunds = new AddFundspage(Driverhelper.getDriver());
	Registrationpage registrationpage = new Registrationpage(Driverhelper.getDriver());
	Fundsdata fundData = new Fundsdata();

	@Then("the {string} button should be enabled | disabled")
	public void the_button_should_be_enabled(String btnName) {
		assertTrue(btnName +  " Button is not Enable" , addFunds.isButtonEnabled(btnName));
	}
	
	@Then("User should save Default amount")
	public void user_should_save_default_amount() {
		fundData.setAmountofhopscotchBalance(addFunds.hopscotchBalanceBeforeAddingFund());
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
		Eventhelper.threadWait(3000);
		float totalExpectedAmountBalance = fundData.getAmountofhopscotchBalance() + Float.parseFloat(expectedAmountTobeChanged);
		assertEquals(totalExpectedAmountBalance, addFunds.hopscotchBalanceAfterAddingFund(), 0);
	}
	
	@Then("User should see {string} amount on the screen for withdraw")
	public void user_should_see_amount_on_the_screen_for_withdraw(String string) {
		Eventhelper.threadWait(3000);
		float totalExpectedAmountBalance = fundData.getAmountofhopscotchBalance() - Float.parseFloat(string);
		assertEquals(totalExpectedAmountBalance, addFunds.hopscotchBalanceAfterAddingFund(), 1);
	}
	
	@When("User click on Close Icon")
	public void user_click_on_close_icon() {
		addFunds.clickonCloseIcon();
	}

}