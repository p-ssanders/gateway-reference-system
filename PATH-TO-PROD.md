#   Path to Production on Kubernetes Exercise

Given the topology of this reference artifact, what would the path to production look like?

##  The "Hello World" Path to Production
-   Produce OCI images from source code locally
-   Publish images to public OCI image registry, like DockerHub, locally
-   Provision/access a cluster on a cloud provider
-   Manually apply YAML to deploy containers on the cluster (i.e.: kubectl apply)
-   Access the app for smoke tests

Note all the decisions that are made along the way for a single pass along a very simple path to production.