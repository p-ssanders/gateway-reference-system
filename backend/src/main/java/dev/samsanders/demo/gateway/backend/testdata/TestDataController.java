package dev.samsanders.demo.gateway.backend.testdata;

import org.springframework.http.ResponseEntity;
import org.springframework.util.IdGenerator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class TestDataController {

    private final TestDataRepository testDataRepository;
    private final IdGenerator dataGenerator;

    public TestDataController(TestDataRepository testDataRepository, IdGenerator dataGenerator) {
        this.testDataRepository = testDataRepository;
        this.dataGenerator = dataGenerator;
    }

    @GetMapping
    Map<String, Long> getTestDataCount() {
        return Collections.singletonMap("count", testDataRepository.count());
    }

    @PostMapping
    ResponseEntity<Void> createTestData() {
        TestData testData = new TestData(0, dataGenerator.generateId().toString(), null);
        testData = testDataRepository.create(testData);
        UriComponents location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(testData.id());

        return ResponseEntity.created(location.toUri()).build();
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getTestData(@PathVariable long id) {
        Optional<TestData> testData = testDataRepository.read(id);

        if (testData.isPresent())
            return ResponseEntity.ok(testData.get());
        else
            return ResponseEntity.notFound().build();
    }

}
