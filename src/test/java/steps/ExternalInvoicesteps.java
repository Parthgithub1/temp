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

	@When("User enter customer details")
	public void user_enter_customer_details() {
		externalInvoicePage.enterCustomerDetails();
	}

	@Then("Search the external invoice in receivable")
	public void search_the_external_invoice_in_receivable() {
		externalInvoicePage.searchBusinessInGrid();
	}
	
	@When("User throw url in browser")
	public void user_throw_url_in_browser() {
	    externalInvoicePage.setURL();
	    Eventhelper.threadWait(1000);
	}
	
	@Then("User enter bank details")
	public void user_enter_bank_details() {
	   externalInvoicePage.addBankDetails();
	}
	
	@Then("User enter OTP details")
	public void user_enter_otp_details() {
	    externalInvoicePage.enterOTP();
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

	@Then("User set login page url in browser")
	public void user_set_login_page_url_in_browser() {
	   externalInvoicePage.setLoginPageURL();
	}
}
