package com.xplorelatam.controller;

import com.xplorelatam.dto.CategoryDTO;
import com.xplorelatam.model.Category;
import com.xplorelatam.model.Tag;
import com.xplorelatam.service.ICategoryService;
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
@RequiredArgsConstructor
@RequestMapping("/categories")
// @CrossOrigin(origins = "*")
public class CategoryController {
    //@Autowired
    private final ICategoryService service;
    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;
    
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll() throws Exception {
        // ModelMapper modelMapper = new ModelMapper();
        // List<CategoryDTO> list = service.findAll().stream().map(e -> new CategoryDTO(e.getIdCategory(), e.getName(), e.getDescription(), e.getStatus())).toList();
        List<CategoryDTO> list = service.findAll().stream().map(e -> modelMapper.map(e, CategoryDTO.class)).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable Integer id) throws Exception {
        Category obj = service.findById(id);

        return ResponseEntity.ok(modelMapper.map(obj, CategoryDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody CategoryDTO dto) throws Exception {
        Category obj = service.save(modelMapper.map(dto, Category.class));

        //return new ResponseEntity<>(obj, HttpStatus.CREATED);
        //localhost:9090/categories/4
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCategory()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> update(@Valid @PathVariable Integer id, @RequestBody CategoryDTO dto) throws Exception {
        Category obj = service.update(modelMapper.map(dto, Category.class), id);

        return ResponseEntity.ok(modelMapper.map(obj, CategoryDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/hateoas/{id}")
    public EntityModel<CategoryDTO> findByIdHateoas(@PathVariable Integer id) throws Exception{
        Category obj = service.findById(id);
        EntityModel<CategoryDTO> entityModel = EntityModel.of(modelMapper.map(obj, CategoryDTO.class));

        WebMvcLinkBuilder link1 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TagController.class).findById(id));
        WebMvcLinkBuilder link2 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TagController.class).findAll());
        WebMvcLinkBuilder link3 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CategoryController.class).findAll());
        WebMvcLinkBuilder link4 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ReviewController.class).findAll());

        entityModel.add(link1.withRel("category-self-info"));
        entityModel.add(link2.withRel("category-all-info"));
        entityModel.add(link3.withRel("tag-all-info"));
        entityModel.add(link4.withRel("review-all-info"));

        return entityModel;
    }

}
