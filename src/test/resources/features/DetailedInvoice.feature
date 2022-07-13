Feature: Test DetailedInvoice View Functionality

  @Regression @detailedInvoiceGetPaid
  Scenario: Verify that user is able to send invoice with Detailed View for Get Paid option
    When User login for "deatiledInvoice"
    Then User should navigate to dashboard "deatiledInvoice"
    Then User click on "Receivable" Container
    Then Read Receivable Balance on accounting screen
    When User click on Pay or Get Paid link
    When User enter "qatsmokeautomation11" in searchbox
    Then User should see "qatsmokeautomation11" text on the screen
    When User click on "Get paid" button
    Then User should see "Invoice details" text on the screen
    When User click on "Detailed" option for Invoice
    When User click on "Add Tax" button and enter Tax Rate 15.00
    When User enter Item Details for Invoice
    Then User should see Total Amount and subtotal amount are matched
    Then User should see amount value for Item added
    When User click on "Confirm" button
    Then User should see Tax value added in Invoice
    When User click on "Send" button
    Then User should see "Your invoice has been sent successfully" text on the screen
    Then Receivable balance is updated on the screen with "4.60"
    When User enter "qatsmokeautomation11" in Searchbar of "Receivable"
    Then User should see the invoice on the screen
      | qatsmokeautomation11 | +$4.60 |
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    Then User should see "You sent an invoice to qatsmokeautomation11 for $4.60" notification
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
    When User login for "deatiledInvoicePay"
    Then User should navigate to dashboard "deatiledInvoicePay"
    Then User click on "Payable" Container
    Then User should see "Hopscotch Balance" text on the screen
    Then User should save the amount of Hopscotch Balance from Accounting Page
    When User enter "qatsmokeautomation20" in Searchbar of "Payable"
    When User click on Invoice from Payable tab
    Then User should see the amount to be Payable
    Then User should see "Payable dashboard" text on the screen
    When User click on "View invoice" label
    Then User should see "Invoice details" text on the screen
    Then User should see the deatails added in Invoice
    When User should close the Invoice
    When User click on "Pay" button
    Then User should see "Payable dashboard" text on the screen
    When User click on "Confirm" button
    Then User should save Default amount of Payable on Accounting Page
    Then User should see new amount on the screen for Payables
    Then User should see invoice details of invoice details on the screen
      | qatsmokeautomation20 | -$4.60 |
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    Then User should see "You paid an invoice to qatsmokeautomation20 for $4.60" notification
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  @Regression @detailedInvoicePay
  Scenario: Verify that user is able to send invoice with Detailed View for Add Bill optioon
    When User login for "deatiledInvoice"
    Then User should navigate to dashboard "deatiledInvoice"
    When User click on Pay or Get Paid link
    When User enter search for business in Searchbar
    When User enter the contact deatils for AddBill
    When User click on "Add" button
    When User click on "Pay" button
    When User click on "Detailed" option for Invoice
    When User click on "Add Tax" button and enter Tax Rate 15.00
    When User enter Item Details for Invoice
    Then User should see Total Amount and subtotal amount are matched
    Then User should see amount value for Item added
    When User click on "Confirm" button
    Then User should see Tax value added in Invoice
    When User click on "Add" button
    Then User should see "Payable dashboard" text on the screen
    When User click on "View invoice" label
    Then User should see "Invoice details" text on the screen
    Then User should see the deatails added in Invoice
    When User should close the Invoice
    When User click on Close button from Payable Card
    When User should save Default amount of Payable on Accounting Page
    Then User should see notification of add bill on the dashboard
    Then User click on "Payable" Container
    Then User should see "Hopscotch Balance" text on the screen
    When User enter search in Searchbar for business
    When User click on Invoice from Payable tab
    When User should see the amount to be Payable
    Then User should see "Payable dashboard" text on the screen
    When User click on "Pay" button
    When User click on "Confirm" button
    Then User should see "It is on its way to" text on the screen
    When User should save Default amount of Payable on Accounting Page
    Then User should see updated payable amount on the screen
    Then User click on "Homepage" button to navigate to dashboard
    Then User should see notification of payment of add bill on the dashboard
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
