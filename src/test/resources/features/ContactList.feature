Feature: Test Contact List Functionality

  @Smoke @contact @UAT @QAT
  Scenario: Verify New Contacts are added in Contact List
    When User login for "contact" 
    Then User should navigate to dashboard "contact"
    And User click on "Contact List" button to navigate to dashboard
    Then User should see "Contacts" text on the screen
    When User click on "Add contact" button
    And User enter the Contact deatils
    When User click on "Add" button
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
    When User click on "Trash" link
    When User enter search for Name in Searchbar
    And User click on More Options button beside any Contact
    When User click on "Restore to Contacts" Option to Restore Contact
    
    # Back to Contact and Search Record
    When User click on "Contacts" link
    Then User should see "Add contact" text on the screen
    When User enter search for Name in Searchbar
    And User should see Contact in List
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
