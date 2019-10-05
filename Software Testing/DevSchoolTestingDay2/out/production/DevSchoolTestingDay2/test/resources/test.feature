Feature: Contact form

  Scenario: Contact customer service

    Given I go to URL "http://automationpractice.com/index.php"
    When I click on "Contact us"
    And I select Subject Heading "Customer service"
    And I enter email address "test@devschooling.com"
    And I enter message "text"
    And I click "Send"
    Then Success message "Your message has been successfully sent to our team." appears

  Scenario: Contact webmaster

    Given I go to URL "http://automationpractice.com/index.php"
    When I click on "Contact us"
    And I select Subject Heading "webmaster"
    And I enter email address "test@devschooling.com"
    And I enter message "text"
    And I click "Send"
    Then Success message "Your message has been successfully sent to our team." appears