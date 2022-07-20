Feature: Test Verifcation Functionality

  @Smoke @Verifications @doNotRunOnUAT @QAT
  Scenario: verify that user is able to start the verification process into hopscotch application
    When User register with "random" email for "Limited Liability Company"
    Then User should see "change that" link
    When User click on "change that" link
    Then User should see "Let’s get you verified" text on the screen
    Then User click on "Continue" button
    When User click on Drop-down to select Business type and select "Limited Liability Company" from options
    Then User click on "Continue" button
    And User enter "The Automation Kim" in Legal business name field
    And User click on "Continue" button
    And user process business address screen
    And User click on "Continue" button
    Then User should see "Enter your Tax-ID number" text on the screen
    And User enters 444559999 taxNumber of Business
    When User click on "Continue" button
    And User process add beneficial owner screen
    Then User should see beneficial owner in list
    When User click on "Submit" button
    When User process add bank screen
    When User click on "Continue" button
    Then User should see Verification Message

  @Smoke @Verification @doNotRunOnUAT @QAT @Sole
  Scenario: verify that user is able to start the verification process into hopscotch application for Sole Proprietorship
    When User register with "random" email for "Sole Proprietorship"
    Then User should see "change that" link
    When User click on "change that" link
    Then User should see "Let’s get you verified" text on the screen
    Then User click on "Continue" button
    When User click on Drop-down to select Business type and select "Sole Proprietorship" from options
    Then User click on "Continue" button
    When User enter date of birth of user in Sole Proprietorship verification
    And User click on "Continue" button
    And user process business address screen
    And User click on "Continue" button
    Then User should see "Enter your Tax-ID number" text on the screen
    And User enters 444559999 taxNumber of Business
    When User click on "Submit" button
    When User process add bank screen
    When User click on "Continue" button
    Then User should see Verification Message
