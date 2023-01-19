Feature: Check home page functionality

  Scenario: check logout link
    Given user is logged in
    When user clicks on welcome link
    Then logout link is displayed

  Scenario: verify quick launch toolbar is present
    Given user is logged in
    When user clicks on dashboard link
    Then quick launch toolbar is displayed
