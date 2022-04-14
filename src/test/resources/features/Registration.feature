Feature: Registration feature file
  I want to use this template for my feature file

  @Smoke
  Scenario: verify that user is able to register into hopscotch application 
    When User click on "Register here" link
    When User enter "testuser8@hopscotch.com" in email field
    When User click on "Continue" button 
    When User enter "test user" in firstname field
    When User enter "test user" in lastname field
    When User enter "the test user" in businessname field
    When User enter "Test@123" in password field
    When User click on "Continue" button 
    When User enter otp on registration page 
    When User click on "Continue" button 
    When User click on "Submit" button 
    Then User should see "Welcome to Hopscotch" text on the screen