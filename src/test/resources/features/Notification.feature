Feature: Send and Pay invoice feature


  Scenario: Verify Notification case
    When User login with "hopsmokeautomation3@mailinator.com" and "Password1!" and click on "Continue" button
    Then User should navigate to dashboard of "hopsmokeautomation3@mailinator.com"
    When User click on "Notification" option from Header
    Then User should see "Notifications" text on the screen
    Then User should see "You paid an invoice to hopsmokeautomation1llc for $1.00" notification