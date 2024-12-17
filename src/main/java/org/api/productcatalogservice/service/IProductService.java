package org.api.productcatalogservice.service;

import org.api.productcatalogservice.model.Product;

public interface IProductService {
    public Product getProductById(Long id);
    public boolean isProductExist(Long id, Product product);
}
