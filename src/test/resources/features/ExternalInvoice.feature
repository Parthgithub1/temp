Feature: Test External Invoice

  @Smoke @externalInvoice
  Scenario: verify that user is able to send an external invoice to new business into hopscotch application
    When User login for "externalInvoice"
    Then User should navigate to dashboard "externalInvoice"
    Then Read businessname from the dashboard
    Then User click on "Receivable" Container
    Then Read Receivable Balance on accounting screen
    When User click on Send Invoice link
    Then User should see "Invoice a business" text on the screen
    Then User is able to add a new business details
    When User enter customer details
    When User click on "Continue" button
    When User enter invoice details like amount is 1 and message is "This is the text of message"
    When User click on "Continue" button
    When User click on "Send Invoice" button
    Then User should see "Your invoice has been sent successfully" text on the screen
    Then Receivable balance is updated on the screen with "1.00"
    And Search the external invoice in receivable
    Then User should see sent external invoice notiifcation on the screen
    When User click on Profile Drop Down
    Then User click on "Log Out" option from Profile Drop-Down
    When User set external invoice url in browser
    Then User should see the businessname of the external invoice sender
    When User enter otp on screen
    When User click on "View invoice" button
    When User click on "Add" button
    Then User enter bank details
    When User click on "Pay" button
    When User click on "Confirm payment" button
    Then User should see "Completed" text on the screen
    Then User is close the appeared dialog
    When User click on "Sign in" button
    When User login for "externalInvoice"
    Then User should navigate to dashboard "externalInvoice"
    Then Read Receivable Balance on accounting screen
    Then User should see updated hopscotch balance on the screen
    Then User should see the pay of external invoice notiifcation on the screen
