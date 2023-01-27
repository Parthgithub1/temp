Feature: Test validation on external invoice screen

  Background: 
    When User login for "externalInvoice"
    Then User should navigate to dashboard "externalInvoice"
    When User click on Pay or Get Paid link
    When User enter search for business in Searchbar

  @Regression
  Scenario Outline: Verify that user is not able to set invalid vendor name
    When User enter <vendor> as a vendor
    Then User should see <validationMessage> text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

    Examples: 
      | vendor               | validationMessage                                        |
      | "   "                | "Business name cannot contain leading or trailing space" |
      | "busi "              | "Business name cannot contain leading or trailing space" |
      | "@23232"             | "Only alphanumeric characters are accepted"  |
      | "@   ()"             | "Only alphanumeric characters are accepted"  |
      | "The[ business name" | "Only alphanumeric characters are accepted"  |
      | "The]Business"       | "Only alphanumeric characters are accepted"  |
      | "~The business name" | "Only alphanumeric characters are accepted"  |
      | "?the name"          | "Only alphanumeric characters are accepted"  |
      | "\\ the slash"       | "Only alphanumeric characters are accepted"  |
      | "= is equel"         | "Only alphanumeric characters are accepted"  |
      | "***********"        | "Only alphanumeric characters are accepted"  |
      | "~~!~!`1"            | "Only alphanumeric characters are accepted"  |

  @Regression
  Scenario Outline: Verify that user is not able to set invalid contact first name
    When User enter <firstname> as a Contact first name
    Then User should see <validationMessage> text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

    Examples: 
      | firstname        | validationMessage                                     |
      | "@   ()"         | "Only alphanumeric characters are accepted"           |
      | "[]fdgdfg"       | "Only alphanumeric characters are accepted"           |
      | "~wee"           | "Only alphanumeric characters are accepted"           |
      | "David#Nomathan" | "Only alphanumeric characters are accepted"           |
      | "%test%"         | "Only alphanumeric characters are accepted"           |
      | "first "         | "First name cannot contain leading or trailing space" |
      | " First"         | "First name cannot contain leading or trailing space" |

  @Regression
  Scenario Outline: Verify that user is not able to set invalid contact first name
    When User enter <lastname> as a Contact last name
    Then User should see <validationMessage> text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

    Examples: 
      | lastname         | validationMessage                                    |
      | "@   ()"         | "Only alphanumeric characters are accepted"          |
      | "[]fdgdfg"       | "Only alphanumeric characters are accepted"          |
      | "~wee"           | "Only alphanumeric characters are accepted"          |
      | "David#Nomathan" | "Only alphanumeric characters are accepted"          |
      | "%test%"         | "Only alphanumeric characters are accepted"          |
      | "last "          | "Last name cannot contain leading or trailing space" |
      | " last"          | "Last name cannot contain leading or trailing space" |

  @Regression
  Scenario Outline: Verify that user is not able to set invalid contact email address
    When User enter <invalidEmail> as a contact email
    Then User should see "Drop in a valid email address" text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

    Examples: 
      | invalidEmail                    |
      | "abc.123@example..com"          |
      | "abc123@@example.com"           |
      | "@example.com"                  |
      | "uset@"                         |
      | " "                             |
      | "@.com"                         |
      | "abc.def@mail#archive.com"      |
      | "abc.def@mail"                  |
      | "abcdefghijklmnopqrstu"         |
      | "ABCDEFGHIJKLMNOPQRSTU"         |
      | "0123456789"                    |
      | "Abc.example.com"               |
      | "user@[IPv6:2001:DB8::1]"       |
      | "#@%^%#$@#$@#.com"              |
      | "Joe Smith <email@example.com>" |
      | "ã�‚ã�„ã�†ã�ˆã�Š@example.com"   |

  @Regression
  Scenario: verify that user is not able to leave the contact firstname field empty
    When User press the tab button on "first name"
    Then User should see "Drop in a valid first name" text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  @Regression
  Scenario: verify that user is not able to leave the contact lastname field empty
    When User press the tab button on "last name"
    Then User should see "Drop in a valid last name" text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  @Regression
  Scenario: verify that user is not able to leave the contact email field empty
    When User press the tab button on "email"
    Then User should see "Drop in a valid email address" text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

  @Regression
  Scenario: verify that user is not able to leave the contact firstname field empty
    When User press the tab button on "businessname"
    Then User should see "Drop in a business name" text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
