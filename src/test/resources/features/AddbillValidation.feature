Feature: Test validation on add bill screen

  Background: 
    When User login for "addbill"
    Then User should navigate to dashboard "addbill"
    When User click on Pay or Get Paid link
    When User enter search for business in Searchbar
    When User enter the contact deatils for AddBill
    #When User click on "Add" button
    #When User click on "Pay" button
    When User click on Pay button

  @Regression
  Scenario Outline: Verify that user is not able to set invalid amount in add bill
    When User enter <Amount> as a amount
    Then User should see "Please enter a valid amount" text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

    Examples: 
      | Amount |
      | ".00"  |

  @Regression
  Scenario Outline: Verify that user is not able to set invalid invoice number in add bill
    When User enter <invoicenumber> as a invoice number
    Then User should see "Please enter valid invoice number" text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen

    Examples: 
      | invoicenumber      |
      | "1213212313213333" |
      | "0.112121212"      |

  @Regression
  Scenario Outline: Verify that user is not able to send invoice whose amount limit is going beyond the limit.
    When User enter other bill deatails
    When User click on "Confirm" button
    When User click on "Add" button
    Then User should see "BusinessInvoiceLimit was exceeded." text on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
