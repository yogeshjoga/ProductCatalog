package org.api.productcatalogservice.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@Component
public class ResponseUserDTO {
    private UUID id;
    private String title;
    private String description;
    private String imageUrl;
    private Date createdAt;
    private Date updatedAt;
    private String username;
}
