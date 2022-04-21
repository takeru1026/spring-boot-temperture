package com.example.temperture.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
// import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Temperture {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(updatable = false, nullable = false)
  Long id;

  @Column
  Double degree;

  @Column
  String description;

  @Column
  TempertureStatus tempertureStatus;

  @CreationTimestamp
  @Column(updatable = false)
  Timestamp dateCreated;

  @UpdateTimestamp
  Timestamp lastModified;


}
