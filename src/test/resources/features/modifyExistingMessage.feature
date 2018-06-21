Feature: I want to be able to modify a message
  By replacing the message with another message


  Scenario: modifying an existing message
    Given: I have a message and an identifier
    When: I send the message with the identifier
    Then: the message linked to that modifier is replaced with the new message

  Scenario: attempting to modify a message using an invalid id
    Given: I have a message and an invalid identifier
    When: I send the message with the invalid identifier
    Then: I am informed that there is no message linked to the identifier

    Scenario: attempting to modify a message using a valid id with an empty message
      Given: I have an empty message and an valid identifier
      When: I send the empty message with the identifier
      Then: I am informed that the message is empty