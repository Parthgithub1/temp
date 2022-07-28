Feature: Test Contact List Functionality

  @Smoke @contact @UAT @QAT
  Scenario: Verify New Contacts are added in Contact List
    When User login for "contact"
    Then User should navigate to dashboard "contact"
    And User click on "Contact list" button to navigate to dashboard
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
    When User click on "Restore to contacts" Option to Restore Contact
    # Back to Contact and Search Record
    When User click on "Contacts" link
    Then User should see "Add contact" text on the screen
    When User enter search for Name in Searchbar
    And User should see Contact in List
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  @Regression @contact 
  Scenario: Verify Already Contact Added Validations for Contact feature
    When User login for "contact"
    Then User should navigate to dashboard "contact"
    And User click on "Contact list" button to navigate to dashboard
    Then User should see "Contacts" text on the screen
    When User click on "Add contact" button
    When User enter "qatsmokeautomation031" in Business name field
    When User click on "Add" button
    Then User should see "Contact already added" text on the screen
    When User click on "Cancel" button
    When User click on "Add contact" button
    And User enter the Contact deatils with already added email
    When User click on "Add" button
    Then User should see "Email is already associated with qatsmokeautomation031" text on the screen
    When User click on "Cancel" button
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  @Regression @contact
  Scenario: Verify contact count of dashboard with the count of contact on contact list
    When User login for "contact"
    Then User should navigate to dashboard "contact"
    Then User should read count of contact on the dashboard
    And User click on "Contact list" button to navigate to dashboard
    Then User should see "Contacts" text on the screen
    Then User should match count of contact on contact screen with the count of dashboard
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  @Regression @contact
  Scenario: Verify contact count of on contact list should match with the total rows of contacts
    When User login for "contact"
    Then User should navigate to dashboard "contact"
    Then User should read count of contact on the dashboard
    And User click on "Contact list" button to navigate to dashboard
    Then User should see "Contacts" text on the screen
    Then User should count the rows of contact and match with the count of dashboard's count
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  @Regression @contact
  Scenario: Verify Business, email and contact name are present on the contact list page
    When User login for "contact"
    Then User should navigate to dashboard "contact"
    And User click on "Contact list" button to navigate to dashboard
    Then User should see "Contacts" text on the screen
    Then User should see "Business" text on the screen
    Then User should see "Email" text on the screen
    Then User should see "Contact name" text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  @Regression @contact
  Scenario: Verify Sorting is working on business, email and conact name on contact list (Contact, Trash)
    When User login for "contact"
    Then User should navigate to dashboard "contact"
    And User click on "Contact list" button to navigate to dashboard
    Then User should see "Contacts" text on the screen
    When User read the data of business column
    When User click on "Business" button
    Then User should see sorted business name on the contact list screen
    When User click on "Email" button
    When User read the data of email column
    When User click on "Email" button
    Then User should see sorted email on the contact list screen
    When User click on "Contact name" button
    When User read the data of contact name column
    When User click on "Contact name" button
    Then User should see sorted contact name on the contact list screen
    When User click on "Trash" link
    Then User should see that add contact button is not available on trash screen
    When User read the data of business column
    When User click on "Business" button
    Then User should see sorted business name on the contact list screen
    When User click on "Email" button
    When User read the data of email column
    When User click on "Email" button
    Then User should see sorted email on the contact list screen
    When User click on "Contact name" button
    When User read the data of contact name column
    When User click on "Contact name" button
    Then User should see sorted contact name on the contact list screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  @Regression @contact
  Scenario: Verify count of contact on trash screen and contact screen updated as per deletion on contact list
    When User login for "contact"
    Then User should navigate to dashboard "contact"
    And User click on "Contact list" button to navigate to dashboard
    Then User should see "Contacts" text on the screen
    When User click on "Trash" link
    Then User should read the count of trash contact on screen
    When User click on "Contacts" link
    Then User should see "Contacts" text on the screen
    When user should read the count of contact on the contact screen
    And User click on More Options button beside any Contact
    Then User click on "Delete" Option to delete Contact
    Then User should see the count of trash contact on screen is decreased with 1
    When User click on "Trash" link
    Then User should see the count of trash contact on screen is updated with 1
    And User click on More Options button beside any Contact
    When User click on "Restore to contacts" Option to Restore Contact
    When User click on "Contacts" link
    Then User should see "Contacts" text on the screen
    Then User should see the contact list count on the screen is updated with 1
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  @Regression @contact
  Scenario: Verify that user is able to open the profile of user by tapping on the business name from contact list.
    When User login for "contact"
    Then User should navigate to dashboard "contact"
    And User click on "Contact list" button to navigate to dashboard
    Then User should see "Contacts" text on the screen
    When User read the business name of first contact and click on business name
    Then User should see the business name on the profile screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
