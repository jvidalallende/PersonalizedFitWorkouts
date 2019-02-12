#!/bin/bash

docker rmi juanvidal-pfw-app juanvidal-pdfcreator
docker build -t juanvidal-pfw-app ../pfw_app/
docker build -t juanvidal-pdfcreator ../pdfcreatormodule/
