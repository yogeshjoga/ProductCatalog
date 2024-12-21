package org.api.productcatalogservice.inheritance.InheritanceTable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "IN_Tas")
public class Ta extends User {
    private Boolean isFullTime;
}
