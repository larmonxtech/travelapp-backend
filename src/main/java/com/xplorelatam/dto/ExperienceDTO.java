package com.xplorelatam.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceDTO {

    private Integer idExperience;

    @NotNull
    private Integer idCategory;

    @NotNull
    @Size(min = 3, max = 150)
    private String name;

    @NotNull
    @Size(min = 3, max = 255)
    private String description;

    @NotNull
    private String coverPhotoUrl;

    @NotNull
    private Double duracionHoras;

    @NotNull
    private Integer maxCapacity;

    @NotNull
    private Double precioUnitario;

    @NotNull
    private String experienceType;

    @NotNull
    private Boolean estado;
}
