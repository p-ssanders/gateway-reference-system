#   Gateway Application

This application is a Spring Cloud "Gateway" application that can route requests to both the [backend](../backend/README.md) application, and the [frontend](../frontend/README.md) application.

This allows for a deployment topology where only this application is exposed, and creates the appearance that the backend and frontend applications are being served from the same domain.

##  Build

    ./mvnw package

##  Run Locally

    ./mvnw spring-boot:run

##  Explore the Gateway

Run the frontend, and backend applications locally.

Browse to the gateway URL: http://localhost:8080/