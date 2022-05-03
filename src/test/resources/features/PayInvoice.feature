Feature: Test Login Functionality

  @Smoke
  Scenario: Verify Pay Invoice Successfully
    When User login with "hopsmokeautomation3@mailinator.com" and "Password1!" and click on "Log in" button
    Then User should save Default amount
    Then User should save Default amount of Payable
    Then User click on Payable Container
    Then User should see "Hopscotch Balance" text on the screen
    Then User should save the amount of Hopscotch Balance from Accounting Page
    When User enter "hopsmokeautomation2llc" in Searchbar
    When User click on Invoice from Payable tab
    Then User should see the amount to be Payable
    Then User should see "Payable Dashboard" text on the screen
    When User click on "Pay" button
    Then User should see "Payable Dashboard" text on the screen
    When User click on "Confirm" button
    Then User should save Default amount of Payable on Accounting Page
    Then User should see new amount on the screen for Payables
    Then User should see update amount of Hopscotch Balance on Accounting Page
    Then User should see invoice details of invoice details on the screen
      | hopsmokeautomation2llc | May 3rd | -$1.00 |
    Then User click on "Homepage" button to navigate to dashboard
    Then User should see "You paid an invoice to hopsmokeautomation2llc for $1.00" notification on the dashboard