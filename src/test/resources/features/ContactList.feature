Feature: Test Contact List Functionality

  @Smoke @contact
  Scenario: Verify New Contacts are added in Contact List
    When User login with "hopsmokeautomation1@mailinator.com" and "Password1!" and click on "Continue" button
    Then User should navigate to dashboard of "hopsmokeautomation1@mailinator.com"
    And User click on "Contact List" button to navigate to dashboard
    Then User should see "Contacts" text on the screen
    When User click on "Add contact" button
    Then User should see "Add Contact" text on the screen
    And User enter the Contact deatils
    When User click on "Submit" button
    Then User should see "Contacts" text on the screen
    Then User wait till pop up gets closed
    When User enter search for Name in Searchbar
    When User click on Contact from SearchList
    Then User should see the Contact Add Profile 
    Then User should see "About" text on the screen
    When User click on Back Icon from screen
    #Then User should see "Contacts" text on the screen
    When User click on Profile Drop Down
    Then User click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
