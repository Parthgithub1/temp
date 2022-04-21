Feature: Verifcation feature file

  @Regression
  Scenario: verify that user is able to start the verification process into hopscotch application
    When User login with "patel1@mailinator.com" and "Test@123" and click on "Log in" button
    When User click on "change that" link
    Then User should see "Let’s connect the dots" text on the screen

  @new
  Scenario: verify that user is able to start the verification process into hopscotch application
    When User login with "mywy@mailinator.com" and "Test@123" and click on "Log in" button
    When User click on "Finish verifying" link
    When User enter "The Automation Kim" in Legal business name field
    When User click on "Continue" button
    When user process business address screen
    When User click on "Continue" button
    When User process business taxid screen
    When User click on "Continue" button
    When User process add beneficial owner screen
    Then User should see beneficial owner in list
    When User click on "Continue" button
