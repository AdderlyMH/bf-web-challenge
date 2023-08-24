Feature: Sign up

  Background:
    Given user goes to the main page

  Scenario Outline: Create user
    Given user clicks the header SIGN UP button
    And user writes data: "<username>", "<password>"
    When user clicks the modal SIGN UP button
    Then appears a pop-up with the message "<text_message>"
    And clicks the OK alert button
    Examples:
      | username     | password         | text_message        |
      | yourName2    | yourPassword2    | Sign up successful. |
      | anotherName2 | anotherPassword2 | Sign up successful. |