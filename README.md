# Test Program for Event Streaming


This programs can be used for testing deployment and configuration of a digital product which requires event streaming. 


### Scenario 

- A message is posted to the producer via a rest call 
- The producer send the message to a kafaka topic 
- The consumer get the message from the kafka topic 
- A Rest call in the consumer allows to retrieve the message 



post a Message to the producer 

``` bash 
curl --socks5-hostname localhost:1080 -X POST  -H 'Content-Type: application/json'  -d '{"message":"hello how are you"}' $PRODUCER_URL/message
```

Get the message from the consumer 

``` bash 
curl --socks5-hostname localhost:1080  $CONSUMER_URL/message
{"message":"hello how are you"}`
```


### Deployment 

- [Platform service with event streaming](deploy/platform-service-eventstreaming.json)
- [Contract](deploy/contract.json) 
- [Specification](deploy/specification.json) 