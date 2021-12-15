#!/bin/sh

cp ../target/eventstreaming-test-0.0.1-SNAPSHOT.jar  .
docker build . -t softwarefactory.dplt.eu/eventstreaming-test:latest
rm eventstreaming-test-0.0.1-SNAPSHOT.jar
docker push softwarefactory.dplt.eu/eventstreaming-test:latest
