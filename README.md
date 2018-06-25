# MessageAPI


# Prepare a simple Spring boot app which:
- exposes 4 rest endpoints:
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

