package steps;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.*;
import pages.*;
import utility.*;

public class Settingssteps {
	Settingspage settingsPage = new Settingspage(Driverhelper.getDriver());
	Commonpage commonPage = new Commonpage(Driverhelper.getDriver());

	@When("User login with {string} and Login again after change password")
	public void user_login_with_and_click_on_button(String feature) {
		String email = commonPage.getEmailAsPerFeature(feature);
		settingsPage.doLoginafterChangePassword(email);
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

	@When("User Edit the Password")
	public void user_edit_the_password() {
		settingsPage.resetPassword();
	}

	@When("User enter value in current Password field")
	public void user_enter_in_current_password_field() {
		settingsPage.enterCurrentPassword();
	}

	@When("User enter value in new Password field")
	public void user_enter_in_new_password_field() {
		settingsPage.enterNewPassword();
	}
	
	@When("User enter value in confirm Password field")
	public void user_enter_in_confirm_password_field() {
	   settingsPage.enterConfirmPassword();
	}
	
	@When("User enter {string} in new Password field")
	public void user_enter_in_new_password_field(String wrongFormatNewPassword) {
		settingsPage.enterWrongFormatNewPassword(wrongFormatNewPassword);
	}
	
	@When("User try Change the Password")
	public void user_try_change_the_password() {
	    settingsPage.enterConfirmPasswordNotMatch();
	}
	
	@When("User enter Wrong Code on screen")
	public void user_enter_Wrong_code_on_screen() {
		settingsPage.enterWrongCodeForTwoFactorAuthentication();
	}
	
	@When("User save the bank detail of currrently added bank")
	public void user_save_the_bank_detail_of_currrently_added_bank() {
	    settingsPage.getNameOfCurrentBankAdded();
	}
	
	@When("User add existing bank account on Payment Method")
	public void user_add_existing_bank_account_on_payment_method() {
		commonPage.addBankInPlaid(settingsPage.getNameOfCurrentBankAdded());
	}
	
	@When("User update the branding details on the setting page")
	public void user_update_the_branding_details_on_the_setting_page() {
	    settingsPage.enterBrandingInformation();
	}
	
	@Then("User should see the remove image option for {string} in the appeared dialog box")
	public void user_should_see_the_remove_image_option_for_in_the_appeared_dialog_box(String imageOption) {
	    settingsPage.checkRemoveOptionInBrandingOption(imageOption);
	}
}
