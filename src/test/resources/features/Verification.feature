Feature: Verifcation feature file

 @Regression
  Scenario: verify that user is able to start the verification process into hopscotch application
    When User login with "patel1@mailinator.com" and "Test@123" and click on "Log in" button
    And User click on "change that" link
    Then User should see "Let’s connect the dots" text on the screen

  @Smoke
  Scenario: verify that user is able to start the verification process into hopscotch application
    When User register with "random" email
    Then User should see "change that" link
    When User click on "change that" link
    And User enter "The Automation Kim" in Legal business name field
    And User click on "Continue" button
    And user process business address screen
    And User click on "Continue" button
    And User process business taxid screen
    And User click on "Continue" button
    And User process add beneficial owner screen
    Then User should see beneficial owner in list
    When User click on "Continue" button
    And User is on "dashboard" 
    Then User should see verified icon 

 @new
  Scenario: verify that user is able to start the verification process into hopscotch application
   When User register with "random" email
    Then User should see "change that" link
    When User click on "change that" link
    And User enter "The Automation Kim" in Legal business name field
    And User click on "Continue" button
    And user process business address screen
    And User click on "Continue" button
    And User process business taxid screen
    And User click on "Continue" button
    And User process add beneficial owner screen
    Then User should see beneficial owner in list
 

    