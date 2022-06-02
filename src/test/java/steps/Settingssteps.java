package steps;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.*;
import pages.*;
import utility.*;

public class Settingssteps {
	Settingspage settingsPage = new Settingspage(Driverhelper.getDriver());

	@When("User enter {string} in Current Password field")
	public void user_enter_in_current_password_field(String currentPassword) {
	    settingsPage.enterCurrentPassword(currentPassword);
	}
	@When("User enter {string} in New Password field and {string} in Confirm New Password field")
	public void user_enter_in_new_password_field_and_in_confirm_new_password_field(String newPassword, String confirmPassword) {
	    settingsPage.enterNewAndConfirmPassword(newPassword, confirmPassword);
	}

	@When("User click on menu of the {string} bank")
	public void user_click_on_menu_of_the_bank(String string) {
	    settingsPage.clickOnMenuIconOfBank(string);
	}
	
	@When("User switch to dashboard")
	public void user_switch_to_dashboard() {
	   settingsPage.switchToDashboard();
	}
	
	@Then("User should see {string} as {string}")
	public void user_should_see_as(String bankName, String accountStatus) {
	    assertTrue(settingsPage.isAccountTypeSet(bankName, accountStatus));
	}
}
