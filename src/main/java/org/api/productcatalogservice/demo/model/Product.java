package org.api.productcatalogservice.demo.model;


import lombok.Getter;
import lombok.Setter;
import org.api.productcatalogservice.demo.util.CatageoryType;

@Setter
@Getter
public class Product extends BaseModel {
    private String imageUrl;
    private Double price;
    private CatageoryType catageoryType;
}
