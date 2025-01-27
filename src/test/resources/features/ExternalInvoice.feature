Feature: Test External Invoice

  @Smoke @externalInvoice @doNotRunOnUAT @QAT
  Scenario: verify that user is able to send an external invoice to new business into hopscotch application
    When User login for "externalInvoice"
    Then User should navigate to dashboard "externalInvoice"
    Then Read businessname from the dashboard
    Then User click on "Receivable" Container
    Then Read Receivable Balance on accounting screen
    When User click on Pay or Get Paid link
    Then User is able to add a new business details
    When User enter contact details
    #When User click on "Get paid" button
    When user click on Get paid button
    When User enter invoice details like amount is 2 and message is "This is the text of message"
    When User click on "Confirm" button
    When User click on "Send" button
    Then User should see "Invoice sent" text on the screen
    When User click on Close button from receivable Card
    Then Receivable balance is updated on the screen with "2.00" 
    And Search the external invoice in receivable
    When User switch to dashboard
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    Then User should see sent external invoice notiifcation on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
    When User set external invoice url in browser
    When User enter security code to verify the user on the screen
    When User click on "Confirm" button
    Then User should see the businessname of the external invoice sender
    #When User enter otp on screen
    #When User click on "View invoice" button
    #When User click on "Add" button
    When user select "Bank transfer" as a payment method 
    When user select Bank type "plaid" for the external payment 
    Then User enter bank details
    When User click on Pay button in external invoice payment
    #When User click on "Pay" button
    #When User click on "Confirm payment" button
    When User click on the confirm payment button in extternal payment
    Then User should see "Transaction complete" text on the screen
    Then User is close the appeared dialog
    #When User click on "Sign in" button
    When User again login in environment
    When User login for "externalInvoice"
    Then User should navigate to dashboard "externalInvoice"
    Then User click on "Receivable" Container
    Then Read Receivable Balance on accounting screen
    Then User should see updated hopscotch balance on the screen
    Then User click on "Dashboard" button to navigate to dashboard
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    Then User should see the pay of external invoice notiifcation on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  @Regression @externalInvoice
  Scenario: verify that external user is not able to pay an external invoice if the sended external invoice is cancelled by hopscotch user
    When User login for "externalInvoice"
    Then User should navigate to dashboard "externalInvoice"
    Then Read businessname from the dashboard
    Then User click on "Receivable" Container
    Then Read Receivable Balance on accounting screen
    When User click on Pay or Get Paid link
    Then User is able to add a new business details
    When User enter contact details
    When user click on Get paid button
    When User enter invoice details like amount is 1 and message is "This is the text of message"
    When User click on "Confirm" button
    When User click on "Send" button
    Then User should see "Invoice sent" text on the screen
    When User click on Close button from receivable Card
    Then Receivable balance is updated on the screen with "1.00"
    And Search the external invoice in receivable
    When User read the invoice no from the receivable
    When User click on Invoice from Receivable tab
    When User click on the menu icon of the card on "Receivable"
    When User click on "Cancel" link
    When User click on "Yes, Cancel" button
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
    When User set external invoice url in browser
    Then User should see the businessname of the external invoice sender
    When User enter security code to verify the user on the screen
    When User click on "Confirm" button
    Then User is able to see "qatsmokeautomation11 canceled this invoice." in banner
    When User again login in environment
    When User login for "externalInvoice"
    Then User should navigate to dashboard "externalInvoice"
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    Then User should see the notification of cancelled external invoice in the notification
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  @Regression @externalInvoice
  Scenario: verify that external user is not able to pay an external invoice if the sended external invoice is marhed as received by hopscotch user
    When User login for "externalInvoice"
    Then User should navigate to dashboard "externalInvoice"
    Then Read businessname from the dashboard
    Then User click on "Receivable" Container
    Then Read Receivable Balance on accounting screen
    When User click on Pay or Get Paid link
    Then User is able to add a new business details
    When User enter contact details
    When user click on Get paid button
    When User enter invoice details like amount is 1 and message is "This is the text of message"
    When User click on "Confirm" button
    When User click on "Send" button
    Then User should see "Invoice sent" text on the screen
    When User click on Close button from receivable Card
    Then Receivable balance is updated on the screen with "1.00"
    And Search the external invoice in receivable
    When User click on Invoice from Receivable tab
    When User click on the menu icon of the card on "Receivable"
    When User click on "Mark received" link
    When User click on "Confirm" button to mark Invoice as received
    Then User click on "Dashboard" button to navigate to dashboard
    Then User should see "Hopscotch Balance" text on the screen
    Then User should save the amount of Hopscotch Balance from Accounting Page
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
    When User set external invoice url in browser
    Then User should see the businessname of the external invoice sender
    When User enter security code to verify the user on the screen
    When User click on "Confirm" button
    Then User should see "Transaction complete" text on the screen
    When User again login in environment
    When User login for "externalInvoice"
    Then User should navigate to dashboard "externalInvoice"
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    Then User should see the mark received notiifcation of exxternal invoice on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
    
    @Regression @externalInvoicewithManualAddedBank
  Scenario: verify that user is able to send an external invoice to new business into hopscotch application and the external user is able to pay the invoice by adding manual bank details
    When User login for "externalInvoice"
    Then User should navigate to dashboard "externalInvoice"
    Then Read businessname from the dashboard
    Then User click on "Receivable" Container
    Then Read Receivable Balance on accounting screen
    When User click on Pay or Get Paid link
    Then User is able to add a new business details
    When User enter contact details
    When user click on Get paid button
    When User enter invoice details like amount is 2 and message is "This is the text of message"
    When User click on "Confirm" button
    When User click on "Send" button
    Then User should see "Invoice sent" text on the screen
    When User click on Close button from receivable Card
    Then Receivable balance is updated on the screen with "2.00" 
    And Search the external invoice in receivable
    When User switch to dashboard
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    Then User should see sent external invoice notiifcation on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
    When User set external invoice url in browser
    When User enter security code to verify the user on the screen
    When User click on "Confirm" button
    Then User should see the businessname of the external invoice sender
    When user select "Bank transfer" as a payment method 
    When user select Bank type "Connect bank manually" for the external payment 
    Then User enter manual bank details and click on "Save and Pay" button
    When User click on the confirm payment button in extternal payment
    Then User should see "Transaction complete" text on the screen
    When User again login in environment
    When User login for "externalInvoice"
    Then User should navigate to dashboard "externalInvoice"
    Then User click on "Receivable" Container
    Then Read Receivable Balance on accounting screen
    Then User should see updated hopscotch balance on the screen
    Then User click on "Dashboard" button to navigate to dashboard
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    Then User should see the pay of external invoice notiifcation on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  @Regression @externalInvoicewithOauthBank
  Scenario: verify that user is able to send an external invoice to new business into hopscotch application
    When User login for "externalInvoice"
    Then User should navigate to dashboard "externalInvoice"
    Then Read businessname from the dashboard
    Then User click on "Receivable" Container
    Then Read Receivable Balance on accounting screen
    When User click on Pay or Get Paid link
    Then User is able to add a new business details
    When User enter contact details
    When user click on Get paid button
    When User enter invoice details like amount is 2 and message is "This is the text of message"
    When User click on "Confirm" button
    When User click on "Send" button
    Then User should see "Invoice sent" text on the screen
    When User click on Close button from receivable Card
    Then Receivable balance is updated on the screen with "2.00" 
    And Search the external invoice in receivable
    When User switch to dashboard
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    Then User should see sent external invoice notiifcation on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
    When User set external invoice url in browser
    When User enter security code to verify the user on the screen
    When User click on "Confirm" button
    Then User should see the businessname of the external invoice sender
    When user select "Bank transfer" as a payment method 
    When user select Bank type "plaid" for the external payment 
    Then User enter Bank of America details
    When User click on Pay button in external invoice payment
    When User click on the confirm payment button in extternal payment
    Then User should see "Transaction complete" text on the screen
    Then User is close the appeared dialog
    When User again login in environment
    When User login for "externalInvoice"
    Then User should navigate to dashboard "externalInvoice"
    Then User click on "Receivable" Container
    Then Read Receivable Balance on accounting screen
    Then User should see updated hopscotch balance on the screen
    Then User click on "Dashboard" button to navigate to dashboard
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    Then User should see the pay of external invoice notiifcation on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen