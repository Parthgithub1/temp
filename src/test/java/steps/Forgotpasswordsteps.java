package steps;

import io.cucumber.java.en.When;
import pages.*;
import utility.Driverhelper;

public class Forgotpasswordsteps {
	Forgotpasswordpage forgotPassword = new Forgotpasswordpage(Driverhelper.getDriver());
	
	@When("User click on Back Icon from screen")
	public void user_click_on_back_icon_from_screen() {
		forgotPassword.backIconClickfromForgotPasswordScreen();
	}
}
