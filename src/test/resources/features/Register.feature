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
@registration
Feature: Registration Page
  I want to use this template for my feature file

  @GetClickRegisterLink01
  Scenario: The user click register link
    Given Ds Algo  portal home page
    When The user clicks the Register link
    Then The user should be redirected to registration page.

  @EmptyTextBoxGetRegister
  Scenario: 1 user click register button and  getting error message
    Given user is on registration page
    When user click register button with empty Unm and pwd textbox
    Then warning message should display

  @UserNamePasswordTest
  Scenario Outline: 3 Check Combination of Username and Password from "<sheetName>" rownumber <rownumber>
    Given user is on registration page
    When user enter userName from "<sheetName>" and rownumber <rownumber>
    Then verify Registration Status

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

  @TheUserClickNumpyNinjaLink
  Scenario: 4 The user click login button
    Given user is on registration page
    When user click NumpyNinja link.
    Then user redirect to landing page

  @GetClickRegisterLink01
  Scenario: The user click register link
    Given Ds Algo  portal home page
    When The user clicks the Register link
    Then The user should be redirected to registration page.

  @TheUserClickLoginButton
  Scenario: 8  user click login button
    Given user is on registration page
    #When user click login link to check successful registration
    Then user logged into website
