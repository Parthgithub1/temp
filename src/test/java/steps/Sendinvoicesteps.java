package steps;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.*;
import pages.Sendinvoicepage;
import utility.Driverhelper;
import utility.Log;

public class Sendinvoicesteps {

	Sendinvoicepage sendInvoicePage = new Sendinvoicepage(Driverhelper.getDriver());
	Float receivableBalanceOnDashboard,receivableBalanceOnAccountingPage;
	String searchBusinessOnReceivable;
		
	@Then("Read Receivable Balance on home screen")
	public void read_receivable_balance_on_home_screen()  {
	    receivableBalanceOnDashboard=  sendInvoicePage.readReceivableBalanceOnDashBoard();
	}
	
	@When("User enter {string} in searchbox")
	public void user_enter_in_searchbox(String businessName) {
		searchBusinessOnReceivable=businessName;
		sendInvoicePage.searchBusiness(businessName);
	}

	@When("User enter invoice details like amount is {int} and message is {string}")
	public void user_enter_invoice_details_like_amount_is_and_message_is(Integer amount, String message) {
		sendInvoicePage.sendInvoice(amount,message);
	}
	
	@Then("User should see the invoice on the screen")
	public void user_should_see_the_invoice_on_the_screen(io.cucumber.datatable.DataTable dataTable) {
	  sendInvoicePage.searchBusinessInGrid(searchBusinessOnReceivable);
		List<String> expectedList = new ArrayList<String>();
		List<String> actualList=sendInvoicePage.seeInvoice();
		List<List<String>> expected= dataTable.asLists();
		for (List<String> columns : expected) {
	       expectedList.add(columns.get(0));
	       expectedList.add(columns.get(1));
	       expectedList.add(columns.get(2));
	    }
		assertEquals(expectedList, actualList);
	}
	
	@Then("Receivable balance is updated on the screen with {string}")
	public void receivable_balance_is_updated_on_the_screen_with(String amount) throws InterruptedException {
		Float totalExpectedAmount = receivableBalanceOnDashboard + Float.parseFloat(amount);
		Float actualAmount= sendInvoicePage.reciavableBalanceOnAccounting();
		Log.info(actualAmount);
		Log.info(totalExpectedAmount);
		Log.info(receivableBalanceOnDashboard);
		assertEquals(totalExpectedAmount, actualAmount);
		receivableBalanceOnAccountingPage=totalExpectedAmount;
	}
	
	@Then("Receivable balance is updated on dashboard")
	public void receivable_balance_is_updated_on_dashboard() throws InterruptedException {
		sendInvoicePage.switchToDashboard();
		receivableBalanceOnDashboard=  sendInvoicePage.readReceivableBalanceOnDashBoard();
		assertEquals(receivableBalanceOnAccountingPage, receivableBalanceOnDashboard);
	}

	@Then("User should see {string} notification on the dashboard")
	public void user_should_see_notification_on_the_dashboard(String notificationMessage) throws InterruptedException {
		String actualnotifiationcontent= sendInvoicePage.isNotificationSent();
	    Log.info("Content of notificatiosn is --- >"+actualnotifiationcontent);
	    assertEquals(notificationMessage, actualnotifiationcontent);
	}
}
