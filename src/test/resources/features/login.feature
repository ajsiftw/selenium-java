Feature: Login

  Scenario: Successful Login Config Properties
    Given User opens URL
    When User enters username and password
    And User clicks login
    Then Page title should be "DEMOQA"
    When User clicks on logout link
    Then Page title should be "DEMOQA"

  Scenario Outline: Successful Login Data Driven
    Given User opens URL "<loginUrl>"
    When User enters username as "<user>" and password as "<password>"
    And User clicks login
    Then Page title should be "DEMOQA"
    When User clicks on logout link
    Then Page title should be "DEMOQA"

    Examples:
      | loginUrl                 | user    | password     |
      | https://demoqa.com/login | ajsiftl | Password123! |
      | https://demoqa.com/login | ajsiftd | Password123! |