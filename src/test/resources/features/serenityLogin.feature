Feature: login test
@login
  Scenario Outline: testing the successful login

    Given the user is on the serenity demo page
    When attempts to log in with "<user>" and "<pass>"
    Then validate the text on screen <message>
    Examples:
      | user          | pass         | message  |
      | standard_user | secret_sauce | Products |
