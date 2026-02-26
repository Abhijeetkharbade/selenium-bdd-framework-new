Feature: Login functionality

  Background: Valid Login
    Given User is on login page
    When User enters username and password
    And User clicks login button
    Then User should navigate to home page

	@smoke
    Scenario: Add items to cart 
    Given User is on home page
    When User adds products to cart
    And User clicks on cart button
    Then User should navigate to cart
    Then User should fill checkout information
    Then User should click on continue