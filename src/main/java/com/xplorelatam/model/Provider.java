package com.xplorelatam.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Provider {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProvider;

    @Column(nullable = false, length = 100)
    private String business_name;

    @Column(nullable = false, length = 50)
    private String tagline;

    @Column(nullable = false, length = 255)
    private String description;

    @Column(nullable = false, length = 20)
    private String phone;

    @Column(length = 20)
    private String whatsapp;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(length = 150)
    private String website;

    @Column(nullable = false, length = 255)
    private String address;

    @Column(precision = 10, scale = 7)
    private BigDecimal latitude;

    @Column(precision = 10, scale = 7)
    private BigDecimal longitude;

    @Column(length = 255)
    private String coverPhotoUrl;

    @Column(length = 255)
    private String profilePhotoUrl;

    @Column(length = 255)
    private String openingHours;

    @Column(length = 50)
    private String priceRange;

    @Column(precision = 3, scale = 2)
    private BigDecimal avgRating;

    @Column(nullable = false, length = 20)
    private String verificationStatus;

    @Column(nullable = false)
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false, foreignKey = @ForeignKey(name="FK_PROVIDER_USER"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false, foreignKey = @ForeignKey(name="FK_PROVIDER_CATEGORY"))
    private Category category;
}
