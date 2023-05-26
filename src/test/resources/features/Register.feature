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
@Register
Feature: Registration Page
  
  Scenario: Error while trying to register with blank details
    Given user is on registration page
    When user click register button with empty Unm and pwd textbox
    Then warning message should display

  Scenario Outline: User gets error when entered invalid combinations of from "<sheetName>" rownumber <rownumber>
    Given user is on registration page
    When user registers with userName from "<sheetName>" and rownumber <rownumber>
    Then verify message

    Examples: 
      | sheetName    | rownumber |
      | registration |         0 |
      | registration |         1 |
      | registration |         2 |
      | registration |         3 |
      | registration |         4 |
      | registration |         5 |
      | registration |         6 |
      | registration |         7 |

	Scenario: User is able to login with valid details
		Given user is on registration page
		When user enters valid username, password and confirm password
		Then user is able to register successfully

  #Scenario: User is able to login with registered new user
  # Given user is on registration page
   #When user click login link to check successful registration
   #Then user logged into website
   
  Scenario: User is able to sign out
    When User clicks on Sign out
    Then User is signed out
