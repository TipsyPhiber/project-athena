package com.athena;

import com.athena.controller.ResourceController;
import com.athena.model.Resource;
import com.athena.service.ResourceService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ResourceControllerTest {

    @Test
    public void testGetResourcesReturnsSeedData() {
        ResourceController controller = new ResourceController(new ResourceService());

        List<Resource> resources = controller.getAllResources();

        assertNotNull(resources);
        assertEquals(2, resources.size());
        assertEquals("Tenant-A", resources.get(0).getTenantId());
    }

    @Test
    public void testCreateResourceAssignsIdAndStatus() {
        ResourceController controller = new ResourceController(new ResourceService());

        Resource created = controller.createResource(new Resource("New-VM", "Compute", "Tenant-X"));

        assertNotNull(created.getId());
        assertEquals("ACTIVE", created.getStatus());
    }

    @Test
    public void testCreateResourceWithoutStatusDefaultsToProvisioning() {
        ResourceService service = new ResourceService();
        Resource bare = new Resource();
        bare.setName("Bare-VM");

        Resource saved = service.save(bare);

        assertNotNull(saved.getId());
        assertEquals("PROVISIONING", saved.getStatus());
    }

    @Test
    public void testFindAllReturnsImmutableSnapshot() {
        ResourceService service = new ResourceService();

        List<Resource> snapshot = service.findAll();

        assertTrue(snapshot.size() >= 2);
        try {
            snapshot.add(new Resource("Hacked", "X", "Y"));
            throw new AssertionError("snapshot should be immutable");
        } catch (UnsupportedOperationException expected) {
            // expected
        }
    }
}
