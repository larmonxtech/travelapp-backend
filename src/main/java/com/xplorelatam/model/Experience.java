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
public class Experience {
  @Id
  @EqualsAndHashCode.Include
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idExperience;

  @ManyToOne // FK
  @JoinColumn(name="id_category", nullable = false,
    foreignKey = @ForeignKey(name="FK_EXPERIENCE_CATEGORY"))
  private Category category;

  @Column(nullable = false, length = 150)
  private String name;

  @Column(nullable = false, length = 255)
  private String description;

  @Column(nullable = false, length = 255)
  private String coverPhotoUrl;

  @Column(nullable = false)
  private Double durationHours;

  @Column(nullable = false)
  private Integer maxCapacity;

  @Column(nullable = false)
  private Double unitPrice;

  @Column(nullable = false)
  private String experienceType;

  @Column(nullable=false)
  private boolean status;
}
