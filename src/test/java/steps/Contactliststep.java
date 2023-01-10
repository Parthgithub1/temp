package steps;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.*;
import pages.*;
import utility.*;

public class Contactliststep {
	Contactlistpage contactList = new Contactlistpage(Driverhelper.getDriver());
	Commonpage commonPage = new Commonpage(Driverhelper.getDriver());
	String businessName;

	@When("User click on Add New Contact button")
	public void user_click_on_add_new_contact_button() {
		contactList.clickOnAddNewBusinessButton();
	}

	@Then("User enter the Contact deatils")
	public void user_enter_the_contact_deatils() {
		contactList.enterContactDeatails();
	}

	@When("User click on Contact from SearchList")
	public void user_click_on_contact_from_search_list() {
		contactList.clickOnContactListSearchResult();
	}

	@When("User enter search for Name in Searchbar")
	public void user_enter_search_for_name_in_searchbar() {
		contactList.searchNameInSearchBar();
	}

	@Then("User should see the Contact Add Profile")
	public void user_should_see_the_contact_add_profile() {
		assertTrue(contactList.contactAddedVerification());
	}

	@When("User click on Back button from screen")
	public void user_click_on_back_button_from_screen() {
		contactList.clickOnBackButtonfromContactProfileScreen();
	}

	@Then("User click on More Options button beside any Contact")
	public void user_click_on_more_options_button_beside_any_contact() {
		contactList.clickOnMoreOptionBesideContactInfo();
	}

	@Then("User click on {string} Option to delete Contact")
	public void user_click_on_delete_option_to_delete_contact(String string) {
		contactList.clickOnDeleteOrRestoreContact(string);
	}

	@When("User click on {string} Option to Restore Contact")
	public void user_click_on_restore_contact_option_to_restore_contact(String string) {
		contactList.clickOnDeleteOrRestoreContact(string);
	}

	@Then("User should see Contact in List")
	public void user_should_see_notification() throws InterruptedException {
		assertTrue(contactList.seeContacts(),"Contact Not found in the constact list");
	}

	@When("User enter {string} in Business name field")
	public void user_enter_in_business_name_field(String bName) {
		contactList.enterBusinessName(bName);
	}

	@When("User enter the Contact deatils with already added email")
	public void user_enter_the_contact_deatils_with_already_added_email() {
		contactList.enterContactDeatailsForAlreadyLinkedEmail();
	}

	@Then("User should read count of contact on the dashboard")
	public void user_should_read_count_of_contact_on_the_dashboard() {
		contactList.readCountOfContactOndashboard();
	}

	@Then("User should match count of contact on contact screen with the count of dashboard")
	public void user_should_match_count_of_contact_on_contact_screen_with_the_count_of_dashboard() {
		assertTrue(contactList.isContactCountMatchOnContactListPage());
	}

	@Then("User should count the rows of contact and match with the count of dashboard's count")
	public void user_should_count_the_rows_of_contact_and_match_with_the_count_of_dashboard_s_count() {
		assertTrue(contactList.isCountOfTotalContactRowsMatched());
	}

	@When("User read the data of business column")
	public void user_read_the_data_of_business_column() {
		contactList.readBusinessNameInList();
	}

	@Then("User should see sorted business name on the contact list screen")
	public void user_should_see_sorted_business_name_on_the_contact_list_screen() {
		assertTrue(contactList.isBusinessnameSorted());
	}

	@When("User read the data of email column")
	public void user_read_the_data_of_email_column() {
		contactList.readEmail();
	}

	@Then("User should see sorted email on the contact list screen")
	public void user_should_see_sorted_email_on_the_contact_list_screen() {
		assertTrue(contactList.isEmailSorted());
	}

	@When("User read the data of contact name column")
	public void user_read_the_data_of_contact_name_column() {
		contactList.readContactName();
	}

	@Then("User should see sorted contact name on the contact list screen")
	public void user_should_see_sorted_contact_name_on_the_contact_list_screen() {
		assertTrue(contactList.isContactNmaeSorted());
	}

	@Then("User should see that add contact button is not available on trash screen")
	public void user_should_see_that_add_contact_button_is_not_available_on_trash_screen() {
		assertTrue(contactList.isAddContactButtonPresentOnTrashScreen());
	}

	@Then("User should read the count of trash contact on screen")
	public void user_should_read_the_count_of_trash_contact_on_screen() {
		contactList.countOfContactOntrash();
	}

	@Then("User should see the count of trash contact on screen is updated with {int}")
	public void user_should_see_the_count_of_trash_contact_on_screen_is_updated_with(Integer countOfDeletedContact) {
		assertTrue(contactList.isCountOfContactDeleted(countOfDeletedContact, "Trash"));
	}

	@When("user should read the count of contact on the contact screen")
	public void user_should_read_the_count_of_contact_on_the_contact_screen() {
		contactList.countOfContactOnContacListPage();
	}

	@Then("User should see the count of trash contact on screen is decreased with {int}")
	public void user_should_see_the_count_of_trash_contact_on_screen_is_decreased_with(Integer countOfDeletedContact) {
		assertTrue(contactList.isCountOfContactDeleted(countOfDeletedContact, "Contact"));
	}

	@When("User read the business name of first contact and click on business name")
	public void user_read_the_business_name_of_first_contact_and_click_on_business_name() {
		businessName = contactList.readAndClickOnBusinessName();
	}

	@Then("User should see the business name on the profile screen")
	public void user_should_see_the_business_name_on_the_profile_screen() {
		assertTrue(commonPage.isTextDisplayed(businessName));
	}

	@Then("User should see the contact list count on the screen is updated with {int}")
	public void user_should_see_the_contact_list_count_on_the_screen_is_updated_with(Integer count) {
		assertTrue(contactList.isCountMatchAfterContactRestore(count));
	}
	
	@When("User search for the business in add contact")
	public void user_search_for_the_business_in_add_contact() {
	    contactList.searchForBusinessInAddContact();
	}

}
