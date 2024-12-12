package org.api.productcatalogservice.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.api.productcatalogservice.demo.util.CatageoryType;

@Setter
@Getter
public class Catageory extends BaseModel{
    private CatageoryType catageoryType;

}
