Feature: feature to test login functionality

@smoke
  Scenario: Check login is successful with valid credentials
    Given browser is open
    And user is on login page
    When user enters username and password
    And clicks on login button
    Then user should be display my login page

  Scenario: Check login is successful with valid credentials
    Given browser is open
    And user is on login page
    When user enters username and password
    And clicks on login button
    Then user should be display my login page
