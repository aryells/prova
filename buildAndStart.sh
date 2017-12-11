#!/usr/bin bash

cd technical-evaluation-user
mvn clean install dockerfile:build
cd ../technical-evaluation-credit-check
mvn clean install dockerfile:build
cd ..

docker-compose -p aryel up
