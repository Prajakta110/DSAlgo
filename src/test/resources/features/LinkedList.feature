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
@LinkedList
Feature: Linked list

  Background: User is Logged In
    Given User Launches Home Page

  Scenario: User is logged in
    When User clicks on Sign in button on Home page
    And User enters valid username and password
    And User clicks on Sign in
    Then User shoild be able to see the logged in message

  Scenario: Verify Linked List Page Launch on Click of Linked List Get Started Button
    When User clicks on LinkedList GetStartedBtn
    Then Verify User is on Linked List Page

  Scenario Outline: Verify Linked List Link List "<linkname>" Url
    Given User clicks on LinkedList GetStartedBtn
    When User clicks Linked-listpage "<linkname>" link
    Then Verify linked list link url "<url>"

    Examples: 
      | linkname                        | url                                                                            |
      | Introduction                    | https://dsportalapp.herokuapp.com/linked-list/introduction/                    |
      | Creating Linked LIst            | https://dsportalapp.herokuapp.com/linked-list/creating-linked-list/            |
      | Types of Linked List            | https://dsportalapp.herokuapp.com/linked-list/types-of-linked-list/            |
      | Implement Linked List in Python | https://dsportalapp.herokuapp.com/linked-list/implement-linked-list-in-python/ |
      | Traversal                       | https://dsportalapp.herokuapp.com/linked-list/traversal/                       |
      | Insertion                       | https://dsportalapp.herokuapp.com/linked-list/insertion-in-linked-list/        |
      | Deletion                        | https://dsportalapp.herokuapp.com/linked-list/deletion-in-linked-list/         |

  Scenario Outline: Verify Linked List Sub Link Url "<url>" Try Here Editor Button
    Given User launches linkedlist suburl "<url>"
    When User clicks on try here button
    Then Verify Try Here button takes to editor Url

    Examples: 
      | linkname                        | url                                                                            |
      | Introduction                    | https://dsportalapp.herokuapp.com/linked-list/introduction/                    |
      | Creating Linked LIst            | https://dsportalapp.herokuapp.com/linked-list/creating-linked-list/            |
      | Types of Linked List            | https://dsportalapp.herokuapp.com/linked-list/types-of-linked-list/            |
      | Implement Linked List in Python | https://dsportalapp.herokuapp.com/linked-list/implement-linked-list-in-python/ |
      | Traversal                       | https://dsportalapp.herokuapp.com/linked-list/traversal/                       |
      | Insertion                       | https://dsportalapp.herokuapp.com/linked-list/insertion-in-linked-list/        |
      | Deletion                        | https://dsportalapp.herokuapp.com/linked-list/deletion-in-linked-list/         |
      
    Scenario: User is able to sign out
   	When User clicks on Sign out 
   	Then User is signed out
