package org.api.productcatalogservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestProductDto {

//    title: 'test product',
//    price: 13.5,
//    description: 'lorem ipsum set',
//    image: 'https://i.pravatar.cc',
//    category: 'electronic'
    private Long id;
    private String title;
    private Double price;
    private String description;
    private String image;
    private String category;
}
