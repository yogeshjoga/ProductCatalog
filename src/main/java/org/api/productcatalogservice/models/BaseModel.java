package org.api.productcatalogservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseModel {
   @Id
   @GeneratedValue(generator = "UUID")
   private UUID id;
   private String title;
   private String description;
   private String imageUrl;
   @CreationTimestamp
   private Date createdAt;
   @UpdateTimestamp
   private Date updatedAt;
}
