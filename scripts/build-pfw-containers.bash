#!/bin/bash

PFW_MAIN="juanvidal-pfw-main"
PDF_CREATOR="juanvidal-pdfcreator"

eval $(minikube docker-env)
docker rmi ${PFW_MAIN} ${PDF_CREATOR}
docker build -t ${PFW_MAIN} ../pfw_main/
docker build -t ${PDF_CREATOR} ../pdfcreator/
