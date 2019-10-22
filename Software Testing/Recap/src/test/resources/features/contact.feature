Feature: Contact Form

  Background:
    Given I access the website in automation.properties
    When I click on Contact us

  Scenario Outline: Contact Form Success
    And I select "<subject heading>"
    And I enter an email address "<email address>"
    And I write a message "<message>"
    And I check TestBackpack for this message "<message>"
    And I click on button Send
    Then I receive success message "<success message>"

    Examples:
      | subject heading  | email address   | message              | success message                                      |
      | Customer service | email@yahoo.com | I request assistance | Your message has been successfully sent to our team. |
      | Webmaster        | cat@yahoo.com   | I want milk          | Your message has been successfully sent to our team. |

  Scenario Outline: Contact Form Failure
    And I select "<subject heading>"
    And I enter an email address "<email address>"
    And I write a message "<message>"
    And I click on button Send
    Then I receive error message "<error message>"

    Examples:
      | subject heading  | email address     | message              | error message                                   |
      | -- Choose --     | email@yahoo.com   | I request assistance | Please select a subject from the list provided. |
      | Customer service |                   | I want milk          | Invalid email address.                          |
      | Webmaster        | email@address.com |                      | The message cannot be blank.                    |