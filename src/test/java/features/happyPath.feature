Feature: Login
  Background:
    Given user goes to the main page

    Scenario Outline: Create user
      Given user clicks the header SIGN UP button
      And user writes data: "<username>", "<password>"
      When user clicks the modal SIGN UP button
      Then appears a pop-up with the message "<text_message>"
      Examples:
        | username | password | text_message             |
        | example  | example  | This user already exist. |