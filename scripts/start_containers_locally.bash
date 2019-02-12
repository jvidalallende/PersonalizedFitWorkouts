#!/bin/bash

function wait {
  echo "Waiting ${1} seconds for MariaDB to be up and running"
  for i in $(seq $1)
  do
    echo -n "."
    sleep 1
  done
  echo ""
}

echo "Starting MariaDB container"
docker run -d --name juanvidal-db \
           -e MYSQL_ROOT_PASSWORD=banana \
           -v"$(pwd)"/../database/init_db:/docker-entrypoint-initdb.d \
           -p3306:3306 \
           mariadb:10.0
wait 30

echo "Starting web services"
docker run --name juanvidal-pfw -p8080:8080 -d juanvidal-pfw-app
docker run --name juanvidal-pdf -p8090:8090 -d juanvidal-pdfcreator
wait 30

echo "All services should be running now up"
