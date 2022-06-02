Feature: Test Settings Tab Functionality

  #@Smoke @Settings
  #Scenario: Verify Settings Tab Account Functionality
  #When User login with "hopsmokeautomation1@mailinator.com" and "Password1!" and click on "Continue" button
  #Then User should navigate to dashboard of "hopsmokeautomation1@mailinator.com"
  #When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
  #Then User should see "Settings" text on the screen
  #When User enter "hop" in firstname field
  #When User enter "test" in lastname field
  #When User click on "change password" button
  #When User enter "Password1!" in Current Password field
  #When User enter "Test@123" in New Password field and "Test@123" in Confirm New Password field
  #Then User click on "Cancel" button
  
  @Smoke @Settings
  Scenario: Verify Payment methods on Settings Tab
    When User login with "qatsmokeautomation06@mailinator.com" and click on "Continue" button
    Then User should navigate to dashboard of "qatsmokeautomation06@mailinator.com"
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "Payment Methods" link
    Then User click on "Add account" button
    When User process add "Wells Fargo" bank screen
    Then User should see "Wells Fargo" text on the screen
    When User click on menu of the "Wells Fargo" bank
    #Set as funding account
    When User click on "Set as Funding account" link
    Then User should see "Wells Fargo" as "Funding account" 
    When User switch to dashboard
    When User click on "Add funds" button
    Then User should see "Wells Fargo" text on the screen
    Then User click on "Cancel" button
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "Payment Methods" link
    When User click on menu of the "Wells Fargo" bank
    #Set as deposite account
    When User click on "Set as Deposit account" link
    Then User should see "Wells Fargo" as "Deposite Account" 
    When User switch to dashboard
    When User click on "Withdraw" button
    Then User should see "Wells Fargo" text on the screen
    Then User click on "Cancel" button
     #delete bank account
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "Payment Methods" link
    When User click on menu of the "Wells Fargo" bank
    When User click on "Delete" link
    When User click on "Delete" button
    Then User should not see "Wells Fargo" text on the screen
        
