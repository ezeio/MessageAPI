@Getter
Feature: If I know the identifier of a message,
  I want to be able to retrieve the message that is linked to the identifier

  Scenario: Getting an existing message
    Given I have an identifier for a message
    When I attempt to retrieve a message using that identifier
    Then the message linked to that identifier is returned


  Scenario: Getting an existing message using an invalid identifier
    Given I have an invalid identifier for a message
    When I attempt to retrieve a message using the invalid identifier
    Then I am informed that the message with the identifier is not found