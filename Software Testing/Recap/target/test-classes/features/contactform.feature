Feature: Contact Form

  Scenario: Submit a contact form
    Given I navigate to "http://automationpractice.com"
    When I click on contact link
    When I complete contact details
    Then I submit contact form