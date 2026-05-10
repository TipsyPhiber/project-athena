package com.athena.service;

import com.athena.model.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ResourceService {

    private final List<Resource> resources = Collections.synchronizedList(new ArrayList<>());
    private final AtomicLong idSequence = new AtomicLong(0);

    public ResourceService() {
        save(new Resource("Legacy-Server-01", "Compute", "Tenant-A"));
        save(new Resource("Cloud-DB-Cluster", "Database", "Tenant-B"));
    }

    public List<Resource> findAll() {
        return List.copyOf(resources);
    }

    public Resource save(Resource resource) {
        if (resource.getId() == null) {
            resource.setId(idSequence.incrementAndGet());
        }
        if (resource.getStatus() == null) {
            resource.setStatus("PROVISIONING");
        }
        resources.add(resource);
        return resource;
    }
}
