package com.athena.controller;

import com.athena.model.Resource;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/resources")
@CrossOrigin(origins = "http://localhost:4200") // Allows Angular frontend to connect
public class ResourceController {

    // Evidence of "RESTful APIs to facilitate seamless communication"
    @GetMapping
    public List<Resource> getAllResources() {
        // Mock data to simulate database retrieval
        return Arrays.asList(
            new Resource("Legacy-Server-01", "Compute", "Tenant-A"),
            new Resource("Cloud-DB-Cluster", "Database", "Tenant-B")
        );
    }

    @PostMapping
    public Resource createResource(@RequestBody Resource newResource) {
        // Evidence of "exchanging formatted JSON data payloads"
        newResource.setStatus("PROVISIONING");
        return newResource;
    }
}
