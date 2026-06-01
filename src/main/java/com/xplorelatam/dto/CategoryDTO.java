package com.xplorelatam.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private Integer idCategory;

    @NotNull
    //@NotBlank
    //@NotEmpty
    @Size(min=3, max=70, message = "El nombre no puede ser menor a 5 caracteres  ni  mayor a 50 caracteres")
    private String name;

    @NotNull
    // @Pattern(regexp = "\\d{9}", message="El teléfono solo permite valores numéricos")
    private String description;

    @NotNull
    // @Email
    private boolean status;

    // Numericos
    //@Max(120)
    //@Min(3)
}
