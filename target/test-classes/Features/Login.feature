Feature: Login Test

Background:
Given Launch browser
When Navigate to url "http://automationexercise.com"
Then Verify that home page is visible successfully
And Click on 'Signup / Login' button
Then Verify "Login to your account" is visible
@sanity
Scenario: Login User with correct email and password

When Enter correct email address as "shahidgsa013@gmail.com" and password as "Coolboy@123"
And Click login button
Then Verify that Logged in as username is visible
And close browser
@regression
Scenario Outline: login with multiple inputs DDT

When Enter correct email address as "<email>" and password as "<pass>"
And Click login button
Then Verify that Logged in as username is visible
And close browser

Examples:
|email|pass|
|shahidgsa013@gmail.com|Coolboy@123|
|shahidgsa012@gmail.com|Coolboy@123|
@sanity
Scenario: Logout User

When Enter correct email address and password
And Click login button
Then Verify that Logged in as username is visible
And Click 'Logout' button
Then Verify that user is navigated to login page





