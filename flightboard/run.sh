#!/bin/bash

docker run \
    -p 9080:9080 \
    --env DB_URL=http://couchdb-app-test.ben-cluster3-403315c8b53cfaaf40d7fd4ee4d91267-0000.eu-gb.containers.appdomain.cloud/test \
    --env DB_SEARCH_ENDPOINT=_find \
    --env KAFKA_REST_URL=http://airport-ibm-es-recapi-insecure-cp4i.ben-cluster3-403315c8b53cfaaf40d7fd4ee4d91267-0000.eu-gb.containers.appdomain.cloud/topics \
    --env KAFKA_TOPIC=flight-delays \
    flight-board