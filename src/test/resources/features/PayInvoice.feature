Feature: Test Login Functionality

  @Smoke
  Scenario: Verify Pay Invoice Successfully
    When User login with "jayti.s@yopmail.com" and "Test@123" and click on "Log in" button
    Then User should save Default amount of Payable
    Then User click on Payable Container
    Then User should see "Hopscotch Balance" text on the screen
    #Then User should save Default amount of Payable on Accounting Page
    When User click on Invoice from Payable tab
    Then User should see the amount to be Payable
    Then User should see "Payable Dashboard" text on the screen
    When User click on "Pay" button
    Then User should see "Payable Dashboard" text on the screen
    When User click on "Confirm" button
    Then User should save Default amount of Payable on Accounting Page
    Then User should see new amount on the screen for Payables