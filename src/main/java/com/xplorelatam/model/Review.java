package com.xplorelatam.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idReview;

    @ManyToOne
    @JoinColumn(name = "id_traveler", nullable = false, foreignKey = @ForeignKey(name="FK_REVIEW_TRAVELER"))
    private Traveler traveler;

    @ManyToOne
    @JoinColumn(name = "id_provider", nullable = false, foreignKey = @ForeignKey(name="FK_REVIEW_PROVIDER"))
    private Provider provider;

    @ManyToOne
    @JoinColumn(name = "id_booking", nullable = false, foreignKey = @ForeignKey(name="FK_REVIEW_BOOKING"))
    private Booking booking;

    @Column(nullable = false)
    private Integer rating;

    @Column(length = 500)
    private String comment;

    @Column(nullable = false)
    private LocalDateTime reviewDate;

    @Column(nullable = false, length = 20)
    private String status;
}