Feature: Test Contact List Functionality

  @Smoke @contact
  Scenario: Verify New Contacts are added in Contact List
    When User login for "contact" 
    Then User should navigate to dashboard of "qatsmokeautomation05@mailinator.com"
    And User click on "Contact List" button to navigate to dashboard
    Then User should see "Contacts" text on the screen
    When User click on "Add contact" button
    Then User should see "Add Contact" text on the screen
    And User enter the Contact deatils
    When User click on "Submit" button
    Then User should see "Contacts" text on the screen
    Then User wait till pop up gets closed
    # Search & Profile 
    When User enter search for Name in Searchbar
    When User click on Contact from SearchList
    Then User should see the Contact Add Profile
    When User click on Back button from screen
    # Search & Delete
    When User enter search for Name in Searchbar
    And User click on More Options button beside any Contact
    Then User click on "Delete" Option to delete Contact
    
    # Trash & Restore
    Then User click on "Trash" link
    When User enter search for Name in Searchbar
    And User click on More Options button beside any Contact
    Then User click on "Restore to Contacts" Option to Restore Contact
    
    # Back to Contact and Search Record
    Then User click on "Contacts" link
    Then User should see "Add contact" text on the screen
    When User enter search for Name in Searchbar
    And User should see Contact in List
    When User click on Profile Drop Down
    Then User click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
