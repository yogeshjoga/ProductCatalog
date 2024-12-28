package org.api.productcatalogservice.services;


import org.api.productcatalogservice.dtos.RequestUserDTO;
import org.api.productcatalogservice.dtos.ResponseUserDTO;
import org.api.productcatalogservice.models.User;

import java.util.List;
import java.util.UUID;

public interface IUserService {
     boolean login(String username, String password);
     boolean register(String username, String password);
     List<User> getAllUsers();
     User saveUser(RequestUserDTO user);
     User getUsernameAndPassword(String username, String password);
     ResponseUserDTO updateUser(RequestUserDTO dto);
     User getUserById(UUID id);
     ResponseUserDTO deleteUser(UUID id);

}
