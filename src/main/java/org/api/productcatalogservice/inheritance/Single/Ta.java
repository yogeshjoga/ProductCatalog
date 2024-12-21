package org.api.productcatalogservice.inheritance.Single;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "SS_Tas")
@DiscriminatorValue("30")
public class Ta extends User {
    private Boolean isFullTime;
}
