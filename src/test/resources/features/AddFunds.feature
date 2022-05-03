Feature: Title of your feature
  I want to use this template for my feature file

  @Smoke
  Scenario: Verify User is able to Add Funds Successfully
    When User login with "hopsmokeautomation3@mailinator.com" and "Password1!" and click on "Log in" button
    Then User should see "Homepage" text on the screen
    Then User should save Default amount
    When User click on "Add funds" button
    Then User should see "Add funds" model open
    When User enter 1 in amount field
    When User click on "transfer" button
    When User click on "Confirm" button
    Then User should see "Add funds" model open
    Then User should see "Done" text on the screen
    When User click on Close Icon
    Then User should see "Hopscotch Balance" text on the screen
    Then User should see "1.00" amount on the screen

  @Smoke
  Scenario: Verify User is able to Withdraw Successfully
    When User login with "hopsmokeautomation3@mailinator.com" and "Password1!" and click on "Log in" button
    Then User should see "Homepage" text on the screen
    Then User should save Default amount
    When User click on "Withdraw" button
    Then User should see "Withdraw funds" model open
    When User enter 1 in amount field
    When User click on "transfer" button
    Then User should see "Withdraw funds" model open
    When User click on "Confirm" button
    Then User should see "Done" text on the screen
    Then User should see "Hopscotch Balance" text on the screen
    Then User should see "1.00" amount on the screen for withdraw