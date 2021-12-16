#!/bin/sh

APP=consumer-0.0.1-SNAPSHOT.jar
IMAGE_NAME=eventstreaming-test-consumer-2:latest

cp ../target/$APP  app.jar
docker build . -t softwarefactory.dplt.eu/$IMAGE_NAME
rm app.jar
docker push softwarefactory.dplt.eu/$IMAGE_NAME

