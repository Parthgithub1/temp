Feature: Test Profile Functionality

  @Smoke @Profile @QAT
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

  @Smoke @Profile @UAT
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
      | BusinessName             | Handle                    | Industry     | Website                   | YearFound | AboutText                                     |
      | "hopsmokeautomation2llc" | "@hopsmokeautomation2llc" | "Accounting" | "https://dev.zurohq.com/" | "2021"    | "Text for About Section in Profile Text-Area" |
      
  @Regression
  Scenario Outline: Verify User is not able to set invalid website in Edit Profile
    When User login for "Profile"
    Then User should navigate to dashboard "Profile"
    When User click on Profile Drop Down  and click on "View Profile" option from Profile Drop-Down
    Then User should see "qatsmokeautomation06" text on the screen
    When User click on Edit Icon beside User name
    Then User should see "Edit Profile" text on the screen of Edit form
    When User enter <website> in website field
    Then User should see "Please enter a valid web address" text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

    Examples: 
      | website              |
      | "The[ business name" |
      | "The]Business"       |
      | "~The business name" |
      | "?the name"          |
      | "\\ the slash"       |
      | "= is equel"         |
      | "66565656565"        |
      | "@#$%"               |
      | "www."               |

  @Regression
  Scenario Outline: Verify User is not able to set invalid yearFounded in Edit Profile
    When User login for "Profile"
    Then User should navigate to dashboard "Profile"
    When User click on Profile Drop Down  and click on "View Profile" option from Profile Drop-Down
    Then User should see "qatsmokeautomation06" text on the screen
    When User click on Edit Icon beside User name
    Then User should see "Edit Profile" text on the screen of Edit form
    When User enter <yearFounded> in year founded field
    Then User should see "Please enter a valid year" text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

    Examples: 
      | yearFounded |
      | "0000"      |
      | "3022"      |
      | "422"       |
      | "1"         |
      | "12"        |

  @Regression
  Scenario Outline: Verify User is not able to set invalid Handle in Edit Profile
    When User login for "Profile"
    Then User should navigate to dashboard "Profile"
    When User click on Profile Drop Down  and click on "View Profile" option from Profile Drop-Down
    Then User should see "qatsmokeautomation06" text on the screen
    When User click on Edit Icon beside User name
    Then User should see "Edit Profile" text on the screen of Edit form
    When User enter <Handle> in handle field
    Then User should see "Must start with @ and contain latin alphabet, digit" text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

    Examples: 
      | Handle                    |
      | "ytyt"                    |
      | "@,,.,."                  |
      | "@dgfdd,,,"               |
      | "@Zap enterprise limited" |
      | "@@@@@@"                  |
      | "42152"                   |
