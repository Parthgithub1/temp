package steps;

import org.junit.jupiter.api.*;

import io.cucumber.java.en.*;
import pages.*;
import utility.*;

public class Verificationsteps {

	Verificationpage verificationpage = new Verificationpage(Driverhelper.getDriver());

	@When("User enter {string} in Legal business name field")
	public void user_enter_in_legal_business_name_field(String legalbusinessname) {
		verificationpage.enterLegalBusinessName(legalbusinessname);
	}

	@When("user process business address screen")
	public void user_process_business_address_screen() {
		verificationpage.enterAddress();
	}

	@When("User process business taxid screen")
	public void user_process_business_taxid_screen() {
		verificationpage.enterBusinessTax();
	}

	@When("User process add beneficial owner screen")
	public void user_process_add_beneficial_owner_screen() {
		verificationpage.addBeneficial();
	}

	@Then("User should see beneficial owner in list")
	public void user_should_see_beneficial_owner_in_list() {
		Assertions.assertTrue(verificationpage.isBeneficialAdded(), "Beneficial owner is not display on list");
	}

	@When("User process add bank screen")
	public void user_procss_add_bank_screen() {
		verificationpage.addBank();
	}

	@Then("User should see {string} link")
	public void user_should_see_link(String string) {
		boolean islinkdisplay = verificationpage.isLinkDisplay(string);
		Assertions.assertTrue(islinkdisplay, "User is already verified");
	}

	@When("User is on {string}")
	public void user_is_on(String url) {
		verificationpage.setURL(url);
	}

	@Then("User should see verified icon")
	public void user_should_see_verified_icon() {
		Assertions.assertTrue(verificationpage.isUserverified());
	}

	@When("User click on Drop-down to select Business type and select {string} from options")
	public void user_click_on_drop_down_to_select_business_type_and_select_from_options(String string) {
		verificationpage.selectDropDownforBusinessType(string);
	}

	@Then("User enters {int} taxNumber of Business")
	public void user_enters_tax_number_of_business(Integer taxNumber) {
		verificationpage.enterTaxID(taxNumber);
	}

	@Then("User should see Verification Message")
	public void user_should_see_verification_message() {
		Assertions.assertTrue(verificationpage.verificationConfirmation());
	}

	@When("User enter date of birth of user in Sole Proprietorship verification")
	public void user_enter_date_of_birth_of_user_in_sole_proprietorship_verification() {
		verificationpage.enterDateOfBirthdateofSoleProprietorship();
	}

}
