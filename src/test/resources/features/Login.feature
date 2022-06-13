Feature: Test Login Functionality

  @Login
  Scenario: Verify Login is Successful with Valid Credentials
    When User login for "Login"
    Then User should navigate to dashboard "Login"
    When User click on Profile Drop Down
    Then User click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  @Regression
  Scenario Outline: Verify Validations for Email_Password
    When User enter <email> in email field
    When User enter <password> in password field
    When User click on "Continue" button
    Then User should see <validationMessage> text on the screen

    Examples: 
      | email                                 | password     | validationMessage                                        |
      | "qatsmokeautomation01@mailinator.com" | "Password1"  | "The email and password do not match, please try again." |
      | "qatsmokeautomation01@mailinator.com" | "Password1!" | "User not found"                                         |

  @Regression
  Scenario: Verify maximum Attempts Validation Message on Login Page
    When User enter "qatsmokeautomation01@mailinator.com" in email field
    When User enter "Password11" in password field
    When User click on "Continue" button
    Then User should see validation message for maximum attempts

  @Regression
  Scenario: Verify that User click on Privacy Policy Link
    When User click on "Privacy Policy" link
    Then User should see "Privacy Policy" text on the screen

  @Regression
  Scenario: Verify that User click on Term of Use Link
    When User click on "Terms of Use" link
    Then User should see "Terms of Use" text on the screen