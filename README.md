#   Path to Production Exercise

Many systems consist of a "backend" which provides data storage and lookup via API, and a "frontend" which allows a human user to interact with the backend.

Often, these systems are deployed with monolithic topology, where a single deployable unit serves both the API and the static assets.

As always, there are tradeoffs with the monolithic topology, particularly when compared to the distributed or microservice topology.

This repository contains source code for three applications:
1.  [Backend API](backend/README.md)
1.  [Frontend UI](frontend/README.md)
1.  [Gateway](gateway/README.md)

The gateway solves problems related to deploying the frontend separately from the backend, while highlighting the benefits of the distributed toplogy over monolithic. For example:
-   The gateway can act as a proxy, so the backend and frontend applications can be deployed to a secured network that is not exposed to the "edge" (the Internet)
-   The gateway can present both applications from a single domain, obviating the need for CORS configuration

##  Path to Production on Kubernetes Exercise

Given this common topology, what would the path to production look like?

### The "Hello World" Path to Production

1.  Produce OCI images from source code locally
1.  Publish images to public OCI image registry, like DockerHub, locally
1.  Provision/access a cluster on a cloud provider
1.  Manually apply YAML to deploy containers on the cluster (i.e.: kubectl apply)
1.  Access the app for smoke tests

Note all the decisions that are made along the way for a single pass along a very simple path to production.
