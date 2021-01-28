Feature: Validation of Account Page
  I want to use this template for my feature file

Background: 
Given User is logged into Application
|username                 |password|
|takaleshivani10@gmail.com|Fast@1104|

  @CheckAccount
  Scenario: Validation of Account Page title
    Given User is on Account Page
   When user gets the title of page
   Then page title should be "My account - My Store"


  Scenario: Account Section Count
    Given User is on Account Page
    Then user gets the accounts section
		|ORDER HISTORY AND DETAILS|
		|MY CREDIT SLIPS|
		|MY ADDRESSES|
		|MY PERSONAL INFORMATION|
		|MY WISHLISTS|
		|Home|
		And account section count should be 5
