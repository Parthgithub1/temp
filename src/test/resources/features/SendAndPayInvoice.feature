Feature: Send and Pay invoice feature

  @Smoke
  Scenario: Verify that user is able to send and Pay invoice to existing business into hopscotch application
    When User login with "hopsmokeautomation1@mailinator.com" and "Password1!" and click on "Log in" button
    Then User should navigate to dashboard of "hopsmokeautomation1@mailinator.com"
    Then Read Receivable Balance on home screen
    When User click on Send Invoice link
    Then User should see "Invoice a business" text on the screen
    When User enter "hopsmokeautomation3llc" in searchbox
    Then User should see "hopsmokeautomation3llc" text on the screen
    When User click on "Invoice" button
    Then User should see "Invoice a business" text on the screen
    When User enter invoice details like amount is 1 and message is "This is the text of message"
    When User click on "Continue" button
    When User click on "Send Invoice" button
    Then User should see "Your invoice has been sent successfully" text on the screen
    Then User should see the invoice on the screen
      | hopsmokeautomation3llc | +$1.00 |
    Then Receivable balance is updated on the screen with "1.00"
    Then Receivable balance is updated on dashboard
    Then User should see "You sent an invoice to hopsmokeautomation3llc for $1.00" notification on the dashboard
    When User click on Profile Drop Down
    Then User click on "Log Out" option from Profile Drop-Down
    When User login with "hopsmokeautomation3@mailinator.com" and "Password1!" and click on "Log in" button
    Then User should navigate to dashboard of "hopsmokeautomation3@mailinator.com"
    Then User should save Default amount
    Then User should save Default amount of Payable
    Then User click on "Payable" Container
    Then User should see "Hopscotch Balance" text on the screen
    Then User should save the amount of Hopscotch Balance from Accounting Page
    When User enter "hopsmokeautomation1llc" in Searchbar
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
      | hopsmokeautomation1llc | -$1.00 |
    Then User click on "Homepage" button to navigate to dashboard
    Then User should see "You paid an invoice to hopsmokeautomation1llc for $1.00" notification on the dashboard
    When User click on Profile Drop Down
    Then User click on "Log Out" option from Profile Drop-Down
    Then User should see "Welcome Back!" text on the screen
