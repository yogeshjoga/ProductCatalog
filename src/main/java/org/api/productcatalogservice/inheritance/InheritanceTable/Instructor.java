package org.api.productcatalogservice.inheritance.InheritanceTable;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "AT_instructors")
public class Instructor extends User {
    private Boolean isFullTime;
    private String prevCompany;
}
