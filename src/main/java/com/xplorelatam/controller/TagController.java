package com.xplorelatam.controller;

import com.xplorelatam.dto.TagDTO;
import com.xplorelatam.model.Tag;
import com.xplorelatam.service.ITagService;
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
@RequestMapping("/tags")
@RequiredArgsConstructor
// @CrossOrigin(origins = "*")
public class TagController {

    private final ITagService service;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<TagDTO>> findAll() throws Exception {
        List<TagDTO> list = service.findAll().stream().map(e -> modelMapper.map(e, TagDTO.class)).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TagDTO> findById(@PathVariable("id") Integer id) throws Exception {
        Tag obj = service.findById(id);
        return ResponseEntity.ok(modelMapper.map(obj, TagDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody TagDTO dto) throws Exception {
        Tag obj = service.save(modelMapper.map(dto, Tag.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdTag()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TagDTO> update(@Valid @RequestBody TagDTO dto, @PathVariable("id") Integer id) throws Exception {
        Tag obj = service.update(modelMapper.map(dto, Tag.class), id);
        return ResponseEntity.ok(modelMapper.map(obj, TagDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/hateoas/{id}")
    public EntityModel<TagDTO> findByIdHateoas(@PathVariable Integer id) throws Exception {
        Tag obj = service.findById(id);
        EntityModel<TagDTO> entityModel = EntityModel.of(modelMapper.map(obj, TagDTO.class));

        WebMvcLinkBuilder link1 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TagController.class).findById(id));
        WebMvcLinkBuilder link2 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TagController.class).findAll());
        WebMvcLinkBuilder link3 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CategoryController.class).findAll());
        WebMvcLinkBuilder link4 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ReviewController.class).findAll());

        entityModel.add(link1.withRel("tag-self-info"));
        entityModel.add(link2.withRel("tag-all-info"));
        entityModel.add(link3.withRel("category-all-info"));
        entityModel.add(link4.withRel("review-all-info"));

        return entityModel;
    }
}
