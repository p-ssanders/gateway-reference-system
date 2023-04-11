package dev.samsanders.demo.gateway.backend.testdata;

import java.time.Instant;

public record TestData(long id, String data, Instant createdAt) {
}
