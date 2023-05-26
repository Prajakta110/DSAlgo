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
    Then User should be able to see the logged in message

  Scenario: Verify Linked List Page Launch on Click of Linked List Get Started Button
    When User clicks on LinkedList GetStartedBtn
    Then Verify User is on Linked List Page

  Scenario Outline: User is able to run python code from  "<linkname>" Url and get correct output
    Given User is on Editor page via "<linkname>" and "<url>"
    When User runs python code from "<sheetName>" and row number <rowNum>
    Then User should see the correct output

    Examples: 
      | linkname                        | url                                                                            | sheetName  | rowNum |
      | Introduction                    | https://dsportalapp.herokuapp.com/linked-list/introduction/                    | pythonCode |      0 |
      | Creating Linked LIst            | https://dsportalapp.herokuapp.com/linked-list/creating-linked-list/            | pythonCode |      0 |
      | Types of Linked List            | https://dsportalapp.herokuapp.com/linked-list/types-of-linked-list/            | pythonCode |      0 |
      | Implement Linked List in Python | https://dsportalapp.herokuapp.com/linked-list/implement-linked-list-in-python/ | pythonCode |      0 |
      | Traversal                       | https://dsportalapp.herokuapp.com/linked-list/traversal/                       | pythonCode |      0 |
      | Insertion                       | https://dsportalapp.herokuapp.com/linked-list/insertion-in-linked-list/        | pythonCode |      0 |
      | Deletion                        | https://dsportalapp.herokuapp.com/linked-list/deletion-in-linked-list/         | pythonCode |      0 |

  Scenario Outline: User is able to run python code from  "<linkname>" Url and get correct error message
    Given User is on Editor page via "<linkname>" and "<url>"
    When User runs python code from "<sheetName>" and row number <rowNum>
    Then User should see the correct error message

    Examples: 
      | linkname                        | url                                                                            | sheetName  | rowNum |
      | Introduction                    | https://dsportalapp.herokuapp.com/linked-list/introduction/                    | pythonCode |      1 |
      | Creating Linked LIst            | https://dsportalapp.herokuapp.com/linked-list/creating-linked-list/            | pythonCode |      1 |
      | Types of Linked List            | https://dsportalapp.herokuapp.com/linked-list/types-of-linked-list/            | pythonCode |      1 |
      | Implement Linked List in Python | https://dsportalapp.herokuapp.com/linked-list/implement-linked-list-in-python/ | pythonCode |      1 |
      | Traversal                       | https://dsportalapp.herokuapp.com/linked-list/traversal/                       | pythonCode |      1 |
      | Insertion                       | https://dsportalapp.herokuapp.com/linked-list/insertion-in-linked-list/        | pythonCode |      1 |
      | Deletion                        | https://dsportalapp.herokuapp.com/linked-list/deletion-in-linked-list/         | pythonCode |      1 |

  Scenario: User is able to sign out
    When User clicks on Sign out
    Then User is signed out
