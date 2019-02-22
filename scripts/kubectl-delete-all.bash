#!/bin/bash
kubectl delete deployments --all
kubectl delete services --all
kubectl delete ingress --all
kubectl delete pods --all
kubectl delete pvc --all
kubectl delete pv --all
