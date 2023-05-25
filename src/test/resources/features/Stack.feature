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
@Stack
Feature: Stack Page

	Background: User is on Home Page
		Given User is on DS Home page
		
	Scenario: User is logged in
    When User clicks on Signin button on Home page
    And User enters valid username and pwd
    And User clicks on Signin
    Then User should be able to see the logged in message

  
  Scenario: 1 User is able to navigate to Stack page
    Given User is on DS Algo Home page
    When User clicks on Get Started button for Stack
    Then User should be redirected to Stack page

  
  Scenario: 2 User navigate to operations In Stack Page
    Given User is on Stack page
    When User clicks on Operations in Stack link
    Then User should be redirected to Opeartions in Stack page

  
  Scenario: 3 User navigate to implementation page
    Given User is on Operations-in-stack page
    When User clicks on implementation link
    Then User should redirect to implementation page

  
  Scenario: User navigate to application page
    Given User is on  implentation page
    When User clicks Application link
    Then User should redirect to Application page

  
  Scenario: User navigate to tryEditor Page
    Given User is on Application page
    When User Clicks on Try here>>>
    Then User should navigate to tryEditor Page

	
   Scenario Outline: User run a python code for valid scenario from sheetName rownumber rownumber .   
    Given User is on tryEditor page
    When User runs python code from "<sheetName>" rownumber <rownumber>
    Then User should get correct output.

    Examples: 
      | sheetName  | rownumber |
      | pythonCode |         0 |
      
  
   Scenario Outline: User run a python code for invalid scenario from sheetName rownumber rownumber .   
    Given User is on tryEditor page
    When User runs python code from "<sheetName>" rownumber <rownumber>
    Then User should get correct error message.

    Examples: 
      | sheetName  | rownumber |
      | pythonCode |         1 |
      
    Scenario: User is able to sign out
   	When User clicks on Sign out 
   	Then User is signed out