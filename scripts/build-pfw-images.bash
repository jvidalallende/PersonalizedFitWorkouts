#!/bin/bash

# Get the path to scripts folder based on this script's path
SCRIPTS_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
PFW_ROOT="$(dirname "$SCRIPTS_DIR")"

PFW_MAIN="juanvidal-pfw-main"
PDF_CREATOR="juanvidal-pdfcreator"

eval $(minikube docker-env)
docker build -t ${PFW_MAIN} ${PFW_ROOT}/pfw_main/
docker build -t ${PDF_CREATOR} ${PFW_ROOT}/pdfcreator/
