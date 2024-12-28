package org.api.productcatalogservice.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.api.productcatalogservice.dtos.RequestUserDTO;
import org.api.productcatalogservice.dtos.ResponseUserDTO;
import org.api.productcatalogservice.models.User;
import org.api.productcatalogservice.repos.UserRepo;
import org.api.productcatalogservice.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("USE")
public class UserServiceEmb implements IUserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserUtils userUtils;

    private static final Logger logger = LogManager.getLogger(UserServiceEmb.class);


    @Override
    public boolean login(String username, String password) {
        logger.info("Login attempt");
        logger.info(username);
        logger.info(password);
        return true;
    }

    @Override
    public boolean register(String username, String password) {
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }

    @Override
    public User saveUser(RequestUserDTO user) {
        return null;
    }

    @Override
    public User getUsernameAndPassword(String username, String password) {
        return null;
    }

    @Override
    public ResponseUserDTO updateUser(RequestUserDTO dto) {
        return null;
    }

    @Override
    public User getUserById(UUID id) {
        return null;
    }

    @Override
    public ResponseUserDTO deleteUser(UUID id) {
        return null;
    }
}
