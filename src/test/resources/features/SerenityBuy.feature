Feature: Buy Test

  @compras
  Scenario Outline: testing the successful buy
    Given the user is on the serenity demo page
    When logs in with valid credentials
    And buys products
      | firstName   | lastName   | postalCode   | backpack   | bike   | YourCart   | Dispatched   |
      | <firstName> | <lastName> | <postalCode> | <backpack> | <bike> | <YourCart> | <Dispatched> |
    Then validates the purchase message "<Dispatched>"

  Example:
  | firstName    | lastName       | postalCode  |YourCart|backpack|bike||Dispatched|
  | Randy        | Gonzalez       | 12345678    |Your Cart|Sauce Labs Bike Light|Sauce Labs Bike Light|   Thank you for your order!      |
