package org.api.productcatalogservice.inheritance.Single;


import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "SS_mentors")
@DiscriminatorValue("20")
public class Mentor extends User {
    private Boolean  isFullTime;
    private String  prevCompany;
}
