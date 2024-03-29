package dev.samsanders.demo.gateway.backend.testdata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.Repository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TestDataRepository implements Repository<TestData, Long> {

    private static final Logger logger = LoggerFactory.getLogger(TestDataRepository.class);
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public TestDataRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    TestData create(TestData testData) {
        logger.info("Creating TestData: %s".formatted(testData));

        String insertQuery = "insert into test_data (data) values (:testData)";
        Map<String, Object> values = new HashMap<>();
        values.put("testData", testData.data());

        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(insertQuery, new MapSqlParameterSource(values), generatedKeyHolder);
        Long id = (Long) generatedKeyHolder.getKeys().get("id");
        Instant createdAt = ((Timestamp) generatedKeyHolder.getKeys().get("created_at")).toInstant();
        testData = new TestData(id, testData.data(), createdAt);

        logger.info("TestData created: %s".formatted(testData));

        return testData;
    }

    public Optional<TestData> read(long id) {
        String readQuery = "select id, data, created_at from test_data where id = :id";
        Map<String, Object> values = new HashMap<>();
        values.put("id", id);

        List<TestData> testDataList = namedParameterJdbcTemplate.query(readQuery, values, (rs, rowNum) -> {
            long id1 = rs.getLong("id");
            String data = rs.getString("data");
            Timestamp created_at = rs.getTimestamp("created_at");

            return new TestData(id1, data, created_at.toInstant());
        });

        return testDataList.stream().findFirst();
    }

    long count() {
        return namedParameterJdbcTemplate.getJdbcTemplate().queryForObject("select count(1) from test_data", Long.class);
    }
}
