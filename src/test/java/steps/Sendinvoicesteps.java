package steps;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.*;
import pages.Sendinvoicepage;
import utility.Driverhelper;
import utility.Eventhelper;
import utility.Log;

public class Sendinvoicesteps {

	Sendinvoicepage sendInvoicePage = new Sendinvoicepage(Driverhelper.getDriver());
	Float receivableBalanceOnDashboard, receivableBalanceOnAccountingPage, receivableBalanceOnDashboardAfterLogin, totalExpectedAmount;
	String searchBusinessOnReceivable;

	@Then("Read Receivable Balance on accounting screen")
	public void read_receivable_balance_on_accounting_screen() {
		receivableBalanceOnAccountingPage = sendInvoicePage.receivableBalanceOnAccounting();
		Log.info("Existing Receivable balance on accounting screen is --->" + receivableBalanceOnAccountingPage);
	}

	@When("User enter {string} in searchbox")
	public void user_enter_in_searchbox(String businessName) {
		searchBusinessOnReceivable = businessName;
		sendInvoicePage.searchBusiness(businessName);
	}

	@When("User enter invoice details like amount is {int} and message is {string}")
	public void user_enter_invoice_details_like_amount_is_and_message_is(Integer amount, String message) {
		sendInvoicePage.sendInvoice(amount, message);
	}

	@Then("User should see the invoice on the screen")
	public void user_should_see_the_invoice_on_the_screen(io.cucumber.datatable.DataTable dataTable) {
		sendInvoicePage.sortWithDueDate();
		List<List<String>> expected = dataTable.asLists();
		List<String> expectedList = new ArrayList<String>();
		for (List<String> columns : expected) {
			expectedList.add(columns.get(0));
			expectedList.add(Eventhelper.GetTodaysdateInSpecifiedFormat());
			expectedList.add(columns.get(1));
		}
		List<String> actualList = sendInvoicePage.seeInvoice(expectedList.get(0));
		assertEquals(expectedList, actualList);
	}

	@Then("Receivable balance is updated on the screen with {string}")
	public void receivable_balance_is_updated_on_the_screen_with(String amount){
		Eventhelper.threadWait(2000);
		totalExpectedAmount = receivableBalanceOnAccountingPage + Float.parseFloat(amount); //receivableBalanceOnDashboard 
		Log.info("totalExpectedAmount after send invoice --->" + totalExpectedAmount);
		Float actualAmount = sendInvoicePage.receivableBalanceOnAccounting();
		Log.info("actual receivable Amount after send invoice --->" + actualAmount);
		//Log.info("receivableBalanceOnDashboard" + receivableBalanceOnDashboard);
		assertEquals(totalExpectedAmount, actualAmount);
		//receivableBalanceOnAccountingPage = totalExpectedAmount;
	}

	@Then("Receivable balance is updated on dashboard")
	public void receivable_balance_is_updated_on_dashboard() {
		sendInvoicePage.switchToDashboard();
		receivableBalanceOnDashboard = sendInvoicePage.readReceivableBalanceOnDashBoard();
		assertEquals(totalExpectedAmount, receivableBalanceOnDashboard);
	}

	@When("User click on Send Invoice link")
	public void user_click_on_send_invoice_link() {
		sendInvoicePage.clickOnSendInvoice();
	}

	@Then("User should see updated hopscotch balance on the screen")
	public void user_should_see_updated_hopscotch_balance_on_the_screen() {
		receivableBalanceOnDashboardAfterLogin = sendInvoicePage.receivableBalanceOnAccounting();
		//receivableBalanceOnDashboard = sendInvoicePage.readReceivableBalanceOnDashBoard();
		assertEquals(receivableBalanceOnAccountingPage, receivableBalanceOnDashboardAfterLogin);
	}
}
