Feature: Test Send and Pay invoice Functionality

  @Smoke @sendandpayinvoice @QAT
  Scenario: Verify that user is able to send invoice to existing business into hopscotch application
    When User login for "InvoiceSend"
    Then User should navigate to dashboard "InvoiceSend"
    Then User click on "Receivable" Container
    Then Read Receivable Balance on accounting screen
    When User click on Pay or Get Paid link
    When User enter "qatsmokeautomation13" in searchbox
    Then User should see "qatsmokeautomation13" text on the screen
    When User click on "Get paid" button
    Then User should see "Invoice details" text on the screen
    When User enter invoice details like amount is 2 and message is "This is the text of message"
    When User click on "Confirm" button
    When User click on "Send" button
    Then User should see "Invoice sent" text on the screen
    When User click on Close button from receivable Card
    Then Receivable balance is updated on the screen with "2.00"
    When User enter "qatsmokeautomation13" in Searchbar of "Receivable"
    Then User should see the invoice on the screen
      | qatsmokeautomation13 | +$2.00 |
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    Then User should see "You sent an invoice to qatsmokeautomation13. We'll let you know once it's been paid." notification
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
    When User login for "InvoicePay"
    Then User should navigate to dashboard "InvoicePay"
    Then User click on "Payable" Container
    Then User should see "Hopscotch Balance" text on the screen
    Then User should save the amount of Hopscotch Balance from Accounting Page
    When User enter "qatsmokeautomation14" in Searchbar of "Payable"
    When User click on Invoice from Payable tab
    Then User should see the amount to be Payable
    Then User should see "Payable dashboard" text on the screen
    When User click on "Pay" button
    Then User should see "Payable dashboard" text on the screen
    When User click on "Confirm" button
    Then User should save Default amount of Payable on Accounting Page
    Then User should see new amount on the screen for Payables
    Then User should see update amount of Hopscotch Balance on Accounting Page
    Then User should see invoice details of invoice details on the screen
      | qatsmokeautomation14 | -$2.00 |
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    Then User should see "You successfully paid qatsmokeautomation14's invoice." notification
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  @Smoke @sendandpayinvoice @UAT
  Scenario: Verify that user is able to send invoice to existing business into hopscotch application
    When User login for "InvoiceSend"
    Then User should navigate to dashboard "InvoiceSend"
    Then User click on "Receivable" Container
    Then Read Receivable Balance on accounting screen
    When User click on Pay or Get Paid link
    When User enter "hopsmokeautomation2llc" in searchbox
    Then User should see "hopsmokeautomation2llc" text on the screen
    When User click on "Get paid" button
    Then User should see "Invoice details" text on the screen
    When User enter invoice details like amount is 2 and message is "This is the text of message"
    When User click on "Confirm" button
    When User click on "Send" button
    Then User should see "Invoice sent" text on the screen
    When User click on Close button from receivable Card
    Then Receivable balance is updated on the screen with "2.00"
    When User enter "hopsmokeautomation2llc" in Searchbar of "Receivable"
    Then User should see the invoice on the screen
      | hopsmokeautomation2llc | +$2.00 |
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    Then User should see "You sent an invoice to hopsmokeautomation2llc. We'll let you know once it's been paid." notification
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
    When User login for "InvoicePay"
    Then User should navigate to dashboard "InvoicePay"
    Then User click on "Payable" Container
    Then User should see "Hopscotch Balance" text on the screen
    Then User should save the amount of Hopscotch Balance from Accounting Page
    When User enter "hopsmokeautomation1llc" in Searchbar of "Payable"
    When User click on Invoice from Payable tab
    Then User should see the amount to be Payable
    Then User should see "Payable dashboard" text on the screen
    When User click on "Pay" button
    Then User should see "Payable dashboard" text on the screen
    When User click on "Confirm" button
    Then User should save Default amount of Payable on Accounting Page
    Then User should see new amount on the screen for Payables
    Then User should see update amount of Hopscotch Balance on Accounting Page
    Then User should see invoice details of invoice details on the screen
      | hopsmokeautomation1llc | -$2.00 |
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    Then User should see "You successfully paid hopsmokeautomation1llc's invoice." notification
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  @cancelinvoice @Regression
  Scenario: Verify that user is able to cancel the invoice in hopscotch
    When User login for "cancelInvoice"
    Then User should navigate to dashboard "cancelInvoice"
    Then User click on "Receivable" Container
    Then Read Receivable Balance on accounting screen
    When User click on Pay or Get Paid link
    When User enter "qatsmokeautomation35" in searchbox
    Then User should see "qatsmokeautomation35" text on the screen
    When User click on "Get paid" button
    Then User should see "Invoice details" text on the screen
    When User enter invoice details like amount is 2 and message is "This invoice has been created to be cancelled."
    When User click on "Confirm" button
    When User click on "Send" button
    Then User should see "Invoice sent" text on the screen
    When User click on Close button from receivable Card
    Then Receivable balance is updated on the screen with "2.00"
    Then Read Receivable Balance on accounting screen
    When User enter "qatsmokeautomation35" in Searchbar of "Receivable"
    Then User should see the invoice on the screen
      | qatsmokeautomation35 | +$2.00 |
    When User read the invoice no from the receivable
    When User click on Invoice from Receivable tab
    Then User should see "This invoice has been created to be cancelled." text on the card of "Receivable"
    Then User should see the amount to be receivable
    When User click on the menu icon of the card on "Receivable"
    When User click on "Cancel" link
    When User click on "Yes, Cancel" button
    When User clean the Searchbar of "Receivable"
    Then Receivable balance is updated on the screen
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    Then User should see the notification of cancelled invoice
   #Then User should see "qatsmokeautomation15 has been cancelled." notification
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
    When User login for "cancelInvoiceNotificationCheck"
    Then User should navigate to dashboard "cancelInvoiceNotificationCheck"
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    Then User should see "qatsmokeautomation18 cancelled their invoice. You don't need to do anything from here." notification
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  @rejectinvoice @Regression
  Scenario: Verify that user is able to reject the invoice in hopscotch
    When User login for "rejectInvoice"
    Then User should navigate to dashboard "rejectInvoice"
    Then User click on "Receivable" Container
    #Then Read Receivable Balance on accounting screen
    When User click on Pay or Get Paid link
    When User enter "qatsmokeautomation16" in searchbox
    Then User should see "qatsmokeautomation16" text on the screen
    When User click on "Get paid" button
    Then User should see "Invoice details" text on the screen
    When User enter invoice details like amount is 2 and message is "This invoice has been created to be rejected."
    When User click on "Confirm" button
    When User click on "Send" button
    Then User should see "Invoice sent" text on the screen
    #Then Receivable balance is updated on the screen with "2.00"
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
    When User login for "rejectInvoiceNotificationCheck"
    Then User should navigate to dashboard "rejectInvoiceNotificationCheck"
    Then User click on "Payable" Container
    Then User should save Default amount of Payable on Accounting Page
    When User enter "qatsmokeautomation19" in Searchbar of "Payable"
    And User sort the invoice with due date on "Payable"
    #Then User should see the invoice on the screen
    #| qatsmokeautomation031 | +$1.00 |
    When User click on Invoice from Payable tab
    Then User should see "This invoice has been created to be rejected." text on the card of "Payable"
    #When User click on the menu icon of the card on "Payable"
    Then User should see the amount of the card
    When User click on the menu icon of the card on "Payable"
    When User click on "Reject" link
    When User click on "Yes, Reject" button
    Then Payable balance is updated on the screen
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    Then User should see "You rejected qatsmokeautomation19's invoice." notification
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
    When User login for "rejectInvoice"
    Then User should navigate to dashboard "rejectInvoice"
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    Then User should see "qatsmokeautomation16 rejected your invoice." notification
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  @downloadInvoice @Regression
  Scenario: Verify that user is able to Download the invoice in hopscotch
    When User login for "downloadInvoice"
    Then User should navigate to dashboard "downloadInvoice"
    Then User click on "Payable" Container
    #When User enter "qatsmokeautomation071" in Searchbar of "Payable"
    When User click on Invoice from Payable tab
    Then User should see "Payable dashboard" text on the screen
    When User click on the menu icon of the card on "Payable"
    When User click on "Download" link
    Then User should see the downloaded file in folder
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
    When User login for "twoFactorAuthentication"
    Then User should navigate to dashboard "twoFactorAuthentication"
    Then User click on "Receivable" Container
    #When User enter "qatsmokeautomation05" in Searchbar of "Receivable"
    When User click on Invoice from Receivable tab
    When User click on the menu icon of the card on "Receivable"
    When User click on "Download" link
    Then User should see the downloaded file in folder

  @markReceived @Regression
  Scenario: Verify that user is able to Mark Invoice as Received in hopscotch
    When User login for "markReceivedInvoice"
    Then User should navigate to dashboard "markReceivedInvoice"
    Then User click on "Receivable" Container
    Then Read Receivable Balance on accounting screen
    When User click on Pay or Get Paid link
    When User enter "qatsmokeautomation11" in searchbox
    Then User should see "qatsmokeautomation11" text on the screen
    When User click on "Get paid" button
    Then User should see "Invoice details" text on the screen
    When User enter invoice details like amount is 2 and message is "This is the text of message"
    When User click on "Confirm" button
    When User click on "Send" button
    Then User should see "Invoice sent" text on the screen
    When User click on Close button from receivable Card
    Then Read Receivable Balance on accounting screen
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    Then User should see "You sent an invoice to qatsmokeautomation11. We'll let you know once it's been paid." notification
    When User click on "Home" link
    Then User click on "Receivable" Container
    Then Read Receivable Balance on accounting screen
    When User enter "qatsmokeautomation11" in Searchbar of "Receivable"
    Then User should see the invoice on the screen
      | qatsmokeautomation11 | +$2.00 |
    When User click on Invoice from Receivable tab
    Then User should see the amount to be receivable
    When User click on the menu icon of the card on "Receivable"
    When User click on "Mark received" link
    When User click on "Confirm" button to mark Invoice as received
    When User clean the Searchbar of "Receivable"
    Then Receivable balance is updated on the screen once user mark invoice as received
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    Then User should see "An invoice to qatsmokeautomation11 has been marked as paid. Didn't mean to do this? You can make changes on the Accounting page." notification
    #When User click on "Homepage" link
    #Then User click on "Receivable" Container
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  @Regression @futuredayInvoice
  Scenario: Verify that user is able to send invoice to existing business into hopscotch application
    When User login for "futureDayInvoice"
    Then User should navigate to dashboard "futureDayInvoice"
    Then User click on "Receivable" Container
    Then Read Receivable Balance on accounting screen
    When User click on Pay or Get Paid link
    When User enter "qatsmokeautomation211" in searchbox
    Then User should see "qatsmokeautomation211" text on the screen
    When User click on "Get paid" button
    Then User should see "Invoice details" text on the screen
    When User enter invoice details like amount is 2 and message is "This is the text of message for future date" for future date
    When User click on "Confirm" button
    When User click on "Send" button
    Then User should see "Invoice sent" text on the screen
    When User click on Close button from receivable Card
    Then Receivable balance is updated on the screen with "2.00"
    When User enter "qatsmokeautomation211" in Searchbar of "Receivable"
    And User sort the invoice with due date on "Receivable"
    When User click on Invoice from Receivable tab
    Then User should see "This is the text of message for future date" text on the card of "Receivable"
    Then User should see "Coming up" text on the card of "Receivable"
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
    When User login for "markReceivedInvoice"
    Then User should navigate to dashboard "markReceivedInvoice"
    Then User click on "Payable" Container
    Then User should save Default amount of Payable on Accounting Page
    When User enter "qatsmokeautomation17" in Searchbar of "Payable"
    #And User sort the invoice with due date on "Payable"
    When User click on Invoice from Payable tab
    Then User should see "This is the text of message for future date" text on the card of "Payable"
    Then User should see "Coming up" text on the card of "Payable"
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  @Regression @factorInvoice
  Scenario: Verify that user is able to send factored invoice to existing business into hopscotch application
    When User login for "FactorInvoiceSend"
    Then User should navigate to dashboard "FactorInvoiceSend"
    Then User click on "Receivable" Container
    Then User should save the amount of Hopscotch Balance from Accounting Page
    Then Read Receivable Balance on accounting screen
    When User click on Pay or Get Paid link
    When User enter "TestCRSqat04" in searchbox
    Then User should see "TestCRSqat04" text on the screen
    When User click on "Get paid" button
    Then User should see "Invoice details" text on the screen
    When User enter invoice details like amount is 2 and message is "Factor invoice" for future date
    When User click on "Confirm" button
    When User click on "Send" button
    Then User should see "Invoice sent" text on the screen
    Then User click on close button to close the flow dialog
    When User click on Close button from receivable Card
    Then Receivable balance is updated on the screen with "2.00"
    Then Read Receivable Balance on accounting screen
    When User enter "TestCRSqat04" in Searchbar of "Receivable"
    And User sort the invoice with due date on "Receivable"
    When User click on Invoice from Receivable tab
    Then User should see the amount to be receivable
    When User click on the flow button
    Then User should read flow amount of the card
    When User click on get button in card
    When User click on Accept and Agree lable
    When User click on "Confirm Flow" button
    When User clean the Searchbar of "Receivable"
    Then Receivable balance is updated on the screen
    Then Hopscotch balance is updated on the screen
    When User click on "Completed" button
    When User enter "TestCRSqat04" in Searchbar of "Completed"
    And User sort the invoice with due date on "Completed"
    Then User should see the flowed amount is display on the screen
    When User click on invoice from "Completed" tab
    Then User should see actual invoice amount on the screen
    #Then User should see "Flowed" text on the card of "Completed" - alread commented
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    Then User should see "Cash is Flowing! Funds from an invoice to TestCRSqat04 have been unlocked and $1.92 has been added to your Hopscotch Balance." notification
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
    When User login for "FactorInvoicePay"
    Then User should navigate to dashboard "FactorInvoicePay"
    Then User click on "Payable" Container
    When User should save Default amount of Payable on Accounting Page
    Then User should see "Hopscotch Balance" text on the screen
    When User enter "TestCRSqat03" in Searchbar of "Payable"
    And User sort the invoice with due date on "Payable"
    When User click on Invoice from Payable tab
    Then User should see the amount of the card
    Then User should see "Payable dashboard" text on the screen
    When User click on "Pay" button
    Then User should see "Payable dashboard" text on the screen
    When User click on "Confirm" button
    When User clean the Searchbar of "Payable"
    Then Payable balance is updated on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
    When User login for "FactorInvoiceSend"
    Then User should navigate to dashboard "FactorInvoiceSend"
    Then User click on "Receivable" Container
    When User click on "Completed" button
    When User enter "TestCRSqat04" in Searchbar of "Completed"
    And User sort the invoice with due date on "Completed"
    When User click on invoice from "Completed" tab
    Then User should see "Paid by customer" text on the card of "Completed"
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    Then User should see "Flow complete! On" text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  @Regression @overDue
  Scenario: Verify that user is able to pay overdue invoice of existing business into hopscotch application
    When User login for "Overdue"
    Then User should navigate to dashboard "Overdue"
    Then User click on "Payable" Container
    Then User should see "Hopscotch Balance" text on the screen
    When User should save Default amount of Payable on Accounting Page
    When User click on Invoice from Payable tab
    Then User should see "Overdue" text on the card of "Payable"
    Then User should see the amount of the card
    Then User should see "Payable dashboard" text on the screen
    When User click on "Pay" button
    Then User should see "Payable dashboard" text on the screen
    When User click on "Confirm" button
    Then Payable balance is updated on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
