package steps;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.*;
import pages.*;
import utility.*;

public class Settingssteps {
	Settingspage settingsPage = new Settingspage(Driverhelper.getDriver());

	@When("User enter firstname and lastName data of User")
	public void user_enter_in_firstname_field_and_in_lastname_field() {
		settingsPage.enterFirstAndLastName();
	}
	
	@Then("User should see updated Name Details on the Screen")
	public void user_should_see_updated_name_details_on_the_screen() {
		assertTrue(settingsPage.verificationOfDataForFirstAndLastName());
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

	@When("User Change the Password")
	public void user_change_the_password() {
		settingsPage.changePassword();
	}

	@When("User login with {string} and click on {string} button after change password")
	public void user_login_with_and_click_on_button(String email, String btnname) {
		settingsPage.doLoginafterChangePassword(email, btnname);
	}

	@When("User Reset Change the Password")
	public void user_reset_change_the_password() {
		settingsPage.resetPassword();
	}

	@When("User click on {string} toggle")
	public void user_click_on_toggle(String twoFactorAuthenticationToggle) {
		settingsPage.clickOnTwoFactorAuthenticationToggle(twoFactorAuthenticationToggle);
	}

	@When("User enter {string} in Mobile Number field")
	public void user_enter_in_mobile_number_field(String mobileNumber) {
		settingsPage.enterMobileNumberforTwoFactorAuthentication(mobileNumber);
	}

	@When("User enter Code on screen")
	public void user_enter_code_on_screen() {
		settingsPage.enterCodeForTwoFactorAuthentication();
	}
}
