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
		Eventhelper.threadWait(1000);
		externalInvoicePage.setURL();
	}

	@Then("User enter bank details")
	public void user_enter_bank_details() {
		externalInvoicePage.addBankDetails();
	}

	@Then("User should see sent external invoice notiifcation on the screen")
	public void user_should_see_sent_external_innvoice_notiifcation_on_the_screen() {
		assertTrue(externalInvoicePage.verifyExternalInvoiceNotificationOnDashboard("SentExternalInvoice"));
	}

	@Then("User should see the pay of external invoice notiifcation on the screen")
	public void user_should_see_the_pay_of_external_invoice_on_the_screen() {
		assertTrue(externalInvoicePage.verifyExternalInvoiceNotificationOnDashboard("Payment"));
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

	@When("User enter security code to verify the user on the screen")
	public void user_enter_security_code_to_verify_the_user_on_the_screen() {
		externalInvoicePage.enterAuthCode();
	}

	@When("user select Bank type {string} for the external payment")
	public void user_select_bank_type_for_the_external_payment(String bankOption) {
		externalInvoicePage.selectBank(bankOption);
	}

	@When("User click on Pay button in external payment")
	public void user_click_on_pay_button_in_external_payment() {
		externalInvoicePage.clickOnButton("Pay");
	}

	@When("User click on the confirm payment button in extternal payment")
	public void user_click_on_the_confirm_payment_button_in_extternal_payment() {
		externalInvoicePage.clickOnButton("Confirm payment");
	}

	@When("User again login in environment")
	public void user_again_login_in_environment() {
		externalInvoicePage.setEnvironmentURL();
	}
	
	@When("User click on Close button from receivable Card")
	public void user_click_on_close_button_from_receivable_card() {
	    externalInvoicePage.clickonCloseIconfromReceivableCard();
	}

}
