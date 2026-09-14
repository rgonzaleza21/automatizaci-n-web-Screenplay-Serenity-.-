Feature: Buy Test

  @compras
  Scenario Outline: testing the successful buy
    Given the user is on the serenity demo page
    When attempts to log in
    When attempts to log in with valid credentials

      | firstName   | lastName   | postalCode   | backpack   | bike   | YourCart   | Dispatched   |
      | <firstName> | <lastName> | <postalCode> | <backpack> | <bike> | <YourCart> | <Dispatched> |
    Then validate the text on screen

  Example:
  | firstName    | lastName       | postalCode  |YourCart|backpack|bike||Dispatched|
  | Randy        | Gonzalez       | 12345678    |Your Cart|Sauce Labs Bike Light|Sauce Labs Bike Light|   Thank you for your order!      |
