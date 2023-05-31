@Signin
Feature: Sign in Page

  Scenario: Redirect to Register page
    Given User is on SignIn page
    When User Clicks on Register link
    Then User should be redirected to Register page

  Scenario: To verify SignIn with Empty fields
    Given User is on SignIn page
    When User clicks on login button with all empty field
    Then User verify the message at username

  Scenario: To verify SignIn with username only
    Given User is on SignIn page
    When User clicks on login button with username only
    Then User verify the message at password

  Scenario: To verify SignIn with password only
    Given User is on SignIn page
    When User clicks on login button with password only
    Then User verify the message at user

  Scenario: To verify SignIn with invalid username and password
    Given User is on SignIn page
    When User enters invalid username
    And User enters invalid password
    And User clicks login button
    Then User verify the message

  Scenario Outline: User  Login with  valid username and password from excel sheet
    Given User is on SignIn page
    When User enters sheetname "<Sheetname>" and rownumber <RowNumber>
    And User clicks on login button
    Then It should navigate to the home page with a successful login message

    Examples: 
      | Sheetname    | RowNumber |
      | registration |         8 |

  
   Scenario: User is able to sign out
   	When User clicks on Sign out 
   	Then User is signed out
