package steps;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.*;
import pages.Externalinvoicepage;
import utility.Driverhelper;
import utility.Eventhelper;

public class ExternalInvoicesteps {

	Externalinvoicepage externalInvoicePage = new Externalinvoicepage(Driverhelper.getDriver());

	@Then("User is able to add a new business details")
	public void user_is_able_to_add_a_new_business_details() {
		externalInvoicePage.clickToAddNewBusiness();
	}

	@Then("Search the external invoice in receivable")
	public void search_the_external_invoice_in_receivable() {
		externalInvoicePage.searchBusinessInGrid();
	}
	
	@When("User set external invoice url in browser")
	public void user_set_external_invoice_url_in_browser() {
		externalInvoicePage.setURL();
		Eventhelper.threadWait(1000);
	}

	@Then("User enter bank details")
	public void user_enter_bank_details() {
		externalInvoicePage.addBankDetails();
	}

	@Then("User should see sent external invoice notiifcation on the screen")
	public void user_should_see_sent_external_innvoice_notiifcation_on_the_screen() {
		assertTrue(externalInvoicePage.verifyExternalInvoiceNotificationOnDashboard("You sent an invoice to"));
	}

	@Then("User should see the pay of external invoice notiifcation on the screen")
	public void user_should_see_the_pay_of_external_invoice_on_the_screen() {
		assertTrue(externalInvoicePage.verifyExternalInvoiceNotificationOnDashboard("paid an invoice for"));
	}

	@Then("User is close the appeared dialog")
	public void user_is_close_the_appeared_dialog() {
		externalInvoicePage.closeDialogbox();
	}

	@Then("User should see the businessname of the external invoice sender")
	public void user_should_see_the_businessname_of_the_external_invoice_sender() {
		assertTrue(externalInvoicePage.verifyExternalInvoiceSender());
	}

	@Then("Read businessname from the dashboard")
	public void read_businessname_from_the_dashboard() {
		externalInvoicePage.readBusinessNameOndashboard();
	}
	
	@When("User enter contact details")
	public void user_enter_contact_details() {
	    externalInvoicePage.enterConrtactDetails();
	}

	@When("User enter {string} as a vendor")
	public void user_enter_as_a_vendor(String businessName) {
	   externalInvoicePage.enterBusinessName(businessName);
	}
	
	@When("User enter {string} as a Contact first name")
	public void user_enter_as_a_contact_first_name(String firstName) {
	   externalInvoicePage.enterFirstName(firstName);
	}
	
	@When("User enter {string} as a Contact last name")
	public void user_enter_as_a_contact_last_name(String lastName) {
	    externalInvoicePage.enterLastName(lastName);
	}
	
	@When("User enter {string} as a contact email")
	public void user_enter_as_a_contact_email(String email) {
	   externalInvoicePage.enterEmail(email);
	}

	@When("User press the tab button on {string}")
	public void user_press_the_tab_button_on(String fieldName) {
	   externalInvoicePage.performTabOnField(fieldName);
	}
}
