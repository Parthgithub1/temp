Feature: Test Registration Functionality
  I want to use this template for my feature file

  @Registration
  Scenario: verify that user is able to register into hopscotch application
    When User click on "Sign up" link
    When User enter "random" in email field
    When User click on "Continue" button
    When User enter otp on screen
    When User click on "Continue" button
    When User enter "John" in firstname field
    When User enter "Deer" in lastname field
    When User enter "The John Dear" in businessname field
    When User enter "Test@123" in password field
    When User click on "Continue" button
    When User enter question details
    When User click on "Continue" button
    Then User should see "Welcome to Hopscotch" text on the screen

  @Regression
  Scenario: verify that user is able to jump to login page by clicking on sign in on registration page
    When User click on "Sign up" link
    When User click on "Sign in" link
    Then User should see "Sign in" text on the screen

  @Regression
  Scenario: verify that registered user is not able to again register
    When User click on "Sign up" link
    When User enter "qa1@mailinator.com" in email field
    When User click on "Continue" button
    Then User should see "This email address is already being used." text on the screen

  @Regression
  Scenario Outline: verify that user is not able to set invalid email address in  registration process
    When User click on "Sign up" link
    When User enter <invalidEmail> in email field
    Then User should see <emailValidationMessage> text on the screen

    Examples: 
      | invalidEmail                    | emailValidationMessage          |
      | "abc.123@example..com"          | "Drop in a valid email address" |
      | "abc123@@example.com"           | "Drop in a valid email address" |
      | "@example.com"                  | "Drop in a valid email address" |
      | "uset@"                         | "Drop in a valid email address" |
      | " "                             | "Drop in a valid email address" |
      | "@.com"                         | "Drop in a valid email address" |
      | "abc.def@mail#archive.com"      | "Drop in a valid email address" |
      | "abc.def@mail"                  | "Drop in a valid email address" |
      | "abcdefghijklmnopqrstu"         | "Drop in a valid email address" |
      | "ABCDEFGHIJKLMNOPQRSTU"         | "Drop in a valid email address" |
      | "0123456789"                    | "Drop in a valid email address" |
      | "Abc.example.com"               | "Drop in a valid email address" |
      | "user@[IPv6:2001:DB8::1]"       | "Drop in a valid email address" |
      | "#@%^%#$@#$@#.com"              | "Drop in a valid email address" |
      | "Joe Smith <email@example.com>" | "Drop in a valid email address" |
      | "ã�‚ã�„ã�†ã�ˆã�Š@example.com"   | "Drop in a valid email address" |

  @Regression
  Scenario Outline: verify that user is not able to set invalid first name in registration process
    When User click on "Sign up" link
    When User enter "invalidfirstname@hopscotch.com" in email field
    When User click on "Continue" button
    When User enter otp on screen
    When User click on "Continue" button
    When User enter <firstname> in firstname field
    Then User should see "Only alphanumeric characters are accepted" text on the screen

    Examples: 
      | firstname        |
      | "@   ()"         |
      | "[]fdgdfg"       |
      | "~wee"           |
      | "David#Nomathan" |
      | "%test%"         |

  @Regression
  Scenario Outline: verify that user is not able to set invalid last name in registration process
    When User click on "Sign up" link
    When User enter "invalidlastname@hopscotch.com" in email field
    When User click on "Continue" button
    When User enter otp on screen
    When User click on "Continue" button
    When User enter <lastname> in lastname field
    Then User should see "Only alphanumeric characters are accepted" text on the screen

    Examples: 
      | lastname         |
      | "@   ()"         |
      | "[]fdgdfg"       |
      | "~wee"           |
      | "David#Nomathan" |
      | "%test%"         |

  @Regression
  Scenario Outline: verify that user is not able to set invalid business name in registration process
    When User click on "Sign up" link
    When User enter "invalidbusiaddress@hopscotch.com" in email field
    When User click on "Continue" button
    When User enter otp on screen
    When User click on "Continue" button
    When User enter <businessname> in businessname field
    Then User should see "Only alphanumeric characters are accepted" text on the screen

    Examples: 
      | businessname         |
      | "@   ()"             |
      | "The[ business name" |
      | "The]Business"       |
      | "~The business name" |
      | "?the name"          |
      | "\\ the slash"       |
      | "= is equel"         |

  @Regression
  Scenario Outline: verify that user is not able to set invalid password registration process
    When User click on "Sign up" link
    When User enter "invalidbusiaddress@hopscotch.com" in email field
    When User click on "Continue" button
    When User enter otp on screen
    When User click on "Continue" button
    When User enter <pass> in password field
    Then User should see <validationMessage> text on the screen

    Examples: 
      | pass                                        | validationMessage                                                            |
      | "user1@automation.com"                      | "Strengthen your password with uppercase, lowercase, and special characters" |
      | "11111111"                                  | "Strengthen your password with uppercase, lowercase, and special characters" |
      | "aaaaaaaa"                                  | "Strengthen your password with uppercase, lowercase, and special characters" |
      | "AAAAAAAA"                                  | "Strengthen your password with uppercase, lowercase, and special characters" |
      | "user1111"                                  | "Strengthen your password with uppercase, lowercase, and special characters" |
      | "USER1111"                                  | "Strengthen your password with uppercase, lowercase, and special characters" |
      | "user@1111"                                 | "Strengthen your password with uppercase, lowercase, and special characters" |
      | "USER@1111"                                 | "Strengthen your password with uppercase, lowercase, and special characters" |
      | "@1111"                                     | "Strengthen your password with uppercase, lowercase, and special characters" |
      | "Test@122121212122121212212221212121212121" | "Maximum of 30 characters"                                                   |
      | "Test@12"                                   | "Minimum of 8 characters"                                                    |
      
  @Regression @PrivacyPolicy
  Scenario: verify that privacy policy tab is clickable and validate that with the content of the page
    When User click on "Privacy Policy" link
    Then User is moved to the next tab
    Then User should see "Purpose and Objectives" text on the screen
    
  @Regression @TermsofUse
  Scenario: verify that terms of use tab is clickable and validate that with the content of the page
    When User click on "Terms of Use" link
    Then User is moved to the next tab
    Then User should see "Hopscotch is a business community and payments platform" text on the screen   