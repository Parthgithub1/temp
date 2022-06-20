Feature: Test validation on add bill screen

  Background: 
    When User login for "addbill"
    Then User should navigate to dashboard "addbill"
    When User click on Profile Drop Down  and click on "Accounting" option from Profile Drop-Down
    When User click on "Add Bill" link
    Then User should see "Add your bill manually" text on the screen

  @Regression
  Scenario Outline: Verify that user is not able to set invalid contact name in add bill
    When User enter vendor name in vendor
    When User enter <contactname> as a contact name
    Then User should see "Only latin alphabet, hyphen, space, comma and period" text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

    Examples: 
      | contactname     |
      | "234234234"     |
      | "LOOIOI90"      |
      | "@#@"           |
      | "PSTRL'GFFG"    |
      | "DFSDF?SDF"     |
      | "udrt_df"       |
      | "'insidequote'" |

  @Regression
  Scenario Outline: Verify that user is not able to set invalid amount in add bill
    When User enter <Amount> as a amount
    Then User should see "Please enter legit amount" text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

    Examples: 
      | Amount           |
      | "21212121221221" |
      | ".00"            |

  @Regression
  Scenario Outline: Verify that user is not able to set invalid contact email in add bill
    When User enter vendor name in vendor
    When User enter <invalidEmail> as a contact email
    Then User should see "Please enter a legit email address" text on the screen
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
  Scenario Outline: Verify that user is not able to set invalid invoice number in add bill
    When User enter <invoicenumber> as a invoice number
    Then User should see "Please enter valid invoice number" text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

    Examples: 
      | invoicenumber       |
      | "1213212313213333 " |
      | "0.112121212"       |
