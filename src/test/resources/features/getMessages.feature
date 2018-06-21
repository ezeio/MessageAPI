Feature: I want to be able to limit the number of messages that I retrieve
  The retrieval is based on the last set number of messages


  Scenario: Retrieving a limited number of last existing messages
  Given: I have a limited number of messages that I want to retrieve
  When: I attempt to retrieve those messages using the limited number
  Then: the limited number of messages specified is returned in order of a last in first out bases


  Scenario: Retrieving a limited number of messages when there are no messages left
    Given: there are no messages
    And: I have a limited number of messages that I want to retrieve
    When: I attempt to retrieve those messages
    Then: I am informed that there are no messages to be retrieved