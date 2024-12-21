package org.api.productcatalogservice.inheritance.Single;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "SS_instructors")
@DiscriminatorValue("10")
public class Instructor extends User {
    private Boolean isFullTime;
    private String prevCompany;
}
