[![Backend Build](https://github.com/p-ssanders/gateway-reference-system/actions/workflows/backend.yml/badge.svg)](https://github.com/p-ssanders/gateway-reference-system/actions/workflows/backend.yml)
[![Frontend Build](https://github.com/p-ssanders/gateway-reference-system/actions/workflows/frontend.yml/badge.svg)](https://github.com/p-ssanders/gateway-reference-system/actions/workflows/frontend.yml)
[![Gateway Build](https://github.com/p-ssanders/gateway-reference-system/actions/workflows/gateway.yml/badge.svg)](https://github.com/p-ssanders/gateway-reference-system/actions/workflows/gateway.yml)

##  Gateway Reference System

Many systems consist of a "backend" which provides data storage and lookup via API, and a "frontend" which allows a human user to interact with the backend.

Often, these systems are deployed with monolithic topology, where a single deployable unit serves both the API and the static assets.

As always, there are tradeoffs with the monolithic topology, particularly when compared to the distributed or microservice topology.

This repository contains source code for three applications:

1.  [Backend API](backend/README.md)
1.  [Frontend UI](frontend/README.md)
1.  [Gateway](gateway/README.md)

These applications comprise a system, and can run locally, in docker, or on kubernetes. The system makes for an interesting workload for learning as it requires:

-   Building multiple artifacts using different build tools
-   Deploying multiple artifacts
-   Integrating the deployed artifacts
-   Deploying a database