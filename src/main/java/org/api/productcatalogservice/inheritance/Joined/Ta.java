package org.api.productcatalogservice.inheritance.Joined;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "AT_Tas")
// Inhertiance based on primary
@PrimaryKeyJoinColumn(name ="user_id")
public class Ta extends User {
    private Boolean isFullTime;
}
