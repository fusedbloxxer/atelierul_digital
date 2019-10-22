Feature: Fashion

  Background:
    Given I access the website in automation.properties

  Scenario Outline: AtuomationPractice.com - Buy dress
    When I search for "<item>"
    Then I check that results have "<item>"
    And I quit the driver

    Examples:
      | item  |
      | shirt |
      | dress |