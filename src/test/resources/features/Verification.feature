Feature: Test Verifcation Functionality

  @Smoke @Verification @doNotRunOnUAT @QAT @Company
  Scenario: verify that user is able to start the verification process into hopscotch application
    When User register with "random" email for "Company"
    When User click on "do this later" link
    #Then User should see "here" link
    When User click on "Verify" link
    Then User should see "Let’s get you verified" text on the screen
    Then User click on "Continue" button
    When User click on Drop-down to select Business type and select "Company" from options
    Then User click on "Continue" button
    Then User should see "Legal business name" text on the screen
    And User enter "The Automation Kim" in Legal business name field
    And User click on "Continue" button
    Then User should see "Legal business address" text on the screen
    And user process business address screen
    And User click on "Continue" button
    Then User should see "Enter your Tax-ID number" text on the screen
    And User enters 121212121 taxNumber of Business
    When User click on "Continue" button
    And User process add beneficial owner screen
    Then User should see beneficial owner in list
    When User click on "Submit" button
    When User process add bank screen
    When User click on "Done" button
    #Then User should see Verification Message
    Then User should see "verified & approved to transact." text on the screen

  @Smoke @Verification @doNotRunOnUAT @QAT @Sole
  Scenario: verify that user is able to start the verification process into hopscotch application for Sole Proprietorship
    When User register with "random" email for "Sole Proprietorship"
    When User click on "Verify" link
    #Then User should see "here" link
    #When User click on "here" link
    Then User should see "Let’s get you verified" text on the screen
    Then User click on "Continue" button
    When User click on Drop-down to select Business type and select "Sole Proprietorship" from options
    Then User click on "Continue" button
    When User enter date of birth of user in Sole Proprietorship verification
    And User click on "Continue" button
    And user process business address screen
    And User click on "Continue" button
    Then User should see "Enter your SSN" text on the screen
    And User enters 121212121 taxNumber of Business
    When User click on "Submit" button
    When User process add bank screen
    When User click on "Done" button
    #Then User should see Verification Message
    Then User should see "verified & approved to transact." text on the screen

  @CreateUser
  Scenario Outline: Verify that below mentioned users are created on QAT along with verification and subscription for the Automation testing
    When user register user with email as <email> and <FirstName> as firstname and <BusinessName> as businessname
    When User click on "Verify" link
    Then User should see "Let’s get you verified" text on the screen
    Then User click on "Continue" button
    When User click on Drop-down to select Business type and select "Sole Proprietorship" from options
    Then User click on "Continue" button
    When User enter date of birth of user in Sole Proprietorship verification
    And User click on "Continue" button
    And user process business address screen
    And User click on "Continue" button
    Then User should see "Enter your SSN" text on the screen
    And User enters 121212121 taxNumber of Business
    When User click on "Submit" button
    When User process add bank screen
    When User click on "Done" button
    Then User should see "verified & approved to transact." text on the screen
    When User click on Profile Drop Down  and click on "Settings" option from Profile Drop-Down
    When User click on "Subscriptions" link
    When User click on "Change my plan" link
    Then User should see "Hopscotch Pro" text on the screen
    And User click on "Select this plan" button
    When User enter the card informatin details for the subscription
    And User click on "Continue free trial with lower fees" button
    Then User should see "You have successfully changed your plan." text on the screen
    When User click on the Annual plan selection option
    And User click on "Save Changes" button
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

    Examples: 
      | email                                  | FirstName               |  | BusinessName            |
      | "qatsmokeautomation11@mailinator.com"  | "qatsmokeautomation11"  |  | "qatsmokeautomation11"  |
      | "qatsmokeautomation06@mailinator.com"  | "qatsmokeautomation06"  |  | "qatsmokeautomation06"  |
      | "qatsmokeautomation13@mailinator.com"  | "qatsmokeautomation13"  |  | "qatsmokeautomation13"  |
      | "qatsmokeautomation14@mailinator.com"  | "qatsmokeautomation14"  |  | "qatsmokeautomation14"  |
      | "qatsmokeautomation15@mailinator.com"  | "qatsmokeautomation15"  |  | "qatsmokeautomation15"  |
      | "qatsmokeautomation16@mailinator.com"  | "qatsmokeautomation16"  |  | "qatsmokeautomation16"  |
      | "qatsmokeautomation17@mailinator.com"  | "qatsmokeautomation17"  |  | "qatsmokeautomation17"  |
      | "qatsmokeautomation18@mailinator.com"  | "qatsmokeautomation18"  |  | "qatsmokeautomation18"  |
      | "qatsmokeautomation19@mailinator.com"  | "qatsmokeautomation19"  |  | "qatsmokeautomation19"  |
      | "qatsmokeautomation20@mailinator.com"  | "qatsmokeautomation20"  |  | "qatsmokeautomation20"  |
      | "qatsmokeautomation21@mailinator.com"  | "qatsmokeautomation21"  |  | "qatsmokeautomation21"  |
      | "qatsmokeautomation23@mailinator.com"  | "qatsmokeautomation23"  |  | "qatsmokeautomation23"  |
      | "qatsmokeautomation071@mailinator.com" | "qatsmokeautomation071" |  | "qatsmokeautomation071" |
      | "qatsmokeautomation211@mailinator.com" | "qatsmokeautomation211" |  | "qatsmokeautomation211" |
      | "qatsmokeautomation35@mailinator.com"  | "qatsmokeautomation35"  |  | "qatsmokeautomation35"  |
      | "qatsmokeautomation22@mailinator.com"  | "qatsmokeautomation22"  |  | "qatsmokeautomation22"  |
