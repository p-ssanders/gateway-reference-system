#   Path to Production on Public Cloud Kubernetes Exercise

Given the topology of the reference system, what would a path to production look like?

Implement a simple "Hello World" path to production on a public cloud provider (AWS, GCP, Azure) so that you can:

-   Demonstrate the running system
-   Demonstrate the steps you took to get the application running there by, for exampe, rolling out a change
-   Discuss the decisions you made, the tradeoffs you accepted, and the challenges you faced

##  The "Hello World" Path to Production

This path to production is the equivalent of a "hello world" app, in that it's the most simple set of steps a developer can take to transform their source code into a running application on a kubernetes that can be accessed by users.

1.  Produce OCI images from source code
1.  Publish images to OCI image registry (e.g.: DockerHub)
1.  Provision & access a cluster
1.  Apply kubernetes manifests to deploy containers on the cluster (i.e.: `kubectl apply`)
1.  Provision services (e.g.: PostgreSQL) and inject connection information to containers
1.  Configure routing and ingress to access the system

Note all the decisions that are made along the way for a single pass along a very simple path to production:

-   How did you produce an OCI image?
    -   Dockerfile? What's in it? Why?
    -   Buildpacks? Which ones? Why?
-   How did you push the image to the image registry?
    -   Did you use Docker Hub? Why?
    -   How did you tag the image?
-   How did you provision a cluster?
    -   Which cloud? Why?
    -   What behavior does the cluster have out of the box?
    -   Did you add additional behavior? Why?
    -   How did you access to the cluster?
-   How did you apply the kubernetes manifests?
    -   How did you configure the system components?
-   How did you deploy services?
    -   How did you provide the service connection information to the system components?
    -   How did you manage secrets like credentials?
    -   How did you manage storage for a database?
-   How did you access the system?
    -   What was required to get this working?

These are just some examples of the technical decisions you will make in the process of moving an application from your development machine to a user-facing environment. What about once it's there?

-   Security
    -   How do you know what you deployed is what you intended to deploy?
    -   How do you know it's not vulnerable to exploitation?
-   Observability
    -   How well is your system operating?
    -   How will you know if it degrades, or breaks entirely?
-   Maintenance
    -   How will you roll out updates?
    -   How will you ensure certificates don't expire?
-   Cost
    -   How are you utilizing the cloud resources to minimize cost?