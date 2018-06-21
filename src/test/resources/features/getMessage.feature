Feature: If I know the identifier of a message,
  I want to be able to retrieve the message that is linked to the identifier

  Scenario: Getting an existing message
    Given: I have an identifier for a message
    When: I attempt to retrieve a message using that identifier
    Then: the message linked to that identifier is returned