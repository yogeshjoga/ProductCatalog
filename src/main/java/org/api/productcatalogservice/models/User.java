package org.api.productcatalogservice.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "users")
public class User extends BaseModel {
    @Column(unique = true, nullable = false)
    private String username;
    private String password;
}
