package com.xplorelatam.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagDTO {
    private Integer idTag;

    @NotNull
    private String nombreEtiqueta;

    @NotNull
    private Boolean estadoEtiqueta;
}
