@cart
Feature: Shopping Cart

Scenario: Verify the purchasing of a product
Given I launch the application in chrome browser
When I enter valid user name and password
|username				|password			|
|standard_user	|secret_sauce	|
And I click on Login button
Then User should be logged in
And I add a product to the cart
And I go to Cart page
And I checkout the purchase
And I enter checkout information and click continue
|First_Name			|Last_Name	|Postal_Code|
|Nagarjun Reddy	|Kasu				|500032			|
And I verify the checkout overview page
Then I complete the order
