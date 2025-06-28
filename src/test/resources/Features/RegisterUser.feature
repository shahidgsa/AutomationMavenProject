Feature: Register New User
@regression
Scenario: Registering Account for New User
Given Launch browser
When Navigate to url "http://automationexercise.com"
Then Verify that home page is visible successfully
And Click on 'Signup / Login' button 
Then Verify New User Signup! is visible
When Enter name and email address
And Click Signup button
Then Verify that ENTER ACCOUNT INFORMATION is visible
When Fill details: Title, Name, Email, Password, Date of birth
And Select checkbox Sign up for our newsletter!
And  Select checkbox Receive special offers from our partners!
When Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
And close browser
