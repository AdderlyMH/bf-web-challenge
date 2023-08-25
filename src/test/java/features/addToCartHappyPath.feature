Feature: Add to Cart

  Background:
    Given user goes to the main page

  Scenario Outline: User adds product to shopping cart
    Given user clicks on product "<product_name>"
    When user clicks the ADD TO CART button
    Then appears a pop-up with the message "<text_message>"
    And clicks the OK alert button
    Examples:
      | product_name | text_message  |
      | Sony vaio i5 | Product added |