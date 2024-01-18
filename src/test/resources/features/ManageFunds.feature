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

  @Regression @checkPage
  Scenario: Verify User is able to open the all pages of the web app
    When User login for "Funds"
    Then User should navigate to dashboard "Funds"
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    And User click on "Accounting" button to navigate to dashboard
    Then User should see "Payable balance" text on the screen
    And User click on "Contacts" button to navigate to dashboard
    Then User should see "Trash" text on the screen
    When User click on Profile Drop Down  and click on "View Profile" option from Profile Drop-Down
    Then User should see "About" text on the screen
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    Then User should see "Settings" text on the screen
    And User click on "Branding" button to navigate to dashboard
    Then User should see "Customize your branding" text on the screen 
    And User click on "Payment methods" button to navigate to dashboard
    Then User should see "Your Hopscotch balance is your primary payment method." text on the screen
    And User click on "Products/Services" button to navigate to dashboard
    Then User should see "Add new Product/Service" text on the screen 
    And User click on "Subscriptions" button to navigate to dashboard
    Then User should see "Change plan" text on the screen 
    And User click on "Integrations" button to navigate to dashboard
    Then User should see "QuickBooks Online" text on the screen 
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
    