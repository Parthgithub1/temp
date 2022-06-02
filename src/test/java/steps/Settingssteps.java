package steps;

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
}
