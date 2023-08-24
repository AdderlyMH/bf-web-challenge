Feature: Login
  Background:
    Given user goes to the main page

    Scenario Outline: Create user
      Given user writes data: "<username>", "<password>"
      When user clicks the SIGN UP button
      Then appears a pop-up with the message "Sign up successful."
      Examples:
        | username | password |
        | ejemplo  | ejemplo  |