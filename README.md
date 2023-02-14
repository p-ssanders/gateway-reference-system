#   Gateway Reference Implementation

Many systems consist of a "backend" which provides data storage and lookup via API, and a "frontend" which allows a human user to interact with the backend.

Often, these systems are deployed with monolithic topology, where a single deployable unit serves both the API and the static assets.

As always, there are tradeoffs with the monolithic topology, particularly when compared to the distributed or microservice topology.

This repository contains source code for three applications:
1.  backend API
1.  frontend UI
1.  gateway

The gateway will be used to solve the problems related to deploying the frontend separately from the backend, while highlighting the benefits of the distributed toplogy over monolithic.

