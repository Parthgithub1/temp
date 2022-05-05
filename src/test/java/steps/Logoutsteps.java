package steps;

import io.cucumber.java.en.*;
import pages.*;
import utility.*;

public class Logoutsteps {
	
	Logoutpage logOut = new Logoutpage(Driverhelper.getDriver());
	
	@When("User click on Profile Drop Down")
	public void user_click_on_profile_drop_down() {
		logOut.clickonDropDownofProfile();
	}
	@Then("User click on {string} option from Profile Drop-Down")
	public void user_click_on_option_from_profile_drop_down(String string) {
		logOut.clickonLogOutOptionfromProfileDropDown(string);
	}

}
