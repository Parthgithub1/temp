Feature: Test Forgot Password Functionality

  @Smoke
  Scenario: Verify forgot Password is Successful
    When User click on "Forgot your password?" link
    Then User should see "Reset password" text on the screen
    When User enter "hopsmokeautomation1@mailinator.com" in email field
    When User click on "Reset password" button
    Then User should see "Please check your registered email for the token." text on the screen
    Then User should see "Check your email" text on the screen
    When User click on "Change email" button
    Then User should see "Change your email" text on the screen
    When User enter "hopsmokeautomation1@mailinator.com" in email field
    When User click on "Reset password" button
    Then User should see "Please check your registered email for the token." text on the screen
    Then User should see "Check your email" text on the screen