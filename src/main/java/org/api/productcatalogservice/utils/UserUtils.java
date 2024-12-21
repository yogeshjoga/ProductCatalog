package org.api.productcatalogservice.utils;

import org.api.productcatalogservice.dtos.RequestUserDTO;
import org.api.productcatalogservice.dtos.ResponseUserDTO;
import org.api.productcatalogservice.models.User;
import org.springframework.stereotype.Component;


@Component
public class UserUtils {


    public User getUser(RequestUserDTO dto, User newUser) {
        if(newUser == null) {
            newUser = new User();
        }
        newUser.setUsername(dto.getUsername());
        newUser.setPassword(dto.getPassword());
        newUser.setTitle(dto.getTitle());
        newUser.setDescription(dto.getDescription());
        newUser.setImageUrl(dto.getImageUrl());
        return newUser;
    }

    public ResponseUserDTO getUserDTO(User user) {
        ResponseUserDTO newUser = new ResponseUserDTO();
        newUser.setUsername(user.getUsername());
        newUser.setDescription(user.getDescription());
        newUser.setImageUrl(user.getImageUrl());
        newUser.setTitle(user.getTitle());
        newUser.setId(user.getId());
        newUser.setCreatedAt(user.getCreatedAt());
        newUser.setUpdatedAt(user.getUpdatedAt());
        return newUser;
    }
}
