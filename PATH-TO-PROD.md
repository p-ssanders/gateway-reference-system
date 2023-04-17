#   Path to Production on Public Cloud Kubernetes Exercise

Given the topology of this reference artifact, what would a path to production look like?

Implement a simple "Hello World" path to production, after which you will be expected to:
-   Demonstrate the running application on a public cloud kubernetes cluster
-   Demonstrate the steps you took to get the application running there (e.g.: live roll-out a change, talk through diagrams or code)
-   Discuss the decisions you made, the tradeoffs you accepted, and the challenges you faced

For an additional challenge, there is a "Scalable" path to production you can implement.

##  The "Hello World" Path to Production

This path to production is the equivalent of a "hello world" app, in that it's the most simple set of steps a developer can take to transform their source code into a running application that can be accessed by users.

1.  Produce OCI images from source code locally
1.  Publish images to OCI image registry like DockerHub
1.  Provision/access a cluster on a cloud provider that is considered the production environment
1.  Manually apply kubernetes YAML to deploy containers on the cluster (i.e.: `kubectl apply`)
1.  Manually provision services (e.g.: PostgreSQL) and inject connection information to containers
1.  Access the app for smoke tests

Note all the decisions that are made along the way for a single pass along a very simple path to production:
-   How did you produce an OCI image?
    -   Dockerfile? What's in it? Why?
    -   Buildpacks? Which ones? Why?
-   How did you push the image to the image registry? Did you use Dockerhub?
    -   Did you tag the image?
-   How did you provision a cluster?
    -   Which cloud? Why?
    -   What behavior does the cluster have out of the box?
    -   Did you add additional behavior? Why?
    -   How did you get access to the cluster?
-   How did you apply the kubernetes YAML?
    -   Did you have to configure the application differently?
-   How did you deploy services?
-   How did you provide the service connection information to the app?
    -   Did you manage secrets securely?
-   How did you access the app?
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

##  The Scalable Path to Production

You did such a great job with the prior exercise, your organization promoted you to Chief Cloud Officer (CCO). You're now accountable for the migration of all your organizations' workloads to the kubernetes platform. Congratulations!

How do you ensure the path to production scales to support an organization of 100 software development teams?

Likely, you need to provide teams with _automation_. For example:

1.  Monitor source code repository for changes
1.  Test source code and store results somewhere
1.  Scan source code and store results somewhere
1.  Transform application source code into an OCI image
1.  Scan the image and store results somewhere
1.  Generate kubernetes manifests that enforce organizational standards
1.  Push the kubernetes manifests to a GitOps repository
1.  Apply the kubernetes manifests to the "production" environment from the GitOps repository
1.  Register ingress routes and DNS for the application
1.  Provision TLS certificates for the route
1.  Provision services for the application