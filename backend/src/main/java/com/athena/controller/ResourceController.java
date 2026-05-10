package com.athena.controller;

import com.athena.model.Resource;
import com.athena.service.ResourceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/resources")
@CrossOrigin(origins = "http://localhost:4200")
public class ResourceController {

    private final ResourceService service;

    public ResourceController(ResourceService service) {
        this.service = service;
    }

    @GetMapping
    public List<Resource> getAllResources() {
        return service.findAll();
    }

    @PostMapping
    public Resource createResource(@RequestBody Resource newResource) {
        return service.save(newResource);
    }
}
