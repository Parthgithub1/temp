Feature: Test validation on send invoice

  @Regression
  Scenario: Verify that user is not able to set invoice amount as 0.00 on send invoice into hopscotch application
    When User login for "InvoiceSend"
    Then User should navigate to dashboard "InvoiceSend"
    When User click on Pay or Get Paid link
    When User enter "qatsmokeautomation06" in searchbox
    Then User should see "qatsmokeautomation06" text on the screen
    When User click on "Get paid" button
    When user enter "0.00" as a invoice amount
    Then User should see "Please enter a valid amount" text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  @Regression
  Scenario: Verify that user is not able to send an invoice whose amount is greater than the invoice limit on send invoice into hopscotch application
    When User login for "InvoiceSend"
    Then User should navigate to dashboard "InvoiceSend"
    When User click on Pay or Get Paid link
    When User enter "qatsmokeautomation06" in searchbox
    Then User should see "qatsmokeautomation06" text on the screen
    When User click on "Get paid" button
    When user enter "123123121232.00" as a invoice amount
    When User click on "Confirm" button
    When User click on "Send" button
    Then User should see "BusinessInvoiceLimit was exceeded." text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
    
  @Regression @AmountMatch
  Scenario: Verify that payable balance and receivable balnce should match with dashboard amount and accounting page amount
    When User login for "2FA"
    Then User should navigate to dashboard "2FA"
    When User should save current hopscotch balance
    When user should save the "Payable" balance on the dashboard
    When User click on "Payable" Container
    Then User should see "Hopscotch Balance" text on the screen
    When User should save Default amount of Payable on Accounting Page
    Then User should validate the both "Payable" amount
    Then User click on "Dashboard" button to navigate to dashboard
    When user should save the "Receivable" balance on the dashboard
    Then User click on "Receivable" Container
    Then Read Receivable Balance on accounting screen
    Then User should validate the both "Receivable" amount