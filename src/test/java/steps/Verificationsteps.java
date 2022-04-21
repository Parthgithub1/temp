package steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import io.cucumber.java.en.*;
import pages.Verificationpage;
import utility.Driverhelper;

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
		String expecteda = verificationpage.isBeneficialAdded();
		assertEquals("jack denial", expecteda);
	}

	@When("User procss add bank screen")
	public void user_procss_add_bank_screen() {
		verificationpage.addBank();
	}

	@Then("User should see {string} link")
	public void user_should_see_link(String string) {
		boolean islinkdisplay = verificationpage.isLinkDisplay(string);
		assertTrue("User is already verified", islinkdisplay);
	}

	@When("User is on {string}")
	public void user_is_on(String url) {
		verificationpage.setURL(url);
	}

	@Then("User should see verified icon")
	public void user_should_see_verified_icon() {
		assertTrue("Verified icon not display", verificationpage.isUserverified());
	}

}
