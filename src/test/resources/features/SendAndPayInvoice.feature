Feature: Test Send and Pay invoice Functionality

  @Smoke @sendandpayinvoice 
  Scenario: Verify that user is able to send and Pay invoice to existing business into hopscotch application
    When User login with "jayti.t@simformsolutions.com" and "Password1!" and click on "Continue" button
    Then User should navigate to dashboard of "jayti.t@simformsolutions.com"
    Then Read Receivable Balance on home screen
    When User click on Send Invoice link
    Then User should see "Invoice a business" text on the screen
    When User enter "TechSoft" in searchbox
    Then User should see "TechSoft" text on the screen
    When User click on "Invoice" button
    Then User should see "Invoice a business" text on the screen
    When User enter invoice details like amount is 1 and message is "This is the text of message"
    When User click on "Continue" button
    When User click on "Send Invoice" button
    Then User should see "Your invoice has been sent successfully" text on the screen
    Then Receivable balance is updated on the screen with "1.00"
    When User enter "TechSoft" in Searchbar of "Receivable"
    Then User should see the invoice on the screen
      | TechSoft | +$1.00 |
    Then Receivable balance is updated on dashboard
    When User click on "Notification" option from Header
    Then User should see "Notifications" text on the screen
    Then User should see "You sent an invoice to TechSoft for $1.00" notification
    When User click on Profile Drop Down
    Then User click on "Log Out" option from Profile Drop-Down
    When User login with "parth.p@simformsolutions.com" and "Password1!" and click on "Continue" button
    Then User should navigate to dashboard of "parth.p@simformsolutions.com"
    Then User should save Default amount
    Then User should save Default amount of Payable
    Then User click on "Payable" Container
    Then User should see "Hopscotch Balance" text on the screen
    Then User should save the amount of Hopscotch Balance from Accounting Page
    When User enter "SimformTest" in Searchbar of "Payable"
    When User click on Invoice from Payable tab
    Then User should see the amount to be Payable
    Then User should see "Payable Dashboard" text on the screen
    When User click on "Pay" button
    Then User should see "Payable Dashboard" text on the screen
    When User click on "Confirm" button
    Then User should save Default amount of Payable on Accounting Page
    Then User should see new amount on the screen for Payables
    Then User should see update amount of Hopscotch Balance on Accounting Page
    Then User should see invoice details of invoice details on the screen
      | SimformTest | -$1.00 |
    Then User click on "Homepage" button to navigate to dashboard
    When User click on "Notification" option from Header
    Then User should see "Notifications" text on the screen
    Then User should see "You paid an invoice to SimformTest for $1.00" notification
    When User click on Profile Drop Down
    Then User click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
