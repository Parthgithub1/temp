Feature: Test Settings Tab Functionality

  @Smoke @Setting @paymentMethodSection @QAT @UAT
  Scenario: Verify Payment methods on Settings Tab
    When User login for "Settings"
    Then User should navigate to dashboard "Settings"
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "Payment methods" link
    Then User click on "Add account" button
    When User process add "Huntington Bank" bank screen
    Then User should see "Huntington Bank" text on the screen
    When User click on menu of the "Huntington Bank" bank
    #Set as backup account
    When User click on "Set as backup" link
    Then User should see "Huntington Bank" as "Backup"
    When User switch to dashboard
    When User click on "Add funds" button
    Then User should see "Huntington Bank" text on the screen
    Then User click on "Cancel" button
    When User click on "Withdraw" button
    Then User should see "Huntington Bank" text on the screen
    Then User click on "Cancel" button
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "Payment methods" link
    When User click on menu of the "Huntington Bank" bank
    #delete bank account
    #When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    #When User click on "Payment methods" link
    #When User click on menu of the "Huntington Bank" bank
    When User click on "Delete" link
    When User click on "Delete" button
    #Then User should not see "Navy Federal Credit Union" text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  @Smoke @changePassword @Setting @QAT @UAT
  Scenario: Verify Settings Tab Account Section Change Password Functionality
    When User login for "SettingChangePassword"
    Then User should navigate to dashboard "SettingChangePassword"
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "Change password" button
    When User Change the Password
    Then User click on "Save" button
    Then User should see "Your password has been updated" text on the screen
    Then User click on "Dashboard" button to navigate to dashboard
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
    When User login with "SettingChangePassword" and Login again after change password
    Then User should navigate to dashboard "SettingChangePassword"
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "change password" button
    When User Reset Change the Password
    Then User click on "Save" button
    Then User should see "Your password has been updated" text on the screen
    Then User click on "Dashboard" button to navigate to dashboard
    Then User click on "Receivable" Container
    Then User should save the amount of Hopscotch Balance from Accounting Page
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  @Smoke @twoFactorAuthentication @Setting @QAT @doNotRunOnUAT
  Scenario: Verify Settings Tab Account Section Two factor authentication Functionality
    When User login for "2FA"
    Then User should navigate to dashboard "2FA"
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "Two factor authentication" toggle
    When User enter "8523647592" in Mobile Number field 
    Then User click on "send code" button
    When User enter Code on screen
    Then User click on "Submit" button
    Then User should see "Two-factor authentication enabled" text on the screen
    Then User click on "Dashboard" button to navigate to dashboard
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
    When User login for "2FA"
    Then User should navigate to dashboard "2FA"
    When User enter otp on screen
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "Two factor authentication" toggle
    Then User should see "We sent a security code to your device." text on the screen
    When User enter Code on screen
    Then User click on "Submit" button
    Then User should see "Two-factor authentication disabled" text on the screen
    Then User click on "Dashboard" button to navigate to dashboard
    Then User click on "Receivable" Container
    Then User click on "Dashboard" button to navigate to dashboard
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  #Settings > Change Password Section Negative Cases
  @Regression @Setting @CurrentPasswordValidation
  Scenario: Verify Settings Tab Account Section Change Password Functionality Validations Message
    When User login for "Settings"
    Then User should navigate to dashboard "Settings"
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "change password" button
    When User Edit the Password
    Then User click on "Save" button
    Then User should see "Incorrect current password" text on the screen
    Then User click on "Cancel" button
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  #Settings > Change Password Section Negative Cases
  @Regression @Setting @emptyPasswordFieldValidations
  Scenario: Verify Settings Tab Account Section Change Password Validations Message
    When User login for "Settings"
    Then User should navigate to dashboard "Settings"
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
    When User login for "Settings"
    Then User should navigate to dashboard "Settings"
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
    When User login for "Settings"
    Then User should navigate to dashboard "Settings"
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "change password" button
    When User enter "password123" in new Password field
    Then User should see "Strengthen your password with uppercase, lowercase, and special characters" text on the screen
    Then User click on "Cancel" button
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  #Settings > Change Password Section Negative Cases
  @Regression @Setting @ConfirmPasswordDoNotMatch
  Scenario: Verify Settings Tab Account Section Change Password Functionality
    When User login for "Settings"
    Then User should navigate to dashboard "Settings"
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
    When User login for "Settings"
    Then User should navigate to dashboard "Settings"
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "Two factor authentication" toggle
    When User enter "8523647592" in Mobile Number field
    When User enter Wrong Code on screen
    Then User click on "Submit" button
    Then User should see "Invalid Two-factor authentication token" text on the screen
    When User click on "Two factor authentication" toggle
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  #Settings > Already Added Bank Details Section Negative Cases
  @Regression @Setting @ValidationForAlreadyAddedBank
  Scenario: Verify Settings Tab Account Section User can not add Same Bank validation Message Functionality
    When User login for "Settings"
    Then User should navigate to dashboard "Settings"
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "Payment methods" link
    When User save the bank detail of currrently added bank
    Then User click on "Add account" button
    When User add existing bank account on Payment Method
    Then User should see "This account has already been linked" text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen 

  #Settings > Add Oauth babk on setting page 
  @Regression @Setting @AddBOAOnPaymentPage
  Scenario: Verify Settings Tab Account Section User can add Oauth Bank
    When User login for "Settings"
    Then User should navigate to dashboard "Settings"
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "Payment methods" link
    Then User click on "Add account" button
    When User add Bank of America for the pay purpose
    Then User should see "Your payment method was added" text on the screen
    When User click on menu of the "Bank of America" bank
    When User click on "Delete" link
    When User click on "Delete" button
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen 
    
  #Settings > update the branding information on the page 
  @Regression @Setting @Branding
  Scenario: Verify Settings Tab Branding Section User can update the branding information
    When User login for "Settings"
    Then User should navigate to dashboard "Settings"
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "Branding" link
    When User update the branding details on the setting page
    Then User should see the remove image option for "Icon" in the appeared dialog box 
    Then User should see the remove image option for "Logo" in the appeared dialog box 
    Then User should see "#4D2165" text on the screen
    Then User should see "#0DE6DF" text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen 