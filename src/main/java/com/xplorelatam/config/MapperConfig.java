package com.xplorelatam.config;

import com.xplorelatam.dto.ExperienceDTO;
import com.xplorelatam.dto.TagDTO;
import com.xplorelatam.model.Experience;
import com.xplorelatam.model.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper defaultMapper() {
        return new ModelMapper();
    }

    @Bean
    public ModelMapper experienceMapper(){
        ModelMapper mapper = new ModelMapper();

        // LECTURA: get
        mapper.createTypeMap(Experience.class, ExperienceDTO.class)
                .addMapping(Experience::getDurationHours, ExperienceDTO::setDuracionHoras)
                .addMapping(Experience::getUnitPrice, ExperienceDTO::setPrecioUnitario)
                .addMapping(Experience::getStatus, ExperienceDTO::setEstado);

        // ESCRITURA: post, put
        mapper.createTypeMap(ExperienceDTO.class, Experience.class)
                .addMapping(ExperienceDTO::getDuracionHoras, Experience::setDurationHours)
                .addMapping(ExperienceDTO::getPrecioUnitario, Experience::setUnitPrice)
                .addMapping(ExperienceDTO::getEstado, Experience::setStatus);

        return mapper;
    }

}
