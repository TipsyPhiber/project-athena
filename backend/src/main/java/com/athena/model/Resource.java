package com.athena.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resource {

    private Long id;
    private String name;
    private String type;
    private String status;
    private String tenantId;

    public Resource(String name, String type, String tenantId) {
        this.name = name;
        this.type = type;
        this.status = "ACTIVE";
        this.tenantId = tenantId;
    }
}
