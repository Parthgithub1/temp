Feature: Test Settings Tab Functionality

  @Smoke @Setting @paymentMethodSection @QAT @UAT 
  Scenario: Verify Payment methods on Settings Tab
    When User login for "paymentMethodSection"
    Then User should navigate to dashboard "paymentMethodSection"
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "Payment methods" link
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
    When User click on "Payment methods" link
    When User click on menu of the "Wells Fargo" bank
    #Set as deposite account
    When User click on "Set as Deposit account" link
    Then User should see "Wells Fargo" as "Deposit account"
    When User switch to dashboard
    When User click on "Withdraw" button
    Then User should see "Wells Fargo" text on the screen
    Then User click on "Cancel" button
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "Payment methods" link
    When User click on menu of the "Chase" bank
    When User click on "Set as Deposit account" link
    Then User should see "Chase" as "Deposit account"
    When User click on menu of the "Chase" bank
    When User click on "Set as Funding account" link
    Then User should see "Chase" as "Funding account"
    #delete bank account Chas
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "Payment methods" link
    When User click on menu of the "Wells Fargo" bank
    When User click on "Delete account" link
    When User click on "Delete" button
    Then User should not see "Wells Fargo" text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  @Smoke @changePassword @Setting @QAT @UAT
  Scenario: Verify Settings Tab Account Section Change Password Functionality
    When User login for "changePassword"
    Then User should navigate to dashboard "changePassword"
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "change password" button
    When User Change the Password
    Then User click on "Save" button
    Then User should see "Your password has been changed successfully" text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
    When User login with "changePassword" and Login again after change password
    Then User should navigate to dashboard "changePassword"
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "change password" button
    When User Reset Change the Password
    Then User click on "Save" button
    Then User should see "Your password has been changed successfully" text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  @Smoke @twoFactorAuthentication @Setting @QAT @doNotRunOnUAT
  Scenario: Verify Settings Tab Account Section Two factor authentication Functionality
    When User login for "twoFactorAuthentication"
    Then User should navigate to dashboard "twoFactorAuthentication"
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "Two factor authentication" toggle
    When User enter "8523647592" in Mobile Number field
    When User enter Code on screen
    Then User click on "Submit" button
    Then User should see "MFA Enabled" text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
    When User login for "twoFactorAuthentication"
    Then User should navigate to dashboard "twoFactorAuthentication"
    When User enter otp on screen
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "Two factor authentication" toggle
    Then User should see "Please check your registered device for the token." text on the screen
    When User enter Code on screen
    Then User click on "Submit" button
    Then User should see "MFA Disabled" text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  #Settings > Change Password Section Negative Cases
  @Regression @Setting @CurrentPasswordValidation
  Scenario: Verify Settings Tab Account Section Change Password Functionality Validations Message
    When User login for "changePassword"
    Then User should navigate to dashboard "changePassword"
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "change password" button
    When User Edit the Password
    Then User click on "Save" button
    Then User should see "Your current password does not match" text on the screen
    Then User click on "Cancel" button
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  #Settings > Change Password Section Negative Cases
  @Regression @Setting @emptyPasswordFieldValidations
  Scenario: Verify Settings Tab Account Section Change Password Validations Message
    When User login for "changePassword"
    Then User should navigate to dashboard "changePassword"
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "change password" button
    When User enter value in current Password field
    Then User should see "Drop in your password" text on the screen
    When User enter value in new Password field
    Then User should see "Drop in your new, top-secret password" text on the screen
    When User enter value in confirm Password field
    Then User should see "Please confirm your new password" text on the screen
    Then User click on "Cancel" button
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  #Settings > Change Password Section Negative Cases
  @Regression @Setting @newPasswordValidations
  Scenario: Verify Settings Tab Account Section Change Password Validations Message
    When User login for "changePassword"
    Then User should navigate to dashboard "changePassword"
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "change password" button
    When User enter "Test" in new Password field
    Then User should see "Minimum of 8 characters" text on the screen
    Then User click on "Cancel" button
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  #Settings > Change Password Section Negative Cases
  @Regression @Setting @newPasswordValidation
  Scenario: Verify Settings Tab Account Section Change Password Validations Message
    When User login for "changePassword"
    Then User should navigate to dashboard "changePassword"
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "change password" button
    When User enter "password123" in new Password field
    Then User should see "Must include an uppercase and lowercase character, a number, and a special character" text on the screen
    Then User click on "Cancel" button
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  #Settings > Change Password Section Negative Cases
  @Regression @Setting @ConfirmPasswordDoNotMatch
  Scenario: Verify Settings Tab Account Section Change Password Functionality
    When User login for "changePassword"
    Then User should navigate to dashboard "changePassword"
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "change password" button
    When User try Change the Password
    Then User should see "Something doesn’t add up (no match)" text on the screen
    Then User click on "Cancel" button
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  #Settings > twoFactorAuthentication Section Negative Cases
  @Regression @Setting @ValidationforWrongCode
  Scenario: Verify Settings Tab Account Section Two factor authentication Functionality
    When User login for "twoFactorAuthentication"
    Then User should navigate to dashboard "twoFactorAuthentication"
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "Two factor authentication" toggle
    When User enter "8523647592" in Mobile Number field
    When User enter Wrong Code on screen
    Then User click on "Submit" button
    Then User should see "The code you entered is incorrect." text on the screen
    When User click on "Two factor authentication" toggle
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  #Settings > Already Added Bank Details Section Negative Cases
  @Regression @Setting @ValidationForAlreadyAddedBank
  Scenario: Verify Settings Tab Account Section Two factor authentication Functionality
    When User login for "paymentMethodSection"
    Then User should navigate to dashboard "paymentMethodSection"
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "Payment methods" link
    When User save the bank detail of currrently added bank
    Then User click on "Add account" button
    When User add existing bank account on Payment Method
    Then User should see "You have already linked this account to Hopscotch. You cannot link the same account twice." text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
