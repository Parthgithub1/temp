Feature: Test Forgot Password Functionality

  @Smoke @forgotPassword @UAT @QAT
  Scenario Outline: Verify forgot Password is Successful
    When User click on <Forgot Password Link> link
    Then User should see "Reset password" text on the screen
    When User click on Back Icon from screen
    When User click on <Forgot Password Link> link
    Then User should see "Reset password" text on the screen
    When User enter <email> in email field
    When User click on "Submit" button
    Then User should see "Check your email for the security code." text on the screen
    When User click on Back Icon from screen
    Then User should see "Reset password" text on the screen
    When User enter <email> in email field
    When User click on "Submit" button
    When User click on "Resend" button
    Then User should see "Check your email for the security code." text on the screen

    Examples: 
      | Forgot Password Link  | email                                 |
      | "Reset your password" | "qatsmokeautomation03@mailinator.com" |
