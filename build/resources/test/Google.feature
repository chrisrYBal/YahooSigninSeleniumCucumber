Feature: Sign in form test suite
  Test Sign in module for Yahoo


  Scenario: Go to Yahoo sign in page
    Given I redirect to yahoo home page
    When I click sign in button
    Then the login page should be displayed

  Scenario: Input non-existing username
    Given I redirect to yahoo sign in page
    When I input invalid username
    And I click Next button
    Then the username error message should be displayed

  Scenario: Input wrong password
    Given I redirect to yahoo sign in page
    When I input valid username
    And I click Next button
    Then the input password page should be displayed
    When I input wrong password
    And I click password Next button
    Then the password error message should be displayed

  Scenario: Happy Path
    Given I redirect to yahoo sign in page
    When I input valid username
    And I click Next button
    Then the input password page should be displayed
    When I input correct password
    And I click password Next button
    Then I navigated to my account









