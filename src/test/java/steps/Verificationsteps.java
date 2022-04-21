package steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.support.ui.ExpectedCondition;

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
		assertEquals("jack denial",expecteda);
		
	}
}
