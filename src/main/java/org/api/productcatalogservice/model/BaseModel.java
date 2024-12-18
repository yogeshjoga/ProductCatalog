package org.api.productcatalogservice.model;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.api.productcatalogservice.util.State;

@Setter
@Getter
@MappedSuperclass
public abstract class BaseModel {
    @Id
    private Long id;
    private String name;
    private String description;
    private String owner;
    private State state;
}
