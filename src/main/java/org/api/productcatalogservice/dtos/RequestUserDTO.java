package org.api.productcatalogservice.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Getter
@Setter
@Component
public class RequestUserDTO {
    private String username;
    private String password;
    private String description;
    private String imageUrl;
    private String title;
}
