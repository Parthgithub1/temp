Feature: Test AddBill functionality

  @Smoke @addbill @UAT @QAT 
  Scenario: Verify Add bill Successfully
    When User login for "addbill"
    Then User should navigate to dashboard "addbill"
    #Then User should save Default amount of Payable
    When User click on "Payable" Container
    Then User should see "Hopscotch Balance" text on the screen
    When User should save Default amount of Payable on Accounting Page
    When User click on "Add Bill" link
    When User enter add bill details
    When User click on "Add Bill" button
    When User click on Close button from Payable Card
    Then User see the updated payable balance before paying invoice of add bill
    #Then User should see notification of add bill on the dashboard
    #Then User click on "Payable" Container
    When User enter search for business in Searchbar
    When User click on Invoice from Payable tab
    When User should see the amount to be Payable
    Then User should see "Payable Dashboard" text on the screen
    When User click on "Pay" button
    When User click on "Confirm" button
    Then User should see "It is on its way to" text on the screen
    When User should save Default amount of Payable on Accounting Page
    Then User should see updated payable amount on the screen
    Then User should see notification of payment of add bill on the dashboard
    When User click on Profile Drop Down  and click on "Log Out" option from Profile Drop-Down
    Then User should see "Sign in" text on the screen