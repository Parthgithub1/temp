Feature: Send invoice feature

  @Smoke
  Scenario: verify that user is able to send an invoice to existing business into hopscotch application
    When User login with "hopsmokeautomation2@mailinator.com" and "Password1!" and click on "Log in" button
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
      | hopsmokeautomation3llc | May 3rd | +$1.00 |
    Then Receivable balance is updated on the screen with "1.00"
    Then Receivable balance is updated on dashboard
    Then User should see "You sent an invoice to hopsmokeautomation3llc for $1.00" notification on the dashboard
