package steps;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.*;
import pages.*;
import utility.*;

public class DetailedInvoicesteps {
	Detailedinvoicepage detailedInvoice = new Detailedinvoicepage(Driverhelper.getDriver());

	@When("User click on {string} option for Invoice")
	public void user_click_on_option_for_invoice(String invoiceType) {
		detailedInvoice.clickOnDetailedInvoiceToggle(invoiceType);
	}

	@When("User click on {string} button and enter Tax Rate")
	public void user_click_on_button_and_enter_tax_rate(String addTaxButton) {
		detailedInvoice.clickOnAddTaxButtonAndEnterTax(addTaxButton);
	}

	@When("User enter Item Details for Invoice")
	public void user_enter_item_details_for_invoice() {
		detailedInvoice.enterDetailsOfItemForInvoice();
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
}