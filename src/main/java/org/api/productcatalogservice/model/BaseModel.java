package org.api.productcatalogservice.model;

import lombok.Getter;
import lombok.Setter;
import org.api.productcatalogservice.util.State;

@Setter
@Getter
public abstract class BaseModel {
    private Long id;
    private String name;
    private String description;
    private String owner;
    private State state;
}
