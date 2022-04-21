Feature: Test Login Functionality

  @Smoke
  Scenario: Verify Login is Successful with Valid Credentials
    When User enter "jayti.s@yopmail.com" in email field
    When User enter "Test@123" in password field
    When User click on "Log in" button
    Then User should see "Homepage" text on the screen

  @Regression
  Scenario Outline: Verify Validations for Email_Password
    When User enter <email> in email field
    When User enter <password> in password field
    When User click on "Log in" button
    Then User should see <validationMessage> text on the screen

    Examples: 
      | email                  | password   | validationMessage                                        |
      | "jayti.s@yopmail.com"  | "Test@12"  | "The email and password do not match, please try again." |
      | "jayti.s1@yopmail.com" | "Test@123" | "User not found"                                         |

  @Regression
  Scenario: Verify maximum Attempts Validation Message on Login Page
    When User enter "jayti.s@yopmail.com" in email field
    When User enter "Test@13" in password field
    When User click on "Log in" button
    Then User should see validation message for maximum attempts

  @Smoke
  Scenario: Verify that User click on Privacy Policy Link
    When User click on "Privacy Policy" link
    Then User should see "Privacy Policy" text on the screen

  @Smoke
  Scenario: Verify that User click on Term of Use Link
    When User click on "Terms of Use" link
    Then User should see "Terms of Use" text on the screen

