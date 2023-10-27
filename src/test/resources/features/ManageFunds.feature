Feature: Test Fund Management Functionality

  @Smoke @Funds @UAT @QAT
  Scenario: Verify User is able to Add and Withdraw Funds Successfully
    When User login for "Funds"
    Then User should navigate to dashboard "Funds"
    When User should save current hopscotch balance
    When User click on "Add funds" button
    Then User should see "Add funds" model open
    When User enter 2.00 in amount field to "Add" funds
    Then User should see "Add funds" model open
    When User click on "Transfer" button
    When User click on "Confirm" button
    #Then User should see "Done" text on the screen
    #When User click on Close Icon
    Then User should see "Hopscotch Balance" text on the screen
    Then User should see "2.00" amount on the screen
    When User should save current hopscotch balance
    When User click on "Withdraw" button
    Then User should see "Withdraw funds" model open
    When User enter 2.00 in amount field to "Withdraw" funds
    Then User should see "Withdraw funds" model open
    When User click on "Transfer" button
    When User click on "Confirm" button
    #Then User should see "Done" text on the screen
    #When User click on Close Icon
    Then User should see "Hopscotch Balance" text on the screen
    Then User should see "2.00" amount on the screen for withdraw
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  @Regression @AddFundsDigit @Amount
  Scenario: Verify User is able to check validation message for Add Funds
    When User login for "Funds"
    Then User should navigate to dashboard "Funds"
    When User click on "Add funds" button
    Then User should see "Add funds" model open
    When User enter 00.00 in amount field to "Add" funds
    Then User should see "Please enter a valid amount" text on the screen
    When User click on "Cancel" button
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  @Regression @WithdrawFundsDigit @Amount
  Scenario: Verify User is able to check validation message for Withdraw
    When User login for "Funds"
    Then User should navigate to dashboard "Funds"
    When User click on "Withdraw" button
    Then User should see "Withdraw funds" model open
    When User enter 00.00 in amount field to "Withdraw" funds
    Then User should see "Please enter a valid amount" text on the screen
    When User should save current hopscotch balance
    When User again enters the amount to withdraw
    When User enter amount more then current balance to "Withdraw" funds
    Then User should see "Not enough funds!" text on the screen
    When User click on "Cancel" button
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  @Regression @WithdrawButtonDisabledWhenamountisZero @Amount
  Scenario: Verify User is able to see Withdraw button in disabled status when amount is Less or Equals Zero
    When User login for "Funds"
    Then User should navigate to dashboard "Funds"
    When User should save current hopscotch balance
    When User click on "Withdraw" button
    When User enter amount to "Withdraw" funds
    When User click on "Transfer" button
    When User click on "Confirm" button
    #Then User should see "Done" text on the screen
    #When User click on Close Icon
    When User should save current hopscotch balance
    Then User should see "Withdraw" button as disabled if Amount is Less then Zero
    When User should save current hopscotch balance
    When User click on "Add funds" button
    Then User should see "Add funds" model open
    When User enter 2.15 in amount field to "Add" funds
    Then User should see "Add funds" model open
    When User click on "Transfer" button
    When User click on "Confirm" button
    #Then User should see "Done" text on the screen
    #When User click on Close Icon
    Then User should see "Hopscotch Balance" text on the screen
    Then User should see "2.15" amount on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
