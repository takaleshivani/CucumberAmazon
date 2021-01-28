Feature: AmazonApplication Testing
 

Background:
Given user opens browser
And User enters URl

@TitleCheck
Scenario: Verification of Login page is correct
Given User is on login page
When user gets the title of page
Then page title should be "My account - My Store"

@LoginCheck
Scenario: verification of login functionality when username & password is correct
Given User is on login page
When user enters username "takaleshivani10@gmail.com"
And  user enters on Password "Fast@1104"
When user clicks on Login button
Then page title should be "My account - My Store"

@ForgotPwdCheck
Scenario: Verification of forgot password button
Given User is on login page
When user clicks on Forgot button
Then page title should be "Forgot your password - My Store"
And user enters username "takaleshivani10@gmail.com"
When user clicks on Retrieve button



    
