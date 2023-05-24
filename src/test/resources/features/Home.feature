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
@tag
Feature: Home Page tests

  #Scenario: Title of your scenario
  # Given I want to write a step with precondition
  #And some other precondition
  #When I complete action
  #And some other action
  #And yet another action
  #Then I validate the outcomes
  #And check more outcomes
  #@tag2
  #Scenario Outline: Title of your scenario outline
  # Given I want to write a step with <name>
  # When I check for the <value> in step
  #Then I verify the <status> in step
  #Examples:
  # | name  | value | status  |
  #| name1 |     5 | success |
  #| name2 |     7 | Fail    |
  @homepagetests
  Scenario: Validate Get started Button Exist and enabled
    Given User is on DS algo landing page
    When User clicks on Get Started button on Landing Page 
    Then User is navigated to DS algo home page

  @homepagetests
  Scenario: LandingPage
    Given User is on DS algo landing page
    When User clicks on Get Started button on Landing Page
    Then DS algo home page is opened
    And Verify user is not logged in

  @homepagetests
  Scenario: ClickRegister
    Given User is on DS algo landing page
    When User clicks on Get Started button on Landing Page
    And User clicks on Register
    Then User should be directed to Register page

  @homepagetests
  Scenario: SignIn
    Given User is on DS algo landing page
    When User clicks on Get Started button on Landing Page
    And User clicks on SignIn
    Then User should be directed to SignIn Page

  @homepagetests
  Scenario: DataStructures
    Given User is on DS algo landing page
    When User clicks on Get Started button on Landing Page
    And User Clicks on Data Structure Drop Down
    Then user should be able to view the Drop Down

  @homepagetests
  Scenario Outline: HomePage DataStructure Links Validation
    Given User is on DS algo landing page
    When User clicks on Get Started button on Landing Page
    And User clicks on HomePage DataStructure "<linkname>"
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

  @homepageDataStructureDropDown
  Scenario Outline: HomePage DataStructure DropDown Validation
    Given User is on DS algo landing page
    When User clicks on Get Started button on Landing Page
    And User Clicks on Data Structure Drop Down
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
