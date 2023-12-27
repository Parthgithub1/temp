Feature: Test Profile Functionality

  @Smoke @Profile @QAT
  Scenario Outline: Verify Profile is being Upadted for Edit Profile
    When User login for "Profile"
    Then User should navigate to dashboard "Profile"
    When User click on Profile Drop Down  and click on "View Profile" option from Profile Drop-Down
    Then User should see <BusinessName> text on the screen
    When User click on Edit Icon beside User name
    Then User should see "Edit profile" text on the screen of Edit form
    When User enter <BusinessName> in Business Name field and <Handle> in Handle field and <Industry> from Industry drop-down and <Website> in Website field and <YearFound> in Year founded field
    Then User click on "Change logo" button
    Then User should see "Upload image" text on the screen
    Then User click on "Change picture" option
    When User click on "Continue" button from Upload image popup
    Then User should see "Your profile has been updated" text on the screen
    Then User should see updated Profile Details on the Screen like <BusinessName> , <Handle> , <Industry>, <Website>, <YearFound>
    Then User click on Edit Icon to add details for About Section
    When User enter <AboutText> in about textarea
    Then User click on "Save" button
    Then User should see "Your profile has been updated" text on the screen
    Then User should see updated Data of About <AboutText> in Profile
    When User click on Edit Icon from Banner
    Then User should see "Change banner" text on the screen
    Then User click on "Upload another photo" option
    When User click on "Continue" button
    Then User should see "Your profile has been updated" text on the screen
    Then User should see "History" text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

    Examples: 
      | BusinessName           | Handle                  | Industry     | Website                   | YearFound | AboutText                                     |
      | "qatsmokeautomation06" | "@qatsmokeautomation06" | "Accounting" | "https://dev.zurohq.com/" | "2021"    | "Text for About Section in Profile Text-Area" |

  @Smoke @Profile @UAT
  Scenario Outline: Verify Profile is being Upadted for Edit Profile
    When User login for "Profile"
    Then User should navigate to dashboard "Profile"
    When User click on Profile Drop Down  and click on "View Profile" option from Profile Drop-Down
    Then User should see <BusinessName> text on the screen
    When User click on Edit Icon beside User name
    Then User should see "Edit profile" text on the screen of Edit form
    When User enter <BusinessName> in Business Name field and <Handle> in Handle field and <Industry> from Industry drop-down and <Website> in Website field and <YearFound> in Year founded field
    Then User click on "Change logo" button
    Then User should see "Upload image" text on the screen
    Then User click on "Change picture" option
    When User click on "Continue" button from Upload image popup
    Then User should see "Your profile has been updated" text on the screen
    Then User should see updated Profile Details on the Screen like <BusinessName> , <Handle> , <Industry>, <Website>, <YearFound>
    Then User click on Edit Icon to add details for About Section
    When User enter <AboutText> in about textarea
    Then User click on "Save" button
    Then User should see "Your profile has been updated" text on the screen
    Then User should see updated Data of About <AboutText> in Profile
    When User click on Edit Icon from Banner
    Then User should see "Change banner" text on the screen
    Then User click on "Upload another photo" option
    When User click on "Continue" button
    Then User should see "Your profile has been updated" text on the screen
    Then User should see "History" text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

    Examples: 
      | BusinessName               | Handle                      | Industry     | Website                   | YearFound | AboutText                                     |
      | "hopsmokeautomation301llc" | "@hopsmokeautomation301llc" | "Accounting" | "https://dev.zurohq.com/" | "2021"    | "Text for About Section in Profile Text-Area" |

  @Regression @Profile
  Scenario Outline: Verify the user is landed on the profile page when it clicks on the business logo on the dashboard
    When User login for "Profile"
    Then User should navigate to dashboard "Profile"
    When User click on the business logo on the dashboard
    Then User should see <BusinessName> text on the screen
    Then User should see "About" text on the screen
    Then User should see "History" text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

    Examples: 
      | BusinessName           |
      | "qatsmokeautomation06" |
      
  @Regression @CrudOperationOfContactOnProfile
  Scenario: Verify that user is able to add/edit/delete contact on another users profile page 
    When User login for "InvoiceSend"
    Then User should navigate to dashboard "InvoiceSend"
    When User click on Pay or Get Paid link
    When User enter "qatsmokeautomation15" in searchbox
    Then User should see "qatsmokeautomation15" text on the screen
    When User click on "Add contact" button
    Then User should see "Add a new contact" text on the screen
    When User enter contact details for contact on the profile of another user
    When User click on "Save" button
    Then User is able to see that contact on the page 
    When User select the "Edit" option from the dropdown menu 
    Then User should see "Edit a contact" text on the screen
    When User edit the contact details of already added contact
    When User click on "Save" button
    Then User is able to see that updated contact on the page
    When User select the "Remove" option from the dropdown menu 
    Then User is not able to see that removed contact on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen