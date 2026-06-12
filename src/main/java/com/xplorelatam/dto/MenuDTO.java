package com.xplorelatam.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuDTO {
    private Integer idMenu;

    @NotNull
    private String icon;

    @NotNull
    private String name;

    @NotNull
    private String url;
}
