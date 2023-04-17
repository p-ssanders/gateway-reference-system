#   Backend API Application

This application is a Spring Boot "backend" that exposes an HTTP/JSON API.

The API is simple: you can create a `TestData`, you can read a `TestData`, and you can get the count of `TestData`s.

The data can be stored in H2 or PostgreSQL.

##  Build

    ./gradlew build

##  Run Locally

    docker run --name postgres -e POSTGRES_PASSWORD=secret -e POSTGRES_DB=ptp -e POSTGRES_USER=ptp -e POSTGRES_PASSWORD=ptp -v $HOME/postgresql-data:/var/lib/postgresql/data -p 5432:5432 -d postgres
    SPRING_PROFILES_ACTIVE=local ./gradlew bootrun

##  Explore API

    GET http://localhost:8081/api
    POST http://localhost:8081/api
    GET http://localhost:8081/api/1234
