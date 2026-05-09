package com.xplorelatam.controller;

import com.xplorelatam.model.Category;
import com.xplorelatam.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CategoryController {
    private final ICategoryService service;

    @GetMapping // GET, POST, PUT, DELETE
    public List<Category> findAll() throws Exception{
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable("id") Integer id) throws Exception{
        return service.findById(id);
    }

    @PostMapping
    public Category save(@RequestBody Category category) throws Exception{
        return service.save(category);
    }

    @PutMapping("/{id}")
    public Category update(@RequestBody Category category, @PathVariable("id") Integer id) throws Exception{
        return service.update(category, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
    }
}
