Feature: Yahoo Sign in page should have verification on username and password

  Background: Redirect to Yahoo Sign in page from Yahoo Home page
    Given I am on the Home page
    When I click on "Sign in" button on the Home page
    Then I should be on the Yahoo Sign in page

  Scenario Outline: Username should display an error when entered with invalid data
    When I enter invalid "<username>" data into the input box
    And I click on "login-signin" button to proceed
    Then the "<error>" error message on the username Sign in page for input "<username>" should be visible
    Examples:
      | username   | error                                        |
      | fortesting | Sorry, we don't recognize this email.        |
      | 0936055985 | Sorry, we don't recognize this phone number. |
      |            | Sorry, we don't recognize this email.        |

  Scenario Outline: Password should display an error when entered with invalid data

    When I enter "chrisryanbaltazar@yahoo.com" into the username input box
    And I click on "login-signin" button to proceed
    And I enter "<password>" into the input box
    And I click on "login-signin" button to proceed
    Then the "<error>" error message on the password Sign in page for input "<password>" should be visible
    Examples:
      | password | error                              |
      | Rosoi    | Invalid password. Please try again |
      |          | Please provide password.           |

  Scenario Outline: Both username and password should able to proceed when entered with valid data
    When I enter valid "<username>" data into the input box
    And I click on "login-signin" button to proceed
    And I enter "Rosoideae" into the password input box
    And I click on "login-signin" button to proceed
    Then I should be able to logged in
    Examples:
      | username                    |
      | chrisryanbaltazar@yahoo.com |
      | chrisryanbaltazar           |








