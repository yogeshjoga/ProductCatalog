package org.api.productcatalogservice.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.api.productcatalogservice.demo.util.State;

@Setter
@Getter
public abstract class BaseModel {
    private Long id;
    private String name;
    private String description;
    private String owner;
    private State state;
}
