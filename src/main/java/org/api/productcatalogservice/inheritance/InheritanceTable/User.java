package org.api.productcatalogservice.inheritance.InheritanceTable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity(name ="AT_users")
// Inheritance
@MappedSuperclass
public class User {
    @Id
    private UUID id;
    private String name;
    private String email;
    private String phone;
}
