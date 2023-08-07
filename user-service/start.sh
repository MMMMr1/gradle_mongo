#!/bin/bash

./gradlew build
docker run
docker-compose build
docker-compose up