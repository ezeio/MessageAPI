Feature: I want to be able to modify a message
  By replacing the message with another message


  Scenario: modifying an existing message
    Given: I have a message and an identifier
    When: I send the message with the identifier
    Then: the message linked to that modifier is replaced with the new message
