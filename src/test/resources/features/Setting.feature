Feature: Test Settings Tab Functionality

  @Smoke @Setting
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
    Then User should see "Wells Fargo" as "Deposit Account"
    When User switch to dashboard
    When User click on "Withdraw" button
    Then User should see "Wells Fargo" text on the screen
    Then User click on "Cancel" button
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "Payment Methods" link
    When User click on menu of the "Chase" bank
    When User click on "Set as Deposit account" link
    Then User should see "Chase" as "Deposit Account"
    When User click on menu of the "Chase" bank
    When User click on "Set as Funding account" link
    Then User should see "Chase" as "Funding account"
    #delete bank account Chas
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "Payment Methods" link
    When User click on menu of the "Wells Fargo" bank
    When User click on "Delete" link
    When User click on "Delete" button
    Then User should not see "Wells Fargo" text on the screen

  #Settings > Account Section
  @Smoke
  Scenario Outline: Verify Settings Tab Account Section Functionality
    When User login with "qatsmokeautomation07@mailinator.com" and click on "Continue" button
    Then User should navigate to dashboard of "qatsmokeautomation07@mailinator.com"
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User enter <FirstName> in firstname field
    When User enter <LastName> in lastname field
    #Then User should see updated Name Details on the Screen like <FirstName>, <LastName>
    Then User click on "Save" button
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

    Examples: 
      | FirstName | LastName   |
      | "hop"     | "testDemo" |

  @Smoke @changePassword
  Scenario: Verify Settings Tab Account Section Change Password Functionality
    When User login with "qatsmokeautomation07@mailinator.com" and click on "Continue" button
    Then User should navigate to dashboard of "qatsmokeautomation07@mailinator.com"
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "change password" button
    When User Change the Password
    Then User click on "Save" button
    Then User should see "Your password has been changed successfully" text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
    When User login with "qatsmokeautomation07@mailinator.com" and click on "Continue" button after change password
    Then User should navigate to dashboard of "qatsmokeautomation07@mailinator.com"
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "change password" button
    When User Reset Change the Password
    Then User click on "Save" button
    Then User should see "Your password has been changed successfully" text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  @Smoke @twoFactorAuthentication
  Scenario: Verify Settings Tab Account Section Two factor authentication Functionality
    When User login with "qatsmokeautomation07@mailinator.com" and click on "Continue" button
    Then User should navigate to dashboard of "qatsmokeautomation07@mailinator.com"
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "Two factor authentication" toggle
    When User enter "8523647592" in Mobile Number field
    When User enter Code on screen
    Then User click on "Submit" button
    Then User should see "MFA Enabled" text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
    When User login with "qatsmokeautomation07@mailinator.com" and click on "Continue" button
    Then User should navigate to dashboard of "qatsmokeautomation07@mailinator.com"
    When User enter otp on screen
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "Two factor authentication" toggle
    Then User should see "Please check your registered device for the token." text on the screen
    When User enter Code on screen
    Then User click on "Submit" button
    Then User should see "MFA Disabled" text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
