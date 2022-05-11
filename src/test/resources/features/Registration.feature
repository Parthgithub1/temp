Feature: Registration feature file
  I want to use this template for my feature file

  @Smoke @uat
  Scenario: verify that user is able to register into hopscotch application
    When User click on "Register here" link
    When User enter "random" in email field
    When User click on "Continue" button
    When User enter "John" in firstname field
    When User enter "Deer" in lastname field
    When User enter "The John Dear" in businessname field
    When User enter "Test@123" in password field
    When User click on "Continue" button
    When User enter otp on registration page
    When User enter company details
    When User click on "Continue" button
    When user enter additional information
    When User click on "Submit" button
    Then User should see "Welcome to Hopscotch" text on the screen

  @Regression
  Scenario: verify that user is able to jump to login page by clicking on sign in on registration page
    When User click on "Register here" link
    When User click on "Sign in" link
    Then User should see "Welcome Back!" text on the screen

  @Regression
  Scenario: verify that registered user is not able to again register
    When User click on "Register here" link
    When User enter "testuser4@hopscotch.com" in email field
    When User click on "Continue" button
    Then User should see "This email address is already being used." text on the screen

  @Regression
  Scenario Outline: verify that user is not able to set invalid email address in  registration process
    When User click on "Register here" link
    When User enter <invalidEmail> in email field
    Then User should see <emailValidationMessage> text on the screen

    Examples: 
      | invalidEmail                    | emailValidationMessage               |
      | "abc.123@example..com"          | "Please enter a legit email address" |
      | "abc123@@example.com"           | "Please enter a legit email address" |
      | "@example.com"                  | "Please enter a legit email address" |
      | "uset@"                         | "Please enter a legit email address" |
      | " "                             | "Please enter a legit email address" |
      | "@.com"                         | "Please enter a legit email address" |
      | "abc.def@mail#archive.com"      | "Please enter a legit email address" |
      | "abc.def@mail"                  | "Please enter a legit email address" |
      | "abcdefghijklmnopqrstu"         | "Please enter a legit email address" |
      | "ABCDEFGHIJKLMNOPQRSTU"         | "Please enter a legit email address" |
      | "0123456789"                    | "Please enter a legit email address" |
      | "Abc.example.com"               | "Please enter a legit email address" |
      | "user@[IPv6:2001:DB8::1]"       | "Please enter a legit email address" |
      | "#@%^%#$@#$@#.com"              | "Please enter a legit email address" |
      | "Joe Smith <email@example.com>" | "Please enter a legit email address" |
      | "あいうえお@example.com"             | "Please enter a legit email address" |

  @Regression
  Scenario Outline: verify that user is not able to set invalid first name in registration process
    When User click on "Register here" link
    When User enter "invalidfirstname@hopscotch.com" in email field
    When User click on "Continue" button
    When User enter <firstname> in firstname field
    Then User should see "Only latin alphabet, hyphen, space, comma, period and apostrophe" text on the screen

    Examples: 
      | firstname        |
      | "@   ()"         |
      | "[]fdgdfg"       |
      | ";;;;;"          |
      | "~wee"           |
      | "David#Nomathan" |
      | "%test%"         |

  @Regression
  Scenario Outline: verify that user is not able to set invalid last name in registration process
    When User click on "Register here" link
    When User enter "invalidlastname@hopscotch.com" in email field
    When User click on "Continue" button
    When User enter <lastname> in lastname field
    Then User should see "Only latin alphabet, hyphen, space, comma, period and apostrophe" text on the screen

    Examples: 
      | lastname         |
      | "@   ()"         |
      | "[]fdgdfg"       |
      | ";;;;;"          |
      | "~wee"           |
      | "David#Nomathan" |
      | "%test%"         |

  @Regression
  Scenario Outline: verify that user is not able to set invalid business name in registration process
    When User click on "Register here" link
    When User enter "invalidbusiaddress@hopscotch.com" in email field
    When User click on "Continue" button
    When User enter <businessname> in businessname field
    Then User should see "The name can only contain letters, numbers" text on the screen

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
    When User click on "Register here" link
    When User enter "invalidbusiaddress@hopscotch.com" in email field
    When User click on "Continue" button
    When User enter <pass> in password field
    Then User should see <validationMessage> text on the screen

    Examples: 
      | pass                                        | validationMessage                                                                      |
      | "user1@automation.com"                      | "Must include an uppercase and lowercase character, a number, and a special character" |
      | "11111111"                                  | "Must include an uppercase and lowercase character, a number, and a special character" |
      | "aaaaaaaa"                                  | "Must include an uppercase and lowercase character, a number, and a special character" |
      | "AAAAAAAA"                                  | "Must include an uppercase and lowercase character, a number, and a special character" |
      | "user1111"                                  | "Must include an uppercase and lowercase character, a number, and a special character" |
      | "USER1111"                                  | "Must include an uppercase and lowercase character, a number, and a special character" |
      | "user@1111"                                 | "Must include an uppercase and lowercase character, a number, and a special character" |
      | "USER@1111"                                 | "Must include an uppercase and lowercase character, a number, and a special character" |
      | "@1111"                                     | "Must include an uppercase and lowercase character, a number, and a special character" |
      | "Test@122121212122121212212221212121212121" | "Maximum of 14 characters"                                                             |
      | "Test@12"                                   | "Minimum of 8 characters"                                                              |

  @Regression
  Scenario: verify that user is able to click on resend code during register process into hopscotch application
    When User click on "Register here" link
    When User enter "random" in email field
    When User click on "Continue" button
    When User enter "Steave" in firstname field
    When User enter "Page" in lastname field
    When User enter "The Pages" in businessname field
    When User enter "Test@123" in password field
    When User click on "Continue" button
    When User click on "Resend code" button
    Then User should see "Verification code resend successfully!" text on the screen

  @Regression
  Scenario: verify that user is not able to leave the email field empty on the during register process into hopscotch application
    When User click on "Register here" link
    When User click on the textbox of email
    When User press the tab button
    Then User should see "Drop in your email" text on the screen
