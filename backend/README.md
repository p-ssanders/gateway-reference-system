#   Backend API Application

This application is a Spring Boot "backend" that exposes an HTTP/JSON API.

The API is simple: you can create a `TestData`, you can read a `TestData`, and you can get the count of `TestData`s.

The data can be stored in H2 or PostgreSQL.

##  Build

    ./gradlew build

##  Run Locally

    docker run --name postgres -e POSTGRES_DB=ptp -e POSTGRES_USER=ptp -e POSTGRES_PASSWORD=ptp -v /tmp/postgresql-data:/var/lib/postgresql/data -p 5432:5432 -d postgres@sha256:6b91d38a9c596fa4e6a1276f6f81810882d9f292a09f9cf2647c6a554c8b6d00
    SPRING_PROFILES_ACTIVE=local ./gradlew bootrun

##  Explore API

    GET http://localhost:8081/api
    POST http://localhost:8081/api
    GET http://localhost:8081/api/1234

##  Build Image

    ./gradlew bootbuildimage

##  Run Image

    docker run -p 8081:8081 -e SPRING_PROFILES_ACTIVE=local -e SYSTEM_HOSTNAME=host.docker.internal backend:0.0.1-SNAPSHOT --server.port=8081
