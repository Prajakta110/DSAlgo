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
@Array @DSAlgo
Feature: Title of your feature
  I want to use this template for my feature file

  Background: User is on Home Page
    Given User is on DS Algo Home page
    #When User clicks on Sign in button on Home page
    #And User enters valid username and password
    #And User clicks on Sign in
    #Then User shoild be able to see the logged in message

	Scenario: User is logged in
		When User clicks on Sign in button on Home page
    And User enters valid username and password
    And User clicks on Sign in
    Then User shoild be able to see the logged in message
    
  @ArrayScenario01
  Scenario: User is able to navigate to Array page
    #Given User is on DS Algo Home page
    When User clicks on Get Started button for Array
    Then User should be redirected to Array page

  @ArrayScenario02
  Scenario: User is able to navigate to Arrays in Python page
    Given User is on Array page
    When User clicks on Arrays in Python link
    Then User should be redirected to Arrays in Python page

  @ArrayScenario03
  Scenario: User is able to navigate to Editor Page
    Given User is on Arrays in Python page
    When User clicks on Try Here button
    Then User should be redirected to Editor page

  @ArrayScenario04
  Scenario Outline: User is able to run a python code and get correct output or error message
    Given User is on Editor Page
    When User runs a python code from "<sheetName>" row number <rowNum>
    Then User should be able to see the correct output

    Examples: 
      | sheetName  | rowNum |
      | pythonCode |      5 |

  @ArrayScenario05
  Scenario Outline: User is able to run a python code and get correct output or error message
    Given User is on Editor Page
    When User runs a python code from "<sheetName>" row number <rowNum>
    Then User should be able to see relevant error message

    Examples: 
      | sheetName  | rowNum |
      | pythonCode |      6 |

  @ArrayScenario06
  Scenario: User is able to navigate to Practice Questions page
    Given User is on Arrays in Python page
    When User clicks on Practice Questions link
    Then User should be redirected to Practice page

  @ArrayScenario07
  Scenario: User is able to navigate to Question page with Editor
    Given User is on Practice Questions Page
    When User clicks on first Question link
    Then User should be redirected to Question page with the editor

  @ArrayScenario08
  Scenario Outline: User is able to run and submit valid python code and get correct output
    Given User is on Question Page
    When User runs a relevant python code from "<sheetName>" row number <rowNum>
    Then User should be able to get correct output
    And User should be able to submit the code

    Examples: 
      | sheetName  | rowNum |
      | pythonCode |      7 |

  @ArrayScenario09
  Scenario Outline: User is able to see a valid error when they try to run and submit invalid python code
    Given User is on Question Page
    When User runs code with error from "<sheetName>" row number <rowNum>
    Then User should be able to get relevant error message
    And User should be able to get error on submitting the invalid code

    Examples: 
      | sheetName  | rowNum |
      | pythonCode |      8 |
