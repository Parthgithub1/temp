package steps;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.*;
import pages.AddFundspage;
import pages.Payinvoicepage;
import utility.Driverhelper;
import utility.Log;

public class Payinvoivesteps {
	
	Payinvoicepage payInvoice = new Payinvoicepage(Driverhelper.getDriver());
	AddFundspage addFunds = new AddFundspage(Driverhelper.getDriver());
	float existingAmountBalance;
	float actualPayableBalanceonAccountingPage;
	float actualPayableBalanceonHomePage;
	float invoiceAmount;
	
	@Then("User should save Default amount of Payable")
	public void user_should_save_default_amount_of_payable() {
		actualPayableBalanceonHomePage=	payInvoice.getexistingBalanceofPayableofHomePage();
	  
	}
	@Then("User click on Payable Container")
	public void user_click_on_payable_container() {
			payInvoice.clickOnPayableContanier();
	}
	
	@Then("User should save Default amount of Payable on Accounting Page")
	public void user_should_save_default_amount_of_payable_on_accounting_page() {
		actualPayableBalanceonAccountingPage = payInvoice.getexistingBalanceofPayableonAccountingPage();
	}

	
	@When("User click on Invoice from Payable tab")
	public void user_click_on_invoice_from_payable_tab() {
	    payInvoice.clickOnInvoice();
	}
	
	@Then("User should see the amount to be Payable")
	public void user_should_see_the_amount_to_be_payable() {
		invoiceAmount = payInvoice.invoiceAmountUserPaying();
	}
	
	@Then("User should see new amount on the screen for Payables")
	public void user_should_see_new_amount_on_the_screen_for_payables() {
		float expectedAmount = actualPayableBalanceonHomePage - invoiceAmount ;
		Log.info(expectedAmount);
		assertEquals(expectedAmount, actualPayableBalanceonAccountingPage, 0);	
	}
}
