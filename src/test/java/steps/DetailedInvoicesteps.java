package steps;

import static org.junit.Assert.*;
import io.cucumber.java.en.*;
import pages.*;
import utility.*;

public class DetailedInvoicesteps {
	Detailedinvoicepage detailedInvoice = new Detailedinvoicepage(Driverhelper.getDriver());
	Commonpage commonPage = new Commonpage(Driverhelper.getDriver());

	@When("User click on {string} option for Invoice")
	public void user_click_on_option_for_invoice(String invoiceType) {
		detailedInvoice.clickOnDetailedInvoiceToggle(invoiceType);
	}

	@When("User click on {string} button and enter Tax Rate {float}")
	public void user_click_on_button_and_enter_tax_rate(String addTaxButton, float taxRate) {
		detailedInvoice.clickOnAddTaxButtonAndEnterTax(addTaxButton, taxRate);
	}

	@When("User enter Item Details for Invoice")
	public void user_enter_item_details_for_invoice() {
		detailedInvoice.enterMultipleItemsInInvoice();
	}

	@Then("User should see Total Amount and subtotal amount are matched")
	public void user_should_see_total_amount_and_subtotal_amount_are_matched() {
		assertTrue(detailedInvoice.isIteamAmountAndSubtotalAmountMatched());
	}

	@Then("User should see amount value for Item added")
	public void user_should_see_amount_value_for_item_added() {
		assertTrue(detailedInvoice.isIteamAmountMatchedWithRateAndQty());
	}

	@When("User click on {string} label")
	public void user_click_on_label(String viewInvoiceLabel) {
		detailedInvoice.viewInvoicewithDetailedView(viewInvoiceLabel);
	}

	@When("User should close the Invoice")
	public void user_should_close_the_invoice() {
		detailedInvoice.closeInvoice();
	}

	@Then("User should see the deatails added in Invoice")
	public void user_should_see_the_deatails_added_in_invoice() {
		assertTrue(detailedInvoice.verificationOfDeatilsAddedInInvoice());
	}

	@Then("User should see Tax value added in Invoice")
	public void user_should_see_tax_value_added_in_invoice() {
		assertTrue(detailedInvoice.isTaxAmountAdded());
	}

	@When("User remove the added row for adding item Details")
	public void user_remove_the_added_row_for_adding_item_details() {
		commonPage.clickOnButton("Add item");
		detailedInvoice.deleteRowAdded();
	}

	@Then("User should verify that added row is deleted")
	public void user_should_verify_that_added_row_is_deleted() {
		assertTrue(detailedInvoice.isRowDeleted());
	}

	@When("User select the Date to send Invoice after {int} days")
	public void user_select_the_date_to_send_invoice_after_days(Integer paymentTermsPeriod) {
		detailedInvoice.setDateForInvoices(paymentTermsPeriod);
	}

	@Then("User should see the Due Date according to the Payment Term Selection of {int} days")
	public void user_should_see_the_due_date_according_to_the_payment_term_selection_of_days(Integer dueDate) {
		assertTrue(detailedInvoice.paymentTermsDate(dueDate));
	}
}