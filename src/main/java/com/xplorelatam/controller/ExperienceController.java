package com.xplorelatam.controller;

import com.xplorelatam.dto.ExperienceDTO;
import com.xplorelatam.model.Experience;
import com.xplorelatam.service.IExperienceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/experiences")
@RequiredArgsConstructor
public class ExperienceController {

    private final IExperienceService service;

    @Qualifier("experienceMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ExperienceDTO>> findAll() throws Exception {
        List<ExperienceDTO> list = service.findAll().stream().map(e -> modelMapper.map(e, ExperienceDTO.class)).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExperienceDTO> findById(@PathVariable("id") Integer id) throws Exception {
        Experience obj = service.findById(id);
        return ResponseEntity.ok(modelMapper.map(obj, ExperienceDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ExperienceDTO dto) throws Exception {
        Experience obj = service.save(modelMapper.map(dto, Experience.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdExperience()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExperienceDTO> update(@Valid @RequestBody ExperienceDTO dto, @PathVariable("id") Integer id) throws Exception {
        Experience obj = service.update(modelMapper.map(dto, Experience.class), id);
        return ResponseEntity.ok(modelMapper.map(obj, ExperienceDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/hateoas/{id}")
    public EntityModel<ExperienceDTO> findByIdHateoas(@PathVariable Integer id) throws Exception {
        Experience obj = service.findById(id);
        EntityModel<ExperienceDTO> entityModel = EntityModel.of(modelMapper.map(obj, ExperienceDTO.class));

        WebMvcLinkBuilder link1 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ExperienceController.class).findById(id));
        WebMvcLinkBuilder link2 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ExperienceController.class).findAll());

        entityModel.add(link1.withRel("experience-self-info"));
        entityModel.add(link2.withRel("experience-all-info"));

        return entityModel;
    }
}
