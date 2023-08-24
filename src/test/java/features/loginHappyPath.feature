Feature: Login

  Background:
    Given user goes to the main page

  Scenario Outline: Login user
    Given user clicks the header LOGIN button
    And user writes login data: "<login_username>", "<login_password>"
    When user clicks the modal LOG IN button
    Then appears a button with the message "<welcome_username>"
    And user clicks the header LOG OUT button
    Examples:
      | login_username | login_password | welcome_username |
      | example        | example        | Welcome example  |