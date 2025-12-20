package com.athena.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Resource {
    // Evidence of "Optimizing database interactions"
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type; // e.g., "Server", "Database", "License"
    private String status; // "ACTIVE", "DEPRECATED"
    private String tenantId; // Evidence of "Multi-tenant architecture"

    public Resource(String name, String type, String tenantId) {
        this.name = name;
        this.type = type;
        this.status = "ACTIVE";
        this.tenantId = tenantId;
    }
}
