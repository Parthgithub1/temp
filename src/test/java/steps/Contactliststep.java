package steps;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.*;
import pages.*;
import utility.*;

public class Contactliststep {
	Contactlistpage contactList = new Contactlistpage(Driverhelper.getDriver());

	@Then("User click on Add New Contact button")
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

	@Then("User click on {string} Option to Restore Contact")
	public void user_click_on_restore_contact_option_to_restore_contact(String string) {
		contactList.clickOnDeleteOrRestoreContact(string);
	}
	
	
	@Then("User should see Contact in List")
	public void user_should_see_notification() throws InterruptedException {
		assertTrue(contactList.seeContacts());
	}
}
