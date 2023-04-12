package dev.samsanders.demo.gateway.backend;

import dev.samsanders.demo.gateway.backend.testdata.TestDataRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.util.IdGenerator;

import java.util.UUID;

@SpringBootApplication
public class GatewayDemoBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayDemoBackendApplication.class, args);
    }

    @Bean
    TestDataRepository testDataRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        return new TestDataRepository(namedParameterJdbcTemplate);
    }

    @Bean
    IdGenerator dataGenerator() {
        return UUID::randomUUID;
    }
}
