package com.xplorelatam.config;

import com.xplorelatam.dto.TagDTO;
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
    public ModelMapper tagMapper(){
        ModelMapper mapper = new ModelMapper();

        // LECTURA: get
        mapper.createTypeMap(Tag.class, TagDTO.class)
                .addMapping(Tag::getName, TagDTO::setNombreEtiqueta)
                .addMapping(Tag::getStatus, TagDTO::setEstadoEtiqueta);

        // ESCRITURA: post, put
        mapper.createTypeMap(TagDTO.class, Tag.class)
                .addMapping(TagDTO::getNombreEtiqueta, Tag::setName)
                .addMapping(TagDTO::getEstadoEtiqueta, Tag::setStatus);

        return mapper;
    }

}
