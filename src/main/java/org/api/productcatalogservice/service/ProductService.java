package org.api.productcatalogservice.service;

import org.api.productcatalogservice.client.FakeStoreApi;
import org.api.productcatalogservice.dto.RequestProductDto;
import org.api.productcatalogservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService implements IProductService {

    /**
     * Instance of RestTemplateBuilder used for building and configuring RestTemplate instances.
     * It is typically used to customize the properties of a RestTemplate such as timeout duration,
     * message converters, or interceptors. The RestTemplateBuilder is automatically provided
     * by Spring Boot and facilitates the creation of RestTemplate beans.
     */
    @Autowired
    RestTemplateBuilder builder;


    @Autowired
    FakeStoreApi api;

    /**
     *
     * @param id
     * @return
     */

    @Override
    public Product getProductById(Long id) {
       RequestProductDto dto = api.getProductById(id);
       return from(dto);
    }




    /**
     * Converts a {@link RequestProductDto} object into a {@link Product} object.
     * This method maps the fields from the data transfer object (DTO) to the domain model.
     *
     * @param dto the {@link RequestProductDto} object containing product data to be converted
     * @return a {@link Product} object populated with data from the provided DTO
     */

    public Product from (RequestProductDto dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getTitle());
        product.setDescription(dto.getDescription());
        product.setImageUrl(dto.getImage());
        product.setPrice(dto.getPrice());
        return product;
    }


    /**
     * Checks if a product exists by its identifier by making a request to an external API.
     *
     * @param id the unique identifier of the product to check for existence
     * @return true if the product exists, false otherwise
     */
    @Override
    public boolean isProductExist(Long id, Product p) {
        RestTemplate restTemplate = builder.build();
        try{
            RequestProductDto dto  = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", RequestProductDto.class,id).getBody();
         //   dto.setId(p.getId());
            dto.setTitle(p.getName());
            dto.setDescription(p.getDescription());
            dto.setImage(p.getImageUrl());
            dto.setPrice(p.getPrice());
            return true;
        }catch(HttpClientErrorException ex){
            return false;
        }
    }

}
