package org.api.productcatalogservice.repos;


import org.api.productcatalogservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

     User findByUsernameAndPassword(String username, String password);
     Optional<User> findByUsername(String username);
}
