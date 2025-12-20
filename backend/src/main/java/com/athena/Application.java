package com.athena;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("Athena ERP System Started...");
    }

    @GetMapping("/api/status")
    public String healthCheck() {
        return "{\"status\": \"active\", \"system\": \"Athena Enterprise\"}";
    }
}
