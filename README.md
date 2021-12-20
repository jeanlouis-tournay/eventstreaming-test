# Test Program for Event Streaming


This programs can be used for testing deployment and configuration of a spring boot digital product which requires event streaming. 


### Test Scenario 


- Create platform service (if not present), contract and specification.
- Deploy Product.
- A rest call posts a message to the producer.
- The producer sends the message to a kafka topic. 
- The consumer get the message from the kafka topic. 
- A Rest call in the consumer allows to retrieve the message. 
- Message posted in the producer equals message retrieved in the consumer. 


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

- [Platform service for event streaming](deploy/platform-service-eventstreaming.json)
- [Contract](deploy/contract.json) 
- [Specification](deploy/specification.json) 

