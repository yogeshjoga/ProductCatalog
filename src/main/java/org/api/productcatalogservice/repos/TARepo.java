package org.api.productcatalogservice.repos;

import org.api.productcatalogservice.models.TA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TARepo extends JpaRepository<TA, Integer> {
}
