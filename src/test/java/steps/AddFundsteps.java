package steps;

import static org.junit.Assert.*;

import java.text.DecimalFormat;

import io.cucumber.java.en.*;
import pages.*;
import userdata.*;
import utility.*;

public class AddFundsteps {
	AddFundspage addFunds = new AddFundspage(Driverhelper.getDriver());
	Registrationpage registrationpage = new Registrationpage(Driverhelper.getDriver());
	Fundsdata fundData = new Fundsdata();
	Homepage homePage = new Homepage(Driverhelper.getDriver());
	float currentHopscotchBalance;

	@Then("the {string} button should be enabled | disabled")
	public void the_button_should_be_enabled(String btnName) {
		assertTrue(btnName + " Button is not Enable", addFunds.isButtonEnabled(btnName));
	}

	@When("User should save current hopscotch balance")
	public void user_should_save_current_hopscotch_balance() {
		 currentHopscotchBalance = homePage.getCurrentHopscotchBalanceAmount();
		Log.info("Current Hopscotch Balance :" + currentHopscotchBalance);
		fundData.setAmountofhopscotchBalance(currentHopscotchBalance);
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

	@Then("User should see {string} model open")
	public void user_should_see_model_open(String string) {
		boolean amountTextDisplay = addFunds.modalHeader(string) != null;
		assertTrue(amountTextDisplay);
	}

	@When("User enter {double} in amount field to {string} funds")
	public void user_enter_in_amount_field1(double amount, String fundProcess) {
		float amountToEnter;
		if (fundProcess.equals("Add")) {
			amountToEnter = ((float) amount + Eventhelper.numberFormat(fundData.getAmountofhopscotchBalance()));
		} else {
			amountToEnter = (Eventhelper.numberFormat(fundData.getAmountofhopscotchBalance()) - (float) amount);
		}
		amountToEnter = Eventhelper.ConvertFloatTo2DecimalFloat(amountToEnter);
		Log.info("User enter in " + fundProcess + " Funds Modal :" + amountToEnter);
		addFunds.enterAmount(amountToEnter);
		fundData.setAmountofhopscotchBalance(amountToEnter);
	}

	@Then("User should see {string} amount on the screen")
	public void user_should_see_amount_on_the_screen(String expectedAmountTobeChanged) {
		Eventhelper.threadWait(8000);
		float totalExpectedAmountBalance = fundData.getAmountofhopscotchBalance()
				+ fundData.getAmountofhopscotchBalance() - Float.parseFloat(expectedAmountTobeChanged);
		DecimalFormat df = new DecimalFormat(".00");
		float expectedHopscotchBalanceAfterAddingFund = Float.valueOf(df.format(totalExpectedAmountBalance));
		float actualHopscotchBalanceAfterAddingFund = addFunds.hopscotchBalanceAfterAddingFund();
		Log.info("Actual Amount After Adding funds :" + actualHopscotchBalanceAfterAddingFund);
		Log.info("Expected Amount After Adding funds :" + expectedHopscotchBalanceAfterAddingFund);
		assertEquals(expectedHopscotchBalanceAfterAddingFund, actualHopscotchBalanceAfterAddingFund, 0);
	}

	@Then("User should see {string} amount on the screen for withdraw")
	public void user_should_see_amount_on_the_screen_for_withdraw(String amount) {
		Eventhelper.threadWait(8000);
		float expectedAmount = Float.parseFloat(amount);
		float actualAmount = addFunds.hopscotchBalanceAfterAddingFund();
		Log.info("Actual Amount after withdraw Funds:" + actualAmount);
		Log.info("Expected Amount after withdraw Funds:" + expectedAmount);
		assertEquals(expectedAmount, actualAmount, 1);
	}

	@When("User click on Close Icon")
	public void user_click_on_close_icon() {
		addFunds.clickonCloseIcon();
	}

	@When("User again enters the amount to withdraw")
	public void user_again_enters_the_amount_to_withdraw() {
		addFunds.clearAmountEnter();
	}

	@Then("User should see {string} button as disabled if Amount is Less then Zero")
	public void user_should_see_button_has_if_amount_is_less_then_zero(String btnName) {
		if(currentHopscotchBalance <= 0.00) {
			Log.info(btnName + " Button is not Enable : " + !addFunds.isButtonEnabled(btnName));
			assertTrue(btnName + " Button is not Enable : ", !addFunds.isButtonEnabled(btnName));
		}
	}
	
	@When("User enter amount to {string} funds")
	public void user_enter_amount_to_funds(String fundProcess) {
		Log.info("User enter in " + fundProcess + " Funds Modal :" + currentHopscotchBalance);
		addFunds.enterAmount(Eventhelper.ConvertFloatTo2DecimalFloat(currentHopscotchBalance));
	}
	
	@When("User enter amount more then current balance to {string} funds")
	public void user_enter_amount_more_then_current_balance_to_funds(String fundProcess) {
		float amountToEnter = currentHopscotchBalance + 1;
		Log.info("User enter in " + fundProcess + " Funds Modal :" + amountToEnter);
		addFunds.enterAmount(Eventhelper.ConvertFloatTo2DecimalFloat(amountToEnter));
	}
}