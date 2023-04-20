#   Deployment to Kubernetes

This directory contains kubernetes manifests to deploy the gateway reference system.

##  Assumptions

*   The components of the system have been built into images, and published to Docker Hub
*   All system resources will be deployed into a namespace called `gateway-reference`
*   DNS records are managed manually
*   PostgreSQL is installed using the [PostgreSQL packaged by Bitnami](https://bitnami.com/stack/postgresql/helm) helm chart

##  Cluster Services

-   [NGINX Ingress Controller](https://kubernetes.github.io/ingress-nginx/)
-   [cert-manager](https://cert-manager.io/docs/installation/helm/)
-   [Amazon EBS CSI driver](https://docs.aws.amazon.com/eks/latest/userguide/ebs-csi.html)