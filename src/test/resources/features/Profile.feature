Feature: Test Profile Functionality

  @Smoke @Profile
  Scenario Outline: Verify Profile is being Upadted for Edit Profile
    When User login for "Profile"
    Then User should navigate to dashboard "Profile"
    When User click on Profile Drop Down  and click on "View Profile" option from Profile Drop-Down
    Then User should see <BusinessName> text on the screen
    When User click on Edit Icon beside User name
    Then User should see "Edit Profile" text on the screen of Edit form
    When User enter <BusinessName> in Business Name field and <Handle> in Handle field and <Industry> from Industry drop-down and <Website> in Website field and <YearFound> in Year founded field
    Then User click on "Change Logo" button
    Then User should see "Upload image" text on the screen
    Then User click on "Change Picture" option
    When User click on "Continue" button from Upload image popup
    Then User should see "Updated BusinessProfile Successfully." text on the screen
    Then User should see updated Profile Details on the Screen like <BusinessName> , <Handle> , <Industry>, <Website>, <YearFound>
    Then User click on Edit Icon to add details for About Section
    When User enter <AboutText> in about textarea
    Then User click on "Save" button
    Then User should see "Updated BusinessProfile Successfully." text on the screen
    Then User should see updated Data of About <AboutText> in Profile
    When User click on Edit Icon from Banner
    Then User should see "Change banner" text on the screen
    Then User click on "Upload Another Photo" option
    When User click on "Continue" button
    Then User should see "Updated BusinessProfile Successfully." text on the screen
    When User click on "Add Bill" link
    Then User should see "Add a bill manually" text on the screen
    Then User click on "Return" button
    Then User should see "About" text on the screen
    Then User should see "History" text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

    Examples: 
      | BusinessName           | Handle                  | Industry     | Website                   | YearFound | AboutText                                     |
      | "qatsmokeautomation06" | "@qatsmokeautomation06" | "Accounting" | "https://dev.zurohq.com/" | "2021"    | "Text for About Section in Profile Text-Area" |
