package steps;

import static org.junit.Assert.*;
import io.cucumber.java.en.*;
import pages.*;
import utility.*;

public class Invoiceschedulingsteps {
	Invoiceschedulingpage invoiceScheduling = new Invoiceschedulingpage(Driverhelper.getDriver());

	@When("User click on Schedule payment Date Picker")
	public void user_click_on_schedule_payment_date_picker() {
		invoiceScheduling.selectSchedulePaymentDate();
	}

	@Then("User should see Scheduler Icon in Invoice")
	public void user_should_see_scheduler_icon_in_invoice() {
		assertTrue(invoiceScheduling.isInvoiceSchedule());
	}
}
