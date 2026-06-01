package com.xplorelatam.controller;

import com.xplorelatam.dto.CategoryDTO;
import com.xplorelatam.dto.TagDTO;
import com.xplorelatam.model.Category;
import com.xplorelatam.model.Tag;
import com.xplorelatam.service.ITagService;
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
    @Qualifier("tagMapper")
    private final ModelMapper modelMapper;

    @GetMapping // GET, POST, PUT, DELETE
    public ResponseEntity<List<TagDTO>> findAll() throws Exception{
        // List<Tag> list = service.findAll();
        List<TagDTO> list = service.findAll().stream().map(e -> modelMapper.map(e, TagDTO.class)).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tag> findById(@PathVariable("id") Integer id) throws Exception{
        Tag obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody TagDTO dto) throws Exception{
        // Tag obj = service.save(tag);
        Tag obj = service.save(modelMapper.map(dto, Tag.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdTag()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tag> update(@RequestBody Tag tag, @PathVariable("id") Integer id) throws Exception{
        Tag obj = service.update(tag, id);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/hateoas/{id}")
    public EntityModel<Tag> findByIdHateoas(@PathVariable Integer id) throws Exception{
        Tag obj = service.findById(id);
        EntityModel<Tag> entityModel = EntityModel.of(obj);

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
