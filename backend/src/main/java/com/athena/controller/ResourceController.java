package com.athena.controller;

import com.athena.model.Resource;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/resources")
@CrossOrigin(origins = "http://localhost:4200") 
public class ResourceController {

    @GetMapping
    public List<Resource> getAllResources() {
        return Arrays.asList(
            new Resource("Legacy-Server-01", "Compute", "Tenant-A"),
            new Resource("Cloud-DB-Cluster", "Database", "Tenant-B")
        );
    }

    @PostMapping
    public Resource createResource(@RequestBody Resource newResource) {
        newResource.setStatus("PROVISIONING");
        return newResource;
    }
}
