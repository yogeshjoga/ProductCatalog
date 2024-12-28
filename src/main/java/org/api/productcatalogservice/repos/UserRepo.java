package org.api.productcatalogservice.repos;

import org.api.productcatalogservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

     User findByUsernameAndPassword(String username, String password);
     Optional<User> findByUsername(String username);
     User findById(UUID userId);
     User deleteById(UUID userId);

     // Parameter Placeholder Reference
     @Query("SELECT u.username from users u where u.id = ?1")
     String findUserName(UUID userId);


     // Named Placeholder Reference
     @Query("SELECT u.password from users u where u.id = :userId and u.username = : username")
     String findUser(UUID userId, String username);
}