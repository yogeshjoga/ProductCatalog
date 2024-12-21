package org.api.productcatalogservice.repos;


import org.api.productcatalogservice.models.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepo extends JpaRepository<Mentor, Integer> {
}
