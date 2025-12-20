package com.athena;

import com.athena.controller.ResourceController;
import com.athena.model.Resource;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

// Evidence of "Test-Driven Design (TDD) methodologies"
public class ResourceControllerTest {

    @Test
    public void testGetResourcesReturnsJson() {
        ResourceController controller = new ResourceController();
        List<Resource> resources = controller.getAllResources();

        assertNotNull(resources);
        assertEquals(2, resources.size());
        assertEquals("Tenant-A", resources.get(0).getTenantId());
    }

    @Test
    public void testResourceStatusDefault() {
        Resource res = new Resource("Test-VM", "Compute", "Tenant-Test");
        assertEquals("ACTIVE", res.getStatus());
    }
}
