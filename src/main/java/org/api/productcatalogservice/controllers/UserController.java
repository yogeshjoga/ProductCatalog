package org.api.productcatalogservice.controllers;



import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.api.productcatalogservice.dtos.RequestUserDTO;
import org.api.productcatalogservice.dtos.ResponseUserDTO;
import org.api.productcatalogservice.exceptions.PasswordFeildEmpty;
import org.api.productcatalogservice.exceptions.UserNotFoundException;
import org.api.productcatalogservice.models.User;
import org.api.productcatalogservice.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;
import java.util.UUID;

/**
 * @author yogeshjoga
 */

@RestController
@RequestMapping("/user/api/v1/")
public class UserController {

    @Autowired
    IUserService userService;

    @Autowired
    @Qualifier("USE")
    IUserService userService1;

    private static final Logger logger = LogManager.getLogger(UserController.class);

    private MultiValueMap<String, String> headers;


    /**
     *
     * @param id
     * @param response
     * @return <b>Returning ResponseEntity UserResponseDto </b>
     */

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable UUID id, HttpServletResponse response) {
        // Cookie management
        Cookie cookie = new Cookie("JSESSIONID", id.toString());
        cookie.setMaxAge(3600);
      //  cookie.setHttpOnly(true);
     //   cookie.setSecure(true);
        response.addCookie(cookie);

        // header management
        headers = new LinkedMultiValueMap<>();
        headers.add("Accept", "application/json");
        logger.info("------------------------------------------------------------------------------------------------");
        logger.info("----------------   Get user with id   ----------------------------->  " + id);
        logger.info("------------------------------------------------------------------------------------------------");
        headers.add("Responce Testing","true");

        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, headers, HttpStatus.OK);
    }


    /**
     * @return <b>ResponseEntity List of UserResponseDto </b>
     */
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        headers = new LinkedMultiValueMap<>();
        headers.add("Accept", "application/json");
        headers.add("Responce Testing","true");
        headers.add("Content-Type", "application/json");
        headers.add("User-Agent", "Mozilla/5.0");
        logger.info("Get all users");
        return new ResponseEntity<>(userService.getAllUsers(), headers, HttpStatus.OK);
    }


    /**
     *
     * @param dto
     * @return <b>ResponseEntity UserResponseDto </b>
     */
    @PostMapping("/new_user")
    public ResponseEntity<User> createUser(@RequestBody RequestUserDTO dto) {
        User user = userService.saveUser(dto);
        logger.info("New user created");
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }


    /**
     * followed all rules
     *
     * @param username
     * @param password
     * @return <b>ResponseEntity UserResponseDto</b>
     */
    @GetMapping("/user/auth/{user}/{pass}")
    public ResponseEntity<ResponseUserDTO> getUserByUsernameAndPassword(@PathVariable("user") String username, @PathVariable("pass") String password) {
        headers = new LinkedMultiValueMap<>();
        ResponseUserDTO dto = new ResponseUserDTO();
        if(username == null){
            logger.info("Username is null");
            throw new UserNotFoundException("Username is null");
        }
        if(password == null){
            logger.info("Password is null");
            throw new PasswordFeildEmpty("Password is null");
        }
        User user = userService.getUsernameAndPassword(username, password);
        if(user == null) {
             throw new UserNotFoundException("user not found");
        }
        logger.info("Get user by username " + username + " and password " + password);
        if (user != null) {
            dto.setUsername(user.getUsername());
            dto.setId(user.getId());
            dto.setDescription(user.getDescription());
            dto.setCreatedAt(user.getCreatedAt());
            dto.setImageUrl(user.getImageUrl());
            dto.setUpdatedAt(user.getUpdatedAt());
            dto.setTitle(user.getTitle());
            headers.add("Response Testing","true");
            headers.add("Accept", "application/json");
            headers.add("Content-Type", "application/json");
            headers.add("User-Agent", "Mozilla/5.0");
            logger.info("Get user by username " + username + " and password " + password);
            return new ResponseEntity<>(dto,headers, HttpStatus.OK);
        }
      return new ResponseEntity<>(null, headers, HttpStatus.BAD_REQUEST);
    }


    /**
     *
     * @param dto
     * @return <b> ResponseEntity UserResponseDto</b>
     */
    @PatchMapping("/patch")
    public ResponseEntity<ResponseUserDTO> updateUser(@RequestBody RequestUserDTO dto) {
        logger.info("Update user");
        headers = new LinkedMultiValueMap<>();
        if(dto.getUsername() == null){
            logger.info("Username is null");
            throw new UserNotFoundException("Username is null");
        }
        if(dto.getPassword() == null){
            logger.info("Password is null");
            throw new PasswordFeildEmpty("Password is null");
        }
      //  User user = userService.getUsernameAndPassword(dto.getUsername(), dto.getPassword());
        headers.add("Responce Testing","true");
        ResponseUserDTO responseUserDTO =  userService.updateUser(dto);
        return new ResponseEntity<>(responseUserDTO, headers, HttpStatus.OK);
    }


    /**
     *
     * @param id
     * @param response
     * @return <b>ResponseEntity ResponseUserDTO with Cookies</b>
     */
    @DeleteMapping("/delete_user/{id}")
    public ResponseEntity<ResponseUserDTO> deleteUser(@PathVariable UUID id, HttpServletResponse response) {
        // Handling Cookies
        Cookie cookie = new Cookie("JSESSIONID", id.toString());
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        response.addCookie(cookie);

        logger.info("Delete user");
        // Handling Headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/json");
        headers.add("User-Agent", "Mozilla/5.0");
        logger.info("calling UserRepo deleteUser");
        ResponseUserDTO dto = userService.deleteUser(id);
        // use this type of response
        return ResponseEntity.ok().headers(headers).body(dto);
    }

    /**
     * Testing the API, @Qualifier @Primary annotations testing
     * @return
     */

    @GetMapping("/yogi")
    public ResponseEntity<String> deleteUserById() {
        logger.info("Delete user");
        userService1.login("admin", "admin");
        logger.info("Delete user");
        return ResponseEntity.status(HttpStatus.OK).body("yogesh api get the user ");
    }




}
