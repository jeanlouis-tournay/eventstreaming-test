#!/bin/sh

APP=producer-0.0.1-SNAPSHOT.jar
IMAGE_NAME=eventstreaming-test-producer-2:latest

cp ../target/$APP  app.jar
docker build . -t $IMAGE_NAME
rm app.jar
docker tag $IMAGE_NAME softwarefactory.dplt.eu/$IMAGE_NAME
docker push softwarefactory.dplt.eu/$IMAGE_NAME
