package steps;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import io.cucumber.java.en.*;
import pages.*;
import userdata.*;
import utility.*;

public class Payinvoivesteps {

	Payinvoicepage payInvoice = new Payinvoicepage(Driverhelper.getDriver());
	Sendinvoicepage sendInvoice = new Sendinvoicepage(Driverhelper.getDriver());

	Loginpage loginPage = new Loginpage(Driverhelper.getDriver());
	Addbillpage addBillPage = new Addbillpage(Driverhelper.getDriver());
	AddFundspage addFunds = new AddFundspage(Driverhelper.getDriver());
	Fundsdata fundData = new Fundsdata();
	Addbillsteps addBillSteps = new Addbillsteps();
	Payinvoicedata payData = new Payinvoicedata();
	Commonpage commonPage = new Commonpage(Driverhelper.getDriver());
	Homepage homepage = new Homepage(Driverhelper.getDriver());
	float amountOfRejectedCard, getexistingBalanceofPayableonAccountingPage;
	static float hopscotchBalance;

	@When("User click on {string} Container")
	public void user_click_on_container(String string) {
		payInvoice.clickOnContanier(string);
	}

	@When("User should save Default amount of Payable on Accounting Page")
	public void user_should_save_default_amount_of_payable_on_accounting_page() {
		// Eventhelper.threadWait(5000);
		getexistingBalanceofPayableonAccountingPage = payInvoice.getexistingBalanceofPayableonAccountingPage();
		payData.setBalanceofPayableonAccountingPage(getexistingBalanceofPayableonAccountingPage);
		Log.info("Existing payable balance on accounting screen is:- " + getexistingBalanceofPayableonAccountingPage);
	}

	@When("User click on Invoice from Payable tab")
	public void user_click_on_invoice_from_payable_tab() {
		payInvoice.clickOnInvoice();
	}

	@When("User should see the amount to be Payable")
	public void user_should_see_the_amount_to_be_payable() {
		payData.setInvoiceAmounttobePaid(payInvoice.invoiceAmountUserPaying());
	}

	@Then("User should see new amount on the screen for Payables")
	public void user_should_see_new_amount_on_the_screen_for_payables() {
		homepage.waitUntiAddFundsButtonEnabled();
		float expectedAmount = payData.getBalanceofPayableonAccountingPage();// - payData.getInvoiceAmounttobePaid();
		System.out.println(expectedAmount);
		System.out.println(payData.getDefaultPayableBalanceatHomePage());
		System.out.println(payData.getInvoiceAmounttobePaid());
		assertEquals(expectedAmount, payData.getBalanceofPayableonAccountingPage(), 0);
	}

	@Then("User should see update amount of Hopscotch Balance on Accounting Page")
	public void user_should_see_update_amount_of_hopscotch_balance_on_accounting_page() {
		homepage.waitUntiAddFundsButtonEnabled();
		float updateHopscotchBalance = fundData.getAmountofhopscotchBalance() - payData.getInvoiceAmounttobePaid();
		Log.info(updateHopscotchBalance);
		assertEquals(updateHopscotchBalance, fundData.getAmountofhopscotchBalance(), 1);
	}

	@Then("User should save the amount of Hopscotch Balance from Accounting Page")
	public void user_should_save_the_amount_of_hopscotch_balance_from_accounting_page() {
		hopscotchBalance=homepage.getCurrentHopscotchBalanceAmount();
		fundData.setAmountofhopscotchBalance(hopscotchBalance);
	}
	
	@When("User enter {string} in Searchbar")
	public void user_enter_in_searchbar(String string) {
		payInvoice.enterInSearchBar(string);
	}

	@Then("User should see invoice details of invoice details on the screen")
	public void user_should_see_invoice_details_of_invoice_details_on_the_screen(
			io.cucumber.datatable.DataTable dataTable) {
		List<String> expectedList = new ArrayList<String>();
		List<String> actualList = payInvoice.seeInvoice();
		List<List<String>> expected = dataTable.asLists();
		for (List<String> columns : expected) {
			expectedList.add(columns.get(0));
			expectedList.add(Eventhelper.getTodaysdateInSpecifiedFormat());
			expectedList.add(columns.get(1));
		}
		assertEquals(expectedList, actualList);
	}

	@Then("User should save the amount of Completed Payables Balance from Accounting Page")
	public void user_should_save_the_amount_of_completed_payables_balance_from_accounting_page() {
		payData.setExistingBalanceofCompletedPayables(payInvoice.getexistingBalanceofCompletedPayables());
	}

	@Then("User should see updated amount of Completed Payable Balance")
	public void user_should_see_updated_amount_of_completed_payable_balance() {
		float updateHopscotchBalanceCompletedPayables = payData.getExistingBalanceofCompletedPayables()
				+ payData.getInvoiceAmounttobePaid();
		Log.info(updateHopscotchBalanceCompletedPayables);
		assertEquals(updateHopscotchBalanceCompletedPayables, fundData.getAmountofhopscotchBalance(), 1);
	}

	@Then("User click on {string} button to navigate to dashboard")
	public void user_click_on_button_to_navigate_to_dashboard(String buttoname) {
		commonPage.clickonLinkfromProfileDropDownOption(buttoname);
	}

	@Then("User should see updated payable amount on the screen")
	public void user_should_see_updated_payable_amount_on_the_screen() {
		Eventhelper.threadWait(3000);
		float expectedAmount = payData.getBalanceofPayableonAccountingPage();
		float actualAmount = payInvoice.getexistingBalanceofPayableonAccountingPage();
		assertEquals(expectedAmount, actualAmount, 0);
	}

	@Then("User see the updated payable balance before paying invoice of add bill")
	public void user_see_the_updated_payable_balance_before_paying_invoice_of_add_bill() {
		Eventhelper.threadWait(3000);
		float expectedAmount = payData.getBalanceofPayableonAccountingPage() + Addbillsteps.addBillInvoiceAmount();
		float actualAmount = payInvoice.getexistingBalanceofPayableonAccountingPage();
		assertEquals(expectedAmount, actualAmount, 0);
	}

	@When("User enter {string} in Searchbar of {string}")
	public void user_enter_in_searchbar_of(String Businessname, String AccountingSection) {
		payInvoice.enterInSearchBar(Businessname, AccountingSection);
	}

	@Then("User should see the amount of the card")
	public void user_should_see_the_amount_of_the_card() {
		amountOfRejectedCard = sendInvoice.invoiceAmount("Payable");
	}

	@Then("Payable balance is updated on the screen")
	public void payable_balance_is_updated_on_the_screen() {
		float expectedAmount = getexistingBalanceofPayableonAccountingPage - amountOfRejectedCard;
		float actualAmount = payInvoice.getexistingBalanceofPayableonAccountingPage();
		Log.info("Expected amount is " + expectedAmount);
		Log.info("Actual amount is " + actualAmount);
		assertEquals(expectedAmount, actualAmount, 0);
	}

	@Then("Payable balance is updated on the screen once user delete invoice")
	public void payable_balance_is_updated_on_the_screen_once_user_delete_invoice() {
		float expectedAmount = getexistingBalanceofPayableonAccountingPage - Addbillsteps.addBillInvoiceAmount();
		float actualAmount = payInvoice.getexistingBalanceofPayableonAccountingPage();
		assertEquals(expectedAmount, actualAmount, 0);
	}
	
	public static float currentHopscotchBalance() {
	return hopscotchBalance;	
	}
}
