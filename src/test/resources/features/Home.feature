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
@Home
Feature: Home Page tests
  
  Scenario: Register page opens on click of Register link
    Given User is on DS algo home page
    When  User clicks on Register
    Then User should be directed to Register page

  Scenario: Sign In page opens on click of Sign in  page
    Given User is on DS algo home page
    When User clicks on SignIn
    Then User should be directed to SignIn Page

  Scenario: Data Structures dropdown opens on click of dropdown
    Given User is on DS algo home page
    When User Clicks on Data Structure Drop Down
    Then user should be able to view the Drop Down

  Scenario Outline: Home Page DataStructure Links Validation
    Given User is on DS algo home page
    When User clicks on HomePage DataStructure "<linkname>"
    Then user should be able to view the error msg

    Examples: 
      | linkname                     |
      | data-structures-introduction |
      | array                        |
      | linked-list                  |
      | stack                        |
      | queue                        |
      | tree                         |
      | graph                        |

  Scenario Outline: HomePage Data Structure DropDown Validation
    Given User is on DS algo home page
    When User Clicks on Data Structure Drop Down
    And User clicks on HomePage DataStructure DropDown "<linkname>"
    Then user should be able to view the error msg

    Examples: 
      | linkname     |
      | /array       |
      | /linked-list |
      | /stack       |
      | /queue       |
      | /tree        |
      | /graph       |