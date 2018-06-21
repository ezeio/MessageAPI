Feature: Add message
  I want to be able to create a new message and
  receive the identifier of the newly created message

  Scenario: Creating a new message
    Given: I have a message
    When: I add the message
    Then: I should receive an identifier of the message
    And: the identifier should uniquely identify the added message