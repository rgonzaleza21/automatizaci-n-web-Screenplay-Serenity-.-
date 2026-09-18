Feature: Buy Test

  @compras
  Scenario Outline: testing the successful buy

    Given the user is on the serenity demo page
    When attempts to log in with "<user>" and "<pass>"
    And attempts to buy products
      | firstName   | lastName   | postalCode   | backpack   | bike   | yourCart   | products   |
      | <firstName> | <lastName> | <postalCode> | <backpack> | <bike> | <yourCart> | <products> |
    Then validates the purchase message "<Dispatched>"


    Examples:
      | user          | pass         | firstName | lastName | postalCode | yourCart  | products | backpack            | bike                  | Dispatched                |
      | standard_user | secret_sauce | Randy     | Gonzalez | 12345678   | Your Cart | Products | Sauce Labs Backpack | Sauce Labs Bike Light | Thank you for your order! |
