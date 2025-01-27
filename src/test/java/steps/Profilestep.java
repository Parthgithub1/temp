package steps;

import static org.junit.Assert.*;

import org.junit.Assert;

import io.cucumber.java.en.*;
import pages.*;
import utility.*;

public class Profilestep {

	Profilepage profilePage = new Profilepage(Driverhelper.getDriver());
	Commonpage commonPage = new Commonpage(Driverhelper.getDriver());

	@When("User enter {string} in Business Name field and {string} in Handle field and {string} from Industry drop-down and {string} in Website field and {string} in Year founded field")
	public void user_enter_in_business_name_field_and_in_handle_field_and_from_industry_drop_down_and_in_website_field_and_in_year_founded_field(
			String businessNamne, String handleName, String industry, String webSite, String yearFound) {
		profilePage.enterdetailsofBusiness(businessNamne, handleName, industry, webSite, yearFound);
	}

	@When("User click on Profile Drop Down  and click on {string} option from Profile Drop-Down")
	public void user_click_on_profile_drop_down_and_click_on_option_from_profile_drop_down(String string) {
		commonPage.clickonDropDownofProfile();
		commonPage.clickonLinkfromProfileDropDownOption(string);
	}

	@When("User enter {string} in about textarea")
	public void user_enter_in_about_textarea(String string) {
		profilePage.enterTextforAboutinProfile(string);
	}

	@When("User click on {string} button from Upload image popup")
	public void user_click_on_button_from_upload_image_popup(String btnforUploadImage) {
		profilePage.clickOnButtonfromUploadImagePopUp(btnforUploadImage);
	}

	@When("User click on Edit Icon beside User name")
	public void user_click_on_edit_icon_beside_user_name() {
		profilePage.clickonEditIcon();
	}

	@Then("User click on Edit Icon to add details for About Section")
	public void user_click_on_edit_icon_to_add_details_for_about_section() {
		profilePage.clickonEditIconforAbout();
	}

	@Then("User should see {string} text on the screen of Edit form")
	public void user_should_see_text_on_the_screen_of_edit_form(String string) {
		boolean isTextDisplay = profilePage.isTextDisplayedofEditProfile(string);
		assertTrue(isTextDisplay);
	}

	@Then("User click on {string} option from History Section")
	public void user_click_on_option_from_history_section(String viewAllOption) {
		profilePage.clickonViewAllOption(viewAllOption);
	}

	@Then("User click on {string} option")
	public void user_click_on_option(String changePicture) {
		profilePage.clickonChangePicture();
	}

	@When("User click on Edit Icon from Banner")
	public void user_click_on_edit_icon_from_banner() {
		profilePage.clickonEditfromBanner();
	}

	@Then("User should see updated Data of About {string} in Profile")
	public void user_should_see_updated_data_of_about_in_profile(String aboutText) {
		assertTrue(profilePage.verificationofAbout(aboutText));
	}

	@Then("User should see updated Profile Details on the Screen like {string} , {string} , {string}, {string}, {string}")
	public void user_should_see_updated_profile_details_on_the_screen_like(String businessName, String handle,
			String industry, String website, String yearfound) {
		assertTrue(profilePage.isVerificationOfUpdatedProfileMatched(businessName, handle, industry, website, yearfound));
	}

	@When("User enter {string} in website field")
	public void user_enter_in_website_field(String webSite) {
		profilePage.enterWebsite(webSite);
	}

	@When("User enter {string} in year founded field")
	public void user_enter_in_year_founded_field(String yearFounded) {
		profilePage.enterYearFounded(yearFounded);
	}

	@When("User enter {string} in handle field")
	public void user_enter_in_handle_field(String handle) {
		profilePage.enterHandle(handle);
	}

	@When("User enter contact details for contact on the profile of another user")
	public void user_enter_contact_details_for_contact_on_the_profile_of_another_user() {
		profilePage.enterContactDetailsOnAnotherUsersProfile();
	}

	@Then("User is able to see that contact on the page")
	public void user_is_able_to_see_that_contact_on_the_page() {
		Assert.assertTrue(profilePage.isEmailOfAddedContactOnAnotherUsersProfilePageFound());
	}

	@When("User select the {string} option from the dropdown menu")
	public void user_select_the_option_from_the_dropdown_menu(String menuOption) {
		profilePage.clickOnMenuOfAddedContact(menuOption);
	}

	@When("User edit the contact details of already added contact")
	public void user_edit_the_contact_details_of_already_added_contact() {
	 profilePage.editTheAlreadyAddedContact();
	}
	
	@Then("User is able to see that updated contact on the page")
	public void user_is_able_to_see_that_updated_contact_on_the_page() {
	    Assert.assertTrue(profilePage.isUpdatedDetailsOfAddedContactOnAnotherUsersProfilePageDone());
	}
	
	@Then("User is not able to see that removed contact on the screen")
	public void user_is_not_able_to_see_that_removed_contact_on_the_screen() {
	    Assert.assertFalse(profilePage.isContactDeleted());
	}
}
