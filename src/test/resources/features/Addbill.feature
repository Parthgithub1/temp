Feature: Test AddBill functionality

  @Smoke @addbill @UAT @QAT
  Scenario: Verify Add bill Successfully
    When User login for "addbill"
    Then User should navigate to dashboard "addbill"
    When User click on "Payable" Container
    Then User should see "Hopscotch Balance" text on the screen
    When User should save Default amount of Payable on Accounting Page
    When User click on Pay or Get Paid link
    When User enter search for business in Searchbar
    When User enter the contact deatils for AddBill
    #When User click on "Add" button
    When User click on Pay button
    When User enter add bill details
    When User click on "Confirm" button
    When User click on "Add" button
    When User click on Close button from Payable Card
    Then User see the updated payable balance before paying invoice of add bill
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    Then User should see notification of add bill on the dashboard
    Then User click on "Home" button to navigate to dashboard
    Then User click on "Payable" Container
    Then User should see "Hopscotch Balance" text on the screen
    When User enter search in Searchbar for business
    When User click on Invoice from Payable tab
    When User should see the amount to be Payable
    Then User should see "Payable dashboard" text on the screen
    When User click on "Pay" button
    When User click on "Confirm" button
    #Then User should see "It is on its way to" text on the screen
    When User should save Default amount of Payable on Accounting Page
    Then User should see updated payable amount on the screen
    Then User click on "Home" button to navigate to dashboard
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    Then User should see notification of payment of add bill on the dashboard
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
    When User set bill receive payment in browser
    When User enter security code to verify the user on the screen
    When User click on "Confirm" button
    When user select Bank type "plaid" for the external payment
    Then User enter bank details
    When User click on Pay button in external payment
    When User click on the confirm payment button in extternal payment
    Then User should see "Transaction complete" text on the screen
    Then User is close the appeared dialog
    Then User should see "Download receipt" text on the screen
    Then User should see "This is the add bill details." text on the screen

  @Regression @deletebill
  Scenario: Verify that user is able to delete the invoice in hopscotch
    When User login for "addbill"
    Then User should navigate to dashboard "addbill"
    When User click on "Payable" Container
    Then User should see "Hopscotch Balance" text on the screen
    When User should save Default amount of Payable on Accounting Page
    When User click on Pay or Get Paid link
    When User enter search for business in Searchbar
    When User enter the contact deatils for AddBill
    #When User click on "Add" button
    When User click on Pay button
    #When User click on "Pay" button
    When User enter add bill details
    When User click on "Confirm" button
    When User click on "Add" button
    When User click on Close button from Payable Card
    Then User see the updated payable balance before paying invoice of add bill
    When User should save Default amount of Payable on Accounting Page
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    Then User should see notification of add bill on the dashboard
    Then User click on "Home" button to navigate to dashboard
    Then User click on "Payable" Container
    Then User should see "Hopscotch Balance" text on the screen
    When User enter search in Searchbar for business
    When User click on Invoice from Payable tab
    When User should see the amount to be Payable
    Then User should see "Payable dashboard" text on the screen
    When User click on the menu icon of the card on "Payable"
    When User click on "Delete" link
    When User click on "Yes, Delete" button
    When User clean the Searchbar of "Payable"
    Then Payable balance is updated on the screen once user delete invoice
    When User click on Notification option from Header
    Then User should see "Notifications" text on the screen
    And User should see delete invoice notification on the screen
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen
