package org.api.productcatalogservice.models;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.api.productcatalogservice.models.consts.TA_TYPE;
import org.api.productcatalogservice.models.consts.WORK_TYPE;

@Getter
@Setter
@Entity(name = "teaching_ass")
public class TA extends  BaseModel{
    @Enumerated(EnumType.STRING)
    private TA_TYPE taType;
    @Enumerated(EnumType.STRING)
    private WORK_TYPE workType;
}
