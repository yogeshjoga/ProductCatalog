package org.api.productcatalogservice.inheritance.Joined;


import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "AT_mentors")
// Inhertiance join
@PrimaryKeyJoinColumn(name = "user_id")
public class Mentor extends User {
    private Boolean  isFullTime;
    private String  prevCompany;
}
