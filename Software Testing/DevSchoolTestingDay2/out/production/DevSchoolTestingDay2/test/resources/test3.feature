Feature: Contact form

  Background:
    Given I go to URL "http://automationpractice.com/index.php"
    When I click on "Contact us"

    @ID-34
  Scenario Outline: Contact customer service
    And I select Subject Heading "<subject heading>"
    And I enter email address "<email address>"
    And I enter message "<message text>"
    And I click "Send"
    Then Success message "<success message>" appears

      @priority1
    Examples:
      | subject heading  | email address         | message text | success message                                      |
      | Customer service | test@devschooling.com | text         | Your message has been successfully sent to our team. |

      @priority2
      Examples:
        | subject heading  | email address         | message text | success message                                      |
        | Customer service | test@devschooling.com | text         | Your message has been successfully sent to our team. |

      @priority2
  Scenario Outline: Invalid customer form requests
    And I select Subject Heading "<subject heading>"
    And I enter email address "<email address>"
    And I enter message "<message text>"
    And I click "Send"
    Then Error message appears "<error message>"

    Examples:
      | subject heading  | email address         | message text | error message                                   |
      | -- Choose --     | test@devschooling.com | text         | Please select a subject from the list provided. |
      | Customer service |                       | text         | Invalid email address.                          |
      | Webmaster        |                       | text         | Invalid email address.                          |
      | Customer service | test@devschooling.com |              | The message cannot be blank.                    |
      | Webmaster        | test@devschooling.com |              | The message cannot be blank.                    |