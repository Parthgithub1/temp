Feature: Test User must be able to Schedule the Invoice for Payment Functionality

  @Regression @invoiceScheduling
  Scenario: Verify that user is able to Schedule the Invoice for Payment
    When User login for "invoiceSchedulingSend"
    Then User should navigate to dashboard "invoiceSchedulingSend"
    Then User click on "Receivable" Container
    Then Read Receivable Balance on accounting screen
    When User click on Pay or Get Paid link
    When User enter "qatsmokeautomation23" in searchbox
    Then User should see "qatsmokeautomation23" text on the screen
    When User click on "Get paid" button
    Then User should see "Invoice details" text on the screen
    When User enter invoice details like amount is 2 and message is "This is invoiceScheduling Voucher"
    When User click on "Confirm" button
    When User click on "Send" button
    Then User should see "Invoice sent" text on the screen
    When User click on Close button from receivable Card
    Then Receivable balance is updated on the screen with "2.00"
    When User enter "qatsmokeautomation23" in Searchbar of "Receivable"
    Then User should see the invoice on the screen
      | qatsmokeautomation23 | +$2.00 |
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    Then User should see "You sent an invoice to qatsmokeautomation23. We'll let you know once it's been paid." notification
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
    When User login for "invoiceScheduling"
    Then User should navigate to dashboard "invoiceScheduling"
    Then User click on "Payable" Container
    Then User should see "Hopscotch Balance" text on the screen
    Then User should save the amount of Hopscotch Balance from Accounting Page
    Then User should save Default amount of Payable on Accounting Page
    When User enter "qatsmokeautomation16" in Searchbar of "Payable"
    When User click on Invoice from Payable tab
    #Then User should see "This is invoiceScheduling Voucher" text on the card of "Payable"
    Then User should see "This is invoiceScheduling Voucher" text on the screen
    Then User should see the amount to be Payable
    Then User should see "Payment Method" text on the screen
    When User click on Schedule payment Date Picker
    When User click on "Pay" button
    Then User should see "Payment Method" text on the screen
    When User click on "Confirm payment" button
    Then User should see that Payable Balance is not Updated after scheduling invoice
    When User enter "qatsmokeautomation16" in Searchbar of "Payable"
    Then User should see Scheduler Icon in Invoice
    When User click on Invoice from Payable tab
    Then User should see "Payment scheduled" text on the screen
    #Then User should see "Invoice scheduled for " text on the card of "Payable"
    When User click on Close button from Payable Card
    Then User should see "Hopscotch Balance" text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  @Regression @invoiceUnScheduling
  Scenario: Verify that user is able to UnSchedule the Invoice for Payment
    When User login for "invoiceUnScheduling"
    Then User should navigate to dashboard "invoiceUnScheduling"
    Then User click on "Receivable" Container
    Then Read Receivable Balance on accounting screen
    When User click on Pay or Get Paid link
    When User enter "qatsmokeautomation23" in searchbox
    Then User should see "qatsmokeautomation23" text on the screen
    When User click on "Get paid" button
    Then User should see "Invoice details" text on the screen
    When User enter invoice details like amount is 2 and message is "This is invoiceUnScheduling Voucher"
    When User click on "Confirm" button
    When User click on "Send" button
    Then User should see "Invoice sent" text on the screen
    When User click on Close button from receivable Card
    Then Receivable balance is updated on the screen with "2.00"
    When User enter "qatsmokeautomation23" in Searchbar of "Receivable"
    Then User should see the invoice on the screen
      | qatsmokeautomation23 | +$2.00 |
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    Then User should see "You sent an invoice to qatsmokeautomation23. We'll let you know once it's been paid." notification
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
    When User login for "invoiceScheduling"
    Then User should navigate to dashboard "invoiceScheduling"
    Then User click on "Payable" Container
    Then User should see "Hopscotch Balance" text on the screen
    Then User should save the amount of Hopscotch Balance from Accounting Page
    Then User should save Default amount of Payable on Accounting Page
    When User enter "qatsmokeautomation22" in Searchbar of "Payable"
    When User click on Invoice from Payable tab
    Then User should see "This is invoiceUnScheduling Voucher" text on the screen
    Then User should see the amount to be Payable
    Then User should see "Payment Method" text on the screen
    When User click on Schedule payment Date Picker
    When User click on "Pay" button
    Then User should see "Payment Method" text on the screen
    When User click on "Confirm payment" button
    Then User should see that Payable Balance is not Updated after scheduling invoice
    When User enter "qatsmokeautomation22" in Searchbar of "Payable"
    Then User should see Scheduler Icon in Invoice
    When User click on Invoice from Payable tab
    Then User should see "Payment scheduled" text on the screen
    When User click on Close button from Payable Card
    Then User should see "Hopscotch Balance" text on the screen
    Then User should save Default amount of Payable on Accounting Page
    When User enter "qatsmokeautomation22" in Searchbar of "Payable"
    When User click on Invoice from Payable tab
    Then User should see "This is invoiceUnScheduling Voucher" text on the screen
    Then User should see the amount to be Payable
    Then User should see "Payment Method" text on the screen
    When User click on the menu icon of the card on "Payable"
    When User click on "Unschedule" link
    Then User should see "Payment Method" text on the screen
    When User click on the menu icon of the card on "Payable"
    Then User should see that invoice is Unscheduled
    When User click on "Pay" button
    Then User should see "Payment Method" text on the screen
    When User click on "Confirm payment" button
     When User clean the Searchbar of "Payable"
     Then User should save the amount of Hopscotch Balance from Accounting Page
    Then User should save Default amount of Payable on Accounting Page
    Then User should see new amount on the screen for Payables
    #Then User should see update amount of Hopscotch Balance on Accounting Page
    Then User should see invoice details of invoice details on the screen
      | qatsmokeautomation22 | -$2.00 |
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    Then User should see "You successfully paid qatsmokeautomation22's invoice." notification
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
