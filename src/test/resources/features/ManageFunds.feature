Feature: Test Fund Management Functionality

  @Smoke
  Scenario: Verify User is able to Add and Withdraw Funds Successfully
    When User login with "qatsmokeautomation03@mailinator.com" and click on "Continue" button
    Then User should navigate to dashboard of "qatsmokeautomation03@mailinator.com"
    When User should save current hopscotch balance
    When User click on "Add funds" button
    Then User should see "Add funds" model open
    When User enter 2.15 in amount field to "Add" funds
    Then User should see "Add funds" model open
    When User click on "Transfer" button
    When User click on "Confirm" button
    Then User should see "Done" text on the screen
    When User click on Close Icon
    Then User should see "Hopscotch Balance" text on the screen
    Then User should see "2.15" amount on the screen
    When User should save current hopscotch balance
    When User click on "Withdraw" button
    Then User should see "Withdraw funds" model open
    When User enter 1.15 in amount field to "Withdraw" funds
    Then User should see "Withdraw funds" model open
    When User click on "Transfer" button
    When User click on "Confirm" button
    Then User should see "Done" text on the screen
    When User click on Close Icon
    Then User should see "Hopscotch Balance" text on the screen
    Then User should see "1.15" amount on the screen for withdraw
    When User click on Profile Drop Down
    Then User click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
