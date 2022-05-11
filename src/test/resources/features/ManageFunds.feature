Feature: Test Fund Management

  @dSmoke
  Scenario: Verify User is able to Add and Withdraw Funds Successfully
    When User login with "hopsmokeautomation3@mailinator.com" and "Password1!" and click on "Log in" button
    Then User should navigate to dashboard of "hopsmokeautomation3@mailinator.com"
    Then User should save Default amount
    When User click on "Add funds" button
    Then User should see "Add funds" model open
    When User enter 2 in amount field to "Add" funds
    When User click on "transfer" button
    When User click on "Confirm" button
    Then User should see "Add funds" model open
    Then User should see "Done" text on the screen
    When User click on Close Icon
    Then User should see "Hopscotch Balance" text on the screen
    Then User should see "2.00" amount on the screen
    Then User should save Default amount
    When User click on "Withdraw" button
    Then User should see "Withdraw funds" model open
    When User enter 1 in amount field to "Withdraw" funds
    When User click on "transfer" button
    Then User should see "Withdraw funds" model open
    When User click on "Confirm" button
    Then User should see "Done" text on the screen
    When User click on Close Icon
    Then User should see "Hopscotch Balance" text on the screen
    Then User should see "1.00" amount on the screen for withdraw
    When User click on Profile Drop Down
    Then User click on "Log Out" option from Profile Drop-Down
    Then User should see "Welcome Back!" text on the screen
