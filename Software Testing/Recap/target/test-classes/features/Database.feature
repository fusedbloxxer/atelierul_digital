@api
Feature: Database feature

  Scenario: Database interactions in Java
    Given I select something from the database using Java JDBC
    And I select from database using Spring JDBC Template
    When I select an user with email "andrei@email.com" using Spring JDBC Template
    And I select an user via Spring Data JPA
    When I select an user with email "andrei@email.com" using Spring Data JPA