#!/bin/bash

export DB_URL=http://couchdb-flight-board.ben-cluster3-403315c8b53cfaaf40d7fd4ee4d91267-0000.eu-gb.containers.appdomain.cloud
export DB_USERNAME=admin
export DB_NAME=flights
export DB_PASSWORD=BwbXeZT2irjq0mrc2vAv
export DB_SEARCH_ENDPOINT=_find
export KAFKA_REST_URL=http://platinum-es-ibm-es-recapi-insecure-cp4i.itzroks-120000k3ak-eje49a-4b4a324f027aea19c5cbc0c3275c4656-0000.eu-gb.containers.appdomain.cloud/topics
export KAFKA_TOPIC=flight-delays
export SCHEDULE_DB_URL=http://localhost:3000/
export WLP_LOGGING_CONSOLE_LOGLEVEL=INFO

mvn liberty:run
