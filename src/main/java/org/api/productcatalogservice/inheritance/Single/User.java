package org.api.productcatalogservice.inheritance.Single;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity(name ="SS_users")
// Inheritance
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_typ", discriminatorType = DiscriminatorType.INTEGER)
public class User {
    @Id
    private UUID id;
    private String name;
    private String email;
    private String phone;
}
