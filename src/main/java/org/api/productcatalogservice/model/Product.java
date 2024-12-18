package org.api.productcatalogservice.model;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.api.productcatalogservice.util.CatageoryType;

@Setter
@Getter
@Entity
public class Product extends BaseModel {
    private String imageUrl;
    private Double price;
    //private CatageoryType catageoryType;
}
