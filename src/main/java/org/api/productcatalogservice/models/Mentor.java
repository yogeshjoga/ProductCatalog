package org.api.productcatalogservice.models;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.api.productcatalogservice.models.consts.MENTOR_TYPE;

@Setter
@Getter
@Entity(name = "mentors")
public class Mentor extends  BaseModel{
    @Enumerated(EnumType.STRING)
    private MENTOR_TYPE mentorType;
}