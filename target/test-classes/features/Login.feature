@login
Feature: Login

Background:
Given I launch the application in chrome browser

Scenario: Verify the login functionality with valid credentials
When I enter valid user name and password
|username				|password			|
|standard_user	|secret_sauce	|
And I click on Login button
Then User should be logged in

Scenario: Verify the login functionality with invalid credentials
When I enter invalid user name and password
|username				|password			|
|test_user			|test_sauce		|
And I click on Login button
Then User should not be logged in