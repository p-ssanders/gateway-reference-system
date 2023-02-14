package dev.samsanders.demo.gateway.backend.application;

import java.util.Collections;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    private static Integer count = 0;
    
    @GetMapping("/api/something")
    ResponseEntity<Map<String, Integer>> getSomething() {

        return ResponseEntity.ok(Collections.singletonMap("value", ++count));
    }

}
