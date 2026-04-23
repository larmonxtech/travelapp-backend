package com.xplorelatam.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idBooking;

    @Column(nullable = false, length = 50, unique = true)
    private String bookingCode;

    @ManyToOne
    @JoinColumn(name = "id_traveler", nullable = false, foreignKey = @ForeignKey(name="FK_BOOKING_TRAVELER"))
    private Traveler traveler;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false,foreignKey = @ForeignKey(name="FK_BOOKING_USER"))
    private User user;

    @Column(nullable = false)
    private LocalDateTime bookingDate;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal subtotal;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal commission;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal tax;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @Column(nullable = false, length = 20)
    private String paymentStatus;

    @Column(nullable = false, length = 20)
    private String bookingStatus;

    @Column(length = 500)
    private String notes;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookingDetail> details;
}
