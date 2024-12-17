package org.api.productcatalogservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.api.productcatalogservice.util.CatageoryType;
import org.api.productcatalogservice.util.State;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponceDto {
    private Long id;
    private String name;
    private String description;
    private String owner;
    private State state;
    private String imageUrl;
    private Double price;private CatageoryType catageoryType;
}
