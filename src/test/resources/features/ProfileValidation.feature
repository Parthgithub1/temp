Feature: Test Negative cases on Profile 
  
  Background: 
    When User login for "Profile"
    Then User should navigate to dashboard "Profile"
    When User click on Profile Drop Down  and click on "View Profile" option from Profile Drop-Down
    Then User should see "qatsmokeautomation06" text on the screen
    When User click on Edit Icon beside User name
    Then User should see "Edit profile" text on the screen of Edit form

  @Regression
  Scenario Outline: Verify User is not able to set invalid website in Edit Profile
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
      | "www.goog."          |

  @Regression
  Scenario Outline: Verify User is not able to set invalid yearFounded in Edit Profile
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
    When User enter <Handle> in handle field
    Then User should see <validationMessage> text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

    Examples: 
      | Handle                    | validationMessage                                     |
      | "ytyt"                    | "Must start with @ and contain latin alphabet, digit" |
      | "@,,.,."                  | "Must start with @ and contain latin alphabet, digit" |
      | "@dgfdd,,,"               | "Must start with @ and contain latin alphabet, digit" |
      | "@Zap enterprise limited" | "Must start with @ and contain latin alphabet, digit" |
      | "@@@@@@"                  | "Must start with @ and contain latin alphabet, digit" |
      | "42152"                   | "Must start with @ and contain latin alphabet, digit" |
      | "   "                     | "Drop in your handle name"                            |
