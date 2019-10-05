Feature: Contact form

  Scenario Outline: Contact customer service

    Given I go to URL "http://automationpractice.com/index.php"
    When I click on "Contact us"
    And I select Subject Heading "<subject heading>"
    And I enter email address "<email address>"
    And I enter message "<message text>"
    And I click "Send"
    Then Success message "<success message>" appears

    Examples:
      | subject heading  | email address         | message text | success message                                      |
      | Customer service | test@devschooling.com | text         | Your message has been successfully sent to our team. |
      | Webmaster        | test@devschooling.com | text         | Your message has been successfully sent to our team. |