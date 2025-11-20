Feature: Login Test

  Scenario: Valid login functionality
    Given user launches browser
    And user opens the application
    When user enters username "standard_user" and password "secret_sauce"
    And user clicks on login button
    Then homepage should be displayed
