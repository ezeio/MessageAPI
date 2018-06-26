# MessageAPI


# Prepare a simple Spring boot app which: exposes 4 rest endpoints:

  a) POST /message
  
  b) PUT /message
  
  c) GET /messages/{limit}
  
  d) GET /message/{messageID}
  
- with either embedded db (preferably) or in memory structure persistence
- with tests
  Where we can:
- add messages { "title": "some title", "message":"Some message" } and get in return { "id": "<UUID>"}
- modify already existing message but only for 10sec after the message was added
- get one specific message by ID
- get either all messages or a specific number of last messages


## Assumptions 

# PUT /message: 

Changed path in order to identify resource to be updated - PUT/message/{messageid}

# Embedded database
I used H2 since it meets the criteria

# Modify already existing message but only for 10sec after the message was added

I did not implement this feature. What does “after the message was added” mean? 

Do you mean the scenario below

Scenario:
I add a new message. The newly added message should not be modified within 10 seconds of its creation. 




## TEST

Run MessageServiceTest for the unit test and CukesRunner class for both integration and acceptance test. 
 
