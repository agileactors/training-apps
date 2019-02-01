#!/usr/bin/env bash

cd ../
./gradlew clean bootJar
cp build/libs/*.jar docker
cd docker
docker build -t training-app-auditlog-service:1.0 .
rm -rf *.jar
