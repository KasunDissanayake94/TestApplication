#Author: kasunprageethdissanayake@gmail.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Home
  Navigate to Home

  @tag1
  Scenario: Navigate to ikman.lk to find houses in Colombo
    Given I am on the "https://ikman.lk" page
    When I click on Property link
    And I click on Houses link
    And I click on Colombo link
    And I enter min_price as "5000000"and a max_Price as "7500000"
    And I set bed as "3"
    Then I am navigated to the result page
    Then I am close the browser



