#!/usr/bin/env bash

cd ../
./gradlew clean bootJar
cp build/libs/*.jar docker
ls docker
cd docker
docker build -t training-app-customer-service:1.0 .
rm -rf *.jar
