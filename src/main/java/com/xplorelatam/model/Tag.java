package com.xplorelatam.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Tag {
  @Id
  @EqualsAndHashCode.Include
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idTag;

  @Column(nullable = false, length = 30)
  private String name;

  @Column(nullable = false)
  private boolean status;
}

// lowerCamelCase
// UpperCamelCase
// snake_case
