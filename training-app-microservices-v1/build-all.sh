#!/usr/bin/env bash

for service in $(ls | grep service)
do
	cd $service/docker
	./build-image.sh
	cd ../..
done
