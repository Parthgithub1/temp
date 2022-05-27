package steps;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.*;
import pages.*;
import utility.*;


public class Contactliststep {
	Contactlistpage contactList = new Contactlistpage(Driverhelper.getDriver());
	String searchBusinessName;

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
}
