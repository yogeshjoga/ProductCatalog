package org.api.productcatalogservice.model;

import lombok.Getter;
import lombok.Setter;
import org.api.productcatalogservice.util.CatageoryType;

@Setter
@Getter
public class Catageory extends BaseModel{
    private CatageoryType catageoryType;

}
