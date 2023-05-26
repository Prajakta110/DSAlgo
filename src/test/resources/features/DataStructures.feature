#Author: your.email@your.domain.com
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
@DataStructures
Feature: Data Structures Page

  Background: User is on Home Page
    Given User is on DS Algo Home page

  Scenario: User is logged in
    When User clicks on Sign in button on Home page
    And User enters valid username and password
    And User clicks on Sign in
    Then User should be able to see the logged in message

  Scenario: User is able to navigate to Data Structures page
    When User clicks on Get Started button for Data Structures
    Then User should be redirected to Data Structures page

  Scenario: User is able to navigate to Time Complexity page
    Given User is on Data Structures page
    When User clicks on Time Complexity link
    Then User should be redirected to Time Complexity Page

  Scenario: User is able to navigate to Editor page
    Given User is on Time Complexity page
    When User clicks on Try here button
    Then User should be redirected to Editor Page

  Scenario Outline: User is able to run a python code and get correct output
    Given User is on Editor page
    When User runs python code from "<sheetName>" row number <rowNum>
    Then User should be able to see correct output

    Examples: 
      | sheetName  | rowNum |
      | pythonCode |      2 |

  Scenario Outline: User is able to see valid error when invalid python code is executed
    Given User is on Editor page
    When User runs python code from "<sheetName>" row number <rowNum>
    Then User should be able to see correct error message

    Examples: 
      | sheetName  | rowNum |
      | pythonCode |      3 |
      | pythonCode |      4 |

  Scenario: User is able to sign out
    When User clicks on Sign out
    Then User is signed out
