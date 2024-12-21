package org.api.productcatalogservice.inheritance.AllTable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "AT_Tas")
public class Ta extends User {
    private Boolean isFullTime;
}
