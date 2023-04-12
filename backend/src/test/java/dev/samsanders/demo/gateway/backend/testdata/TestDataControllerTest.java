package dev.samsanders.demo.gateway.backend.testdata;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.IdGenerator;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext
class TestDataControllerTest {

    @MockBean
    TestDataRepository testDataRepository;

    @MockBean
    IdGenerator dataGenerator;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getTestDataCount() throws Exception {
        when(testDataRepository.count()).thenReturn(1L);

        mockMvc
            .perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().json("{\"count\": 1}"));
    }

    @Test
    void createTestData() throws Exception {
        when(dataGenerator.generateId()).thenReturn(UUID.randomUUID());
        when(testDataRepository.create(any())).thenReturn(new TestData(1, null, null));

        mockMvc
            .perform(post("/"))
            .andExpect(status().isCreated())
            .andExpect(header().string(HttpHeaders.LOCATION, "http://localhost/1"));
    }

    @Test
    void getTestData() throws Exception {
        UUID uuid = UUID.randomUUID();
        Instant now = Instant.now();
        TestData testData = new TestData(1, uuid.toString(), now);
        when(testDataRepository.read(1)).thenReturn(Optional.of(testData));

        mockMvc
            .perform(get("/1"))
            .andExpect(status().isOk())
            .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().json("{\"id\":1,\"data\":\"%s\",\"createdAt\":\"%s\"}".formatted(uuid, now)));
    }

    @Test
    void getTestData_notFound() throws Exception {
        when(testDataRepository.read(2L)).thenReturn(Optional.empty());

        mockMvc
            .perform(get("/2"))
            .andExpect(status().isNotFound());
    }
}