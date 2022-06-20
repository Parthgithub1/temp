 Feature: Test Unverified user Functionality
 @Smoke @unverified @QAT @UAT
  Scenario: Verify unverified user is not able to perform several things
    When User login for "Unverified"
    Then User should navigate to dashboard "Unverified" 
    Then User should see "Your most recent transactions will appear here." text on the screen
    When User hover on "Add funds" 
    Then User should see "Verify your account first" text on the screen
    When User hover on "Withdraw"
    Then User should see "Verify your account first" text on the screen
    When User click on Send Invoice link
    Then User should see "Invoice a business" text on the screen
    When User enter "qatsmokeautomation05" in searchbox
    Then User should see "qatsmokeautomation05" text on the screen
    When User hover on "Invoice"
    Then User should see "Verify your account first" text on the screen
    When User click on Profile Drop Down
    Then User click on "View Profile" option from Profile Drop-Down
    When User hover on "Add Bill"
    Then User should see "Verify your account first" text on the screen 
    Then User should see "Your most recent transactions will appear here." text on the screen
    Then User should see "You have not added any info" text on the screen
    When User click on Profile Drop Down
    Then User click on "Accounting" option from Profile Drop-Down
    Then User should see "No outstanding payables" text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen