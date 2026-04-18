package com.xplorelatam.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Provider {
  @Id
  @EqualsAndHashCode.Include
  private Integer idProvider;

  @Column(nullable = false, length = 100)
  private String business_name;

  @Column(nullable = false, length = 50)
  private String tagline;

  @Column(nullable = false, length = 255)
  private String description;
}
