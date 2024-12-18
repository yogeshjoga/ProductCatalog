package org.api.productcatalogservice.repo;

import org.api.productcatalogservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unused")
public interface ProductRepository extends JpaRepository<Product, Long> {

}
