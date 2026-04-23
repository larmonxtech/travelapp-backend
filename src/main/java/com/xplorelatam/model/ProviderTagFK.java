package com.xplorelatam.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class ProviderTagFK implements Serializable {
    @ManyToOne
    @JoinColumn(name="id_provider", nullable = false,
            foreignKey = @ForeignKey(name="FK_PROVIDERTAG_PROVIDER"))
    private Provider provider;

    @ManyToOne
    @JoinColumn(name="id_tag", nullable = false,
            foreignKey = @ForeignKey(name="FK_PROVIDERTAG_TAG"))
    private Tag tag;

    // Mas atributos
}
