package org.api.productcatalogservice.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.api.productcatalogservice.dtos.RequestUserDTO;
import org.api.productcatalogservice.dtos.ResponseUserDTO;
import org.api.productcatalogservice.exceptions.AlreadyUserNamePresent;
import org.api.productcatalogservice.models.User;
import org.api.productcatalogservice.repos.UserRepo;
import org.api.productcatalogservice.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("US")
@Primary
public class UserService implements IUserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserUtils userUtils;


    private static final Logger logger = LogManager.getLogger(UserService.class);




    @Override
    public User getUserById(UUID id){
        logger.info("getUserById");
        return userRepo.findById(id);
    }


    @Override
    public boolean login(String username, String password) {
        logger.info("Username : " + username + " Password : " + password);
        return false;
    }


    @Override
    public boolean register(String username, String password) {
        logger.info("Username : " + username + " Password : " + password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setTitle("hello the world");
        user.setDescription("hello the world");
        // user.setId(new UUID);
        userRepo.save(new User());
        return false;
    }


    @Override
    public List<User> getAllUsers() {
        logger.info( "Get all Users ", userRepo.findAll() );
        return userRepo.findAll();
    }


    @Override
    public User saveUser(RequestUserDTO user) {
        logger.info( "Save User ", user );

        if(userRepo.findByUsername(user.getUsername()).isPresent()) {
            throw new AlreadyUserNamePresent("Already this username was taken please try again");
        }
        User newUser = userUtils.getUser(user,null);
        userRepo.save(newUser);
        return newUser;
    }


    @Override
    public User getUsernameAndPassword(String username, String password) {
        User user = userRepo.findByUsernameAndPassword(username, password);
        if(user != null) {
            return user;
        }
        return null;
    }


    @Override
    public ResponseUserDTO updateUser(RequestUserDTO dto) {
        logger.info( "Update User ", dto );
        User user = getUsernameAndPassword(dto.getUsername(), dto.getPassword());
        if(user == null) {
            logger.warn("User not found");
            return null;
        }
        logger.info( "Update User ", user );
        if(user.getId() != null){
            return userUtils.getUserDTO(userRepo.save(userUtils.getUser(dto, user)));
        }
        return null;
    }

    @Override
    public ResponseUserDTO deleteUser(UUID id){
        User user = userRepo.findById(id);
        return userUtils.getUserDTO(user);
    }





}
