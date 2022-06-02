Feature: Test Settings Tab Functionality

  @Smoke @Settings
  Scenario: Verify Settings Tab Account Functionality
    When User login with "hopsmokeautomation1@mailinator.com" and "Password1!" and click on "Continue" button
    Then User should navigate to dashboard of "hopsmokeautomation1@mailinator.com"
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    #Then User should see "Settings" text on the screen
    When User enter "hop" in firstname field
    When User enter "test" in lastname field
    When User click on "change password" button
    When User enter "Password1!" in Current Password field
    When User enter "Test@123" in New Password field and "Test@123" in Confirm New Password field
    Then User click on "Cancel" button
