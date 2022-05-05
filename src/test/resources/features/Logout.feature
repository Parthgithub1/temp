Feature: Test Logout Functionality

  @Smoke
  Scenario: Verify Log out Successfully
    When User login with "hopsmokeautomation2@mailinator.com" and "Password1!" and click on "Log in" button
    Then User should navigate to dashboard of "hopsmokeautomation2@mailinator.com"
    When User click on Profile Drop Down
    Then User click on "Log Out" option from Profile Drop-Down
    Then User should see "Welcome Back!" text on the screen