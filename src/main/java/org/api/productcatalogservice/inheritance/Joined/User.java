package org.api.productcatalogservice.inheritance.Joined;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity(name ="AT_users")
// Inheritance
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    private UUID id;
    private String name;
    private String email;
    private String phone;
}
