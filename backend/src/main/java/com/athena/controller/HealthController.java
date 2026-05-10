package com.athena.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class HealthController {

    @GetMapping("/status")
    public Map<String, String> healthCheck() {
        return Map.of("status", "active", "system", "Athena");
    }
}
