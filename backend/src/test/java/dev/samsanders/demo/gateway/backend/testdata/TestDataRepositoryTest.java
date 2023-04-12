package dev.samsanders.demo.gateway.backend.testdata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJdbcTest
class TestDataRepositoryTest {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    TestDataRepository testDataRepository;

    @BeforeEach
    void beforeEach() {
        JdbcTestUtils.deleteFromTables(namedParameterJdbcTemplate.getJdbcTemplate(), "test_data");
    }

    @Test
    void create() {
        TestData testData = new TestData(0L, "some-test-data", null);

        TestData actual = testDataRepository.create(testData);

        assertEquals(1L, actual.id());
        assertEquals("some-test-data", actual.data());
        assertNotNull(actual.createdAt());
    }

    @Test
    void read() {
        TestData testData = testDataRepository.create(new TestData(0L, "some-test-data", null));

        Optional<TestData> testDataOptional = testDataRepository.read(testData.id());

        assertTrue(testDataOptional.isPresent());
        assertEquals("some-test-data", testDataOptional.get().data());
        assertNotNull(testDataOptional.get().createdAt());
    }

    @Test
    void count() {
        testDataRepository.create(new TestData(0L, "some-test-data", null));

        long count = testDataRepository.count();

        assertEquals(1, count);
    }
}