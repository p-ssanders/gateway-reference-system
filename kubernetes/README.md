#   Deployment to Kubernetes

This directory contains kubernetes manifests to deploy the gateway reference system.

##  Assumptions

*   The components of the system have been built into images, and published to Docker Hub
*   All system resources will be deployed into a namespace called `gateway-reference`
*   DNS records are managed manually


##  Cluster Services

-   [NGINX Ingress Controller](https://kubernetes.github.io/ingress-nginx/)
