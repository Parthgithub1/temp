Feature: Test Unverified user Functionality

  @Smoke @unverified @QAT @UAT
  Scenario: Verify unverified user is not able to perform several things
    When User login for "Unverified"
    Then User should navigate to dashboard "Unverified"
    #When User click on "do this later" link
    When User click on Pay or Get Paid link
    When User enter "qatsmokeautomation16" in searchbox
    Then User should see "qatsmokeautomation16" text on the screen
    When User hover on "Pay"
    Then User should see "Verify your account first" text on the screen
    When User hover on "Get paid"
    Then User should see "Verify your account first" text on the screen
    When User click on Profile Drop Down
    Then User click on "View Profile" option from Profile Drop-Down
    Then User should see "qatsmokeautomation04" text on the screen
    Then User click on "Home" button to navigate to dashboard
    Then User should see "Welcome to Hopscotch" text on the screen
    When User hover on "Add funds"
    Then User should see "Verify your account first" text on the screen
    When User hover on "Withdraw"
    Then User should see "Verify your account first" text on the screen
    #Zero item text is removed form the design that why below two steps are skipped.
    #Then User click on "Accounting" button to navigate to dashboard   
    #Then User should see "0 items" text on the screen                
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
