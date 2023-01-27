package steps;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.*;
import pages.*;
import userdata.Fundsdata;
import userdata.Payinvoicedata;
import utility.Driverhelper;
import utility.Eventhelper;
import utility.Log;

public class Sendinvoicesteps {

	Sendinvoicepage sendInvoicePage = new Sendinvoicepage(Driverhelper.getDriver());
	Commonpage commonPage = new Commonpage(Driverhelper.getDriver());
	Homepage homepage = new Homepage(Driverhelper.getDriver());
	Fundsdata fundData = new Fundsdata();
	Payinvoicedata payData = new Payinvoicedata();
	Float receivableBalanceOnDashboard, receivableBalanceOnAccountingPage, receivableBalanceOnDashboardAfterLogin,
			totalExpectedAmount, amountOfInvoice, amountOfRejectedCard, flowedAmount;
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
		sendInvoicePage.sortWithDueDate("Receivable");
		List<List<String>> expected = dataTable.asLists();
		List<String> expectedList = new ArrayList<String>();
		for (List<String> columns : expected) {
			expectedList.add(columns.get(0));
			expectedList.add(Eventhelper.getTodaysdateInSpecifiedFormat());
			expectedList.add(columns.get(1));
		}
		List<List<String>> actualList = sendInvoicePage.seeInvoice(expectedList.get(0));
		boolean isInvoicePresent = false;
		for (List<String> list : actualList) {
			isInvoicePresent = list.equals(expectedList);
			if (isInvoicePresent) {
				break;
			}
		}
		assertTrue(isInvoicePresent);
	}
	
	@Then("User should see the invoice on the screen for {string} days payment term")
	public void user_should_see_the_invoice_on_the_screen_for_days_payment_term(String number_of_days, io.cucumber.datatable.DataTable dataTable) {
		sendInvoicePage.sortWithDueDate("Receivable");
		List<List<String>> expected = dataTable.asLists();
		List<String> expectedList = new ArrayList<String>();
		for (List<String> columns : expected) {
			expectedList.add(columns.get(0));
			expectedList.add(Eventhelper.getInvoiceDueDateInSpecifiedFormat(Integer.parseInt(number_of_days)));
			expectedList.add(columns.get(1));
		}
		List<List<String>> actualList = sendInvoicePage.seeInvoice(expectedList.get(0));
		boolean isInvoicePresent = false;
		for (List<String> list : actualList) {
			isInvoicePresent = list.equals(expectedList);
			if (isInvoicePresent) {
				break;
			}
		}
		assertTrue(isInvoicePresent);
	}

	@Then("Receivable balance is updated on the screen with {string}")
	public void receivable_balance_is_updated_on_the_screen_with(String amount) {
		Eventhelper.threadWait(2000);
		totalExpectedAmount = receivableBalanceOnAccountingPage + Float.parseFloat(amount); // receivableBalanceOnDashboard
		Log.info(amount);
		Log.info(receivableBalanceOnAccountingPage);
		Log.info("totalExpectedAmount after send invoice --->" + totalExpectedAmount);
		Float actualAmount = sendInvoicePage.receivableBalanceOnAccounting();
		Log.info("actual receivable Amount after send invoice --->" + actualAmount);
		// Log.info("receivableBalanceOnDashboard" + receivableBalanceOnDashboard);
		assertEquals(totalExpectedAmount, actualAmount);
		// receivableBalanceOnAccountingPage = totalExpectedAmount;
	}

	@Then("User should see updated hopscotch balance on the screen")
	public void user_should_see_updated_hopscotch_balance_on_the_screen() {
		receivableBalanceOnDashboardAfterLogin = sendInvoicePage.receivableBalanceOnAccounting();
		// receivableBalanceOnDashboard =
		// sendInvoicePage.readReceivableBalanceOnDashBoard();
		assertEquals(receivableBalanceOnAccountingPage, receivableBalanceOnDashboardAfterLogin);
	}

	@When("user enter {string} as a invoice amount")
	public void user_enter_as_a_invoice_amount(String amount) {
		sendInvoicePage.enterAmountOfInvoice(amount);
	}

	@When("User click on the menu icon of the card on {string}")
	public void user_click_on_the_menu_icon_of_the_card_on(String accountingSection) {
		sendInvoicePage.clickOnMenuButtonOfCard(accountingSection);
	}

	@When("User click on Invoice from Receivable tab")
	public void user_click_on_invoice_from_receivable_tab() {
		sendInvoicePage.clickOnSearchedCardReceivavle();
	}

	@Then("User should see the amount to be receivable")
	public void user_should_see_the_amount_to_be_receivable() {
		amountOfInvoice = sendInvoicePage.invoiceAmount("Receivable");
	}

	@Then("Receivable balance is updated on the screen")
	public void receivable_balance_is_updated_on_the_screen() {
		Eventhelper.threadWait(2000);
		totalExpectedAmount = receivableBalanceOnAccountingPage - amountOfInvoice;
		Log.info("totalExpectedAmount after send invoice --->" + totalExpectedAmount);
		Float actualAmount = sendInvoicePage.receivableBalanceOnAccounting();
		Log.info("actual receivable Amount after send invoice --->" + actualAmount);
		// Log.info("receivableBalanceOnDashboard" + receivableBalanceOnDashboard);
		assertEquals(totalExpectedAmount, actualAmount);
	}

	@Then("User should see {string} text on the card of {string}")
	public void user_should_see_text_on_the_card_of(String message, String accoutingSection) {
		assertTrue(sendInvoicePage.isMessageOnCard(message, accoutingSection));
	}

	@When("User sort the invoice with due date on {string}")
	public void user_sort_the_invoice_with_due_date_on(String accountingSection) {
		sendInvoicePage.sortWithDueDate(accountingSection);
	}

	@When("User should see the downloaded file in folder")
	public void user_should_see_the_downloaded_file_in_folder() {
		File folder = new File(System.getProperty("user.dir"));
		Eventhelper.threadWait(2000);
		// List the files on that folder
		File[] listOfFiles = folder.listFiles();
		boolean found = false;
		File downloadFile = null;
		// Look for the file in the files
		// You should write smart REGEX according to the filename
		for (File listOfFile : listOfFiles) {
			if (listOfFile.isFile()) {
				String fileName = listOfFile.getName();
				System.out.println("File " + listOfFile.getName());
				if (fileName.contains("invoice_")) {
					downloadFile = new File(fileName);
					found = true;
				}
			}
		}
		assertTrue(found, "Downloaded document is not found");
		downloadFile.deleteOnExit();
	}

	@When("User click on {string} button to mark Invoice as received")
	public void user_click_on_button_to_mark_invoice_as_received(String buttoname) {
		sendInvoicePage.clickOnConfirmButtonforMarkasInvoice(buttoname);
	}

	@Then("Receivable balance is updated on the screen once user mark invoice as received")
	public void receivable_balance_is_updated_on_the_screen_once_user_mark_invoice_as_received() {
		float expectedAmount = receivableBalanceOnAccountingPage - amountOfInvoice;
		float actualAmount = sendInvoicePage.receivableBalanceOnAccounting();
		assertEquals(expectedAmount, actualAmount, 0);
	}

	@When("User enter invoice details like amount is {int} and message is {string} for future date")
	public void user_enter_invoice_details_like_amount_is_and_message_is_for_future_date(int amount, String memo) {
		sendInvoicePage.sendInvoiceForFutureDate(amount, memo);
	}

	@When("User click on the flow button")
	public void user_click_on_the_flow_button() {
		sendInvoicePage.clickOnFlowButton();
	}

	@Then("User should read flow amount of the card")
	public void user_should_read_flow_amount_of_the_card() {
		flowedAmount = sendInvoicePage.flowedAmount();
	}

	@When("User click on Accept and Agree lable")
	public void user_click_on_accept_and_agree_lable() {
		sendInvoicePage.clickOnAcceptAndAgree();
	}

	@When("User click on get button in card")
	public void user_click_on_get_button_in_card() {
		sendInvoicePage.clickOnGetButton();
	}

	@Then("Hopscotch balance is updated on the screen")
	public void hopscotch_balance_is_updated_on_the_screen() {
		float expected =  Eventhelper.convertFloatTo2DecimalFloat(Payinvoivesteps.currentHopscotchBalance())+ flowedAmount;  
		float actual = Eventhelper.convertFloatTo2DecimalFloat(homepage.getCurrentHopscotchBalanceAmount());
		assertEquals(expected, actual, 0);
	}

	@When("User click on invoice from {string} tab")
	public void user_click_on_invoice_from_tab(String accountingSection) {
		sendInvoicePage.clickOnInvoice(accountingSection);
	}

	@Then("User should see the flowed amount is display on the screen")
	public void user_should_see_the_flowed_amount_is_display_on_the_screen() {
		float actualFlowedAmount = sendInvoicePage.flowedAmountOnCompletedInvoice();
		assertEquals(flowedAmount, actualFlowedAmount, 0);
	}

	@Then("User should see actual invoice amount on the screen")
	public void user_should_see_actual_invoice_amount_on_the_screen() {
		float amountOfOpenedInvoiceInCompleted = sendInvoicePage.invoiceAmount("Completed");
		assertEquals(amountOfInvoice, amountOfOpenedInvoiceInCompleted, 0);
	}
	
	@Then("User click on close button to close the flow dialog")
	public void user_click_on_close_button_to_close_the_flow_dialog() {
	   sendInvoicePage.clickOnCloseOfFlowDialogBox();
	}
	
	@When("User read the invoice no from the receivable")
	public void user_read_the_invoice_no_from_the_receivable() {
	   sendInvoicePage.readInvoiceNumberForCancellInvoice();
	}

	@Then("User should see the notification of cancelled invoice")
	public void user_should_see_the_notification_of_cancelled_invoice() {
	   assertTrue(sendInvoicePage.isCancelNotificationExistInNotificationList());
	}

}
