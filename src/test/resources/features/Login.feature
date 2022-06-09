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

  @Smoke @unverified @QAT @UAT
  Scenario: Verify unverified user is not able to perform several things
    When User login for "Unverified"
    Then User should navigate to dashboard "Unverified" 
    Then User should see "Your most recent transactions will appear here." text on the screen
    When User hover on "Add funds" 
    Then User should see "Verify your account first" text on the screen
    When User hover on "Withdraw"
    Then User should see "Verify your account first" text on the screen
    When User click on Send Invoice link
    Then User should see "Invoice a business" text on the screen
    When User enter "qatsmokeautomation05" in searchbox
    Then User should see "qatsmokeautomation05" text on the screen
    When User hover on "Invoice"
    Then User should see "Verify your account first" text on the screen
    When User click on Profile Drop Down
    Then User click on "View Profile" option from Profile Drop-Down
    When User hover on "Add Bill"
    Then User should see "Verify your account first" text on the screen 
    Then User should see "Your most recent transactions will appear here." text on the screen
    Then User should see "You have not added any info" text on the screen
    When User click on Profile Drop Down
    Then User click on "Accounting" option from Profile Drop-Down
    Then User should see "No outstanding payables" text on the screen
    When User click on Profile Drop Down
    Then User click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
