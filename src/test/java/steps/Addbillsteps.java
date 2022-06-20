package steps;

import static org.junit.Assert.*;

import io.cucumber.java.en.*;
import pages.*;
import utility.*;

public class Addbillsteps {

	Addbillpage addBillPage = new Addbillpage(Driverhelper.getDriver());
	public static float amount;

	@When("User enter add bill details")
	public void user_enter_add_bill_details() {
		amount = addBillPage.addBill();
	}

	@When("User enter search for business in Searchbar")
	public void user_enter_search_for_business_in_searchbar() {
		addBillPage.searchBusinessInSearchBar();
	}

	@Then("User should see notification of payment of add bill on the dashboard")
	public void user_should_see_notification_of_payment_of_add_bill_on_the_dashboard() {
		assertTrue(addBillPage.verifyNotificationOfPayOfAddedBill());
	}

	@Then("User should see notification of add bill on the dashboard")
	public void user_should_see_notification_of_add_bill_on_the_dashboard() {
		assertTrue(addBillPage.verifyAddBillNotificationOnDashboard());
	}

	public static float addBillInvoiceAmount() {
		return amount;
	}
	
	@When("User click on Close button from Payable Card")
	public void user_click_on_close_button_from_payable_card() {
		addBillPage.clickonCloseIconfromPayableCard();
	}

}
