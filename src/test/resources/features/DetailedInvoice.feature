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
    When User click on "Add item" button
    When User enter Item Details for detailed Invoice
    When User remove the added row for adding item Details
    Then User should verify that added row is deleted
    Then User should see Total Amount and subtotal amount are matched
    Then User should see amount value for Item added
    When User click on "Confirm" button
    Then User should see Tax value added in Invoice
    When User click on "Send" button
    Then User should see "Invoice sent" text on the screen
     When User click on Close button from receivable Card
    Then Receivable balance is updated on the screen with "4.60"
    When User enter "qatsmokeautomation11" in Searchbar of "Receivable"
    Then User should see the invoice on the screen
      | qatsmokeautomation11 | +$4.60 |
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    Then User should see "You sent an invoice to qatsmokeautomation11. We'll let you know once it's been paid." notification
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
    When User login for "deatiledInvoicePay"
    Then User should navigate to dashboard "deatiledInvoicePay"
    Then User click on "Payable" Container
    Then User should see "Hopscotch Balance" text on the screen
    Then User should save the amount of Hopscotch Balance from Accounting Page
    When User enter "qatsmokeautomation20" in Searchbar of "Payable"
    #And User sort the invoice with due date on "Payable"
    When User click on Invoice from Payable tab
    Then User should see the amount to be Payable
    Then User should see "Payment Method" text on the screen
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
      | qatsmokeautomation20 | -$9.20 |
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    Then User should see "You paid an invoice to qatsmokeautomation20 for $9.20" notification
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  @Smoke @detailedInvoicePay @QAT @UAT
  Scenario: Verify that user is able to send invoice with Detailed View for Add Bill option
    When User login for "deatiledInvoice"
    Then User should navigate to dashboard "deatiledInvoice"
    When User click on Pay or Get Paid link
    When User enter search for business in Searchbar
    When User enter the contact deatils for AddBill
    When User click on Pay button
    #When User click on "Pay" button
    #When User click on "Pay" button
    When User click on "Detailed" option for Invoice
    #When User click on "Add Tax" button and enter Tax Rate 15.00
    When User enter Item Details for Bill
    #Then User should see Total Amount and subtotal amount are matched
    Then User should see amount value for Item added
    When User click on "Confirm" button
    #Then User should see Tax value added in Invoice
    When User click on "Add" button
    Then User should see "Payable balance" text on the screen
    When User click on "View invoice" label
    Then User should see "Invoice details" text on the screen
    Then User should see the deatails added in Invoice
    When User should close the Invoice
    When User click on Close button from Payable Card
    When User should save Default amount of Payable on Accounting Page
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    Then User should see notification of add bill on the dashboard
    Then User click on "Home" button to navigate to dashboard
    Then User click on "Payable" Container
    Then User should see "Hopscotch Balance" text on the screen
    When User enter search in Searchbar for business
    When User click on Invoice from Payable tab
    When User should see the amount to be Payable
    Then User should see "Payment Method" text on the screen
    When User click on "Pay" button
    When User click on "Confirm payment" button
    When User clean the Searchbar of "Payable"
    #Then User should see "It is on its way to" text on the screen
    When User should save Default amount of Payable on Accounting Page
    Then User should see updated payable amount on the screen
    Then User click on "Home" button to navigate to dashboard
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    Then User should see notification of payment of add bill on the dashboard
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
    When User set bill receive payment in browser
    When User enter security code to verify the user on the screen
    When User click on "Confirm" button
    When user select Bank type "plaid" for the external payment 
    Then User enter bank details
    #When User click on Pay button in external payment
    When User click on the confirm payment button in extternal payment
    Then User should see "Transaction complete" text on the screen
    Then User is close the appeared dialog
    Then User should see "Download Invoice" text on the screen
   
  @Regression @detailedInvoiceGetPaidWithDifferentDueDates @90DaysPaymentTerms
  Scenario: Verify that user is able to send invoice with Detailed View for Get Paid option for 90 days Payment Terms
    When User login for "deatiledInvoice"
    Then User should navigate to dashboard "deatiledInvoice"
    Then User click on "Receivable" Container
    Then Read Receivable Balance on accounting screen
    When User click on Pay or Get Paid link
    When User enter "qatsmokeautomation071" in searchbox
    Then User should see "qatsmokeautomation071" text on the screen
    When User click on "Get paid" button
    Then User should see "Invoice details" text on the screen
    When User click on "Detailed" option for Invoice
    When User click on "Add Tax" button and enter Tax Rate 15.00
    When User select the Date to send Invoice after 90 days
    When User click on "Add item" button
    When User enter Item Details for detailed Invoice
    When User remove the added row for adding item Details
    Then User should verify that added row is deleted
    Then User should see Total Amount and subtotal amount are matched
    Then User should see amount value for Item added
    When User click on "Confirm" button
    Then User should see the Due Date according to the Payment Term Selection of 90 days
    Then User should see Tax value added in Invoice
    When User click on "Send" button
    Then User should see "Invoice sent" text on the screen
    When User click on Close button from receivable Card
    Then Receivable balance is updated on the screen with "4.60"
    When User enter "qatsmokeautomation071" in Searchbar of "Receivable"
    Then User should see the invoice on the screen for "90" days payment term
      | qatsmokeautomation071 | +$4.60 |
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    Then User should see "You sent an invoice to qatsmokeautomation071. We'll let you know once it's been paid." notification
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  @Regression @detailedInvoiceGetPaidWithDifferentDueDates @60DaysPaymentTerms
  Scenario: Verify that user is able to send invoice with Detailed View for Get Paid option for 60 days Payment Terms
    When User login for "deatiledInvoice"
    Then User should navigate to dashboard "deatiledInvoice"
    Then User click on "Receivable" Container
    Then Read Receivable Balance on accounting screen
    When User click on Pay or Get Paid link
    When User enter "qatsmokeautomation071" in searchbox
    Then User should see "qatsmokeautomation071" text on the screen
    When User click on "Get paid" button
    Then User should see "Invoice details" text on the screen
    When User click on "Detailed" option for Invoice
    When User click on "Add Tax" button and enter Tax Rate 15.00
    When User select the Date to send Invoice after 60 days
    When User click on "Add item" button
    When User enter Item Details for detailed Invoice
    When User remove the added row for adding item Details
    Then User should verify that added row is deleted
    Then User should see Total Amount and subtotal amount are matched
    Then User should see amount value for Item added
    When User click on "Confirm" button
    Then User should see the Due Date according to the Payment Term Selection of 60 days
    Then User should see Tax value added in Invoice
    When User click on "Send" button
    Then User should see "Invoice sent" text on the screen
    When User click on Close button from receivable Card
    Then Receivable balance is updated on the screen with "4.60"
    When User enter "qatsmokeautomation071" in Searchbar of "Receivable"
    Then User should see the invoice on the screen for "60" days payment term
      | qatsmokeautomation071 | +$4.60 |
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    Then User should see "You sent an invoice to qatsmokeautomation071. We'll let you know once it's been paid." notification
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  @Regression @detailedInvoiceGetPaidWithDifferentDueDates @30DaysPaymentTerms @DI3
  Scenario: Verify that user is able to send invoice with Detailed View for Get Paid option for 30 days Payment Terms
    When User login for "deatiledInvoice"
    Then User should navigate to dashboard "deatiledInvoice"
    Then User click on "Receivable" Container
    Then Read Receivable Balance on accounting screen
    When User click on Pay or Get Paid link
    When User enter "qatsmokeautomation071" in searchbox
    Then User should see "qatsmokeautomation071" text on the screen
    When User click on "Get paid" button
    Then User should see "Invoice details" text on the screen
    When User click on "Detailed" option for Invoice
    When User click on "Add Tax" button and enter Tax Rate 15.00
    When User select the Date to send Invoice after 30 days
    When User click on "Add item" button
    When User enter Item Details for detailed Invoice
    When User remove the added row for adding item Details
    Then User should verify that added row is deleted
    Then User should see Total Amount and subtotal amount are matched
    Then User should see amount value for Item added
    When User click on "Confirm" button
    Then User should see the Due Date according to the Payment Term Selection of 30 days
    Then User should see Tax value added in Invoice
    When User click on "Send" button
    Then User should see "Invoice sent" text on the screen
    When User click on Close button from receivable Card
    Then Receivable balance is updated on the screen with "4.60"
    When User enter "qatsmokeautomation071" in Searchbar of "Receivable"
    Then User should see the invoice on the screen for "30" days payment term
      | qatsmokeautomation071 | +$4.60 |
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    Then User should see "You sent an invoice to qatsmokeautomation071. We'll let you know once it's been paid." notification
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
