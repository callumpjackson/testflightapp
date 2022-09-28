#!/bin/bash

mvn package liberty:create liberty:install-feature liberty:deploy liberty:package -Dinclude=minify,runnable
docker build -t flight-board .
docker tag flight-board icr.io/platinumdemo/flight-board:latest
docker push icr.io/platinumdemo/flight-board:latest
