package com.xplorelatam.controller;

import com.xplorelatam.model.Tag;
import com.xplorelatam.service.ITagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
@RequiredArgsConstructor
// @CrossOrigin(origins = "*")
public class TagController {
    private final ITagService service;

    @GetMapping // GET, POST, PUT, DELETE
    public List<Tag> findAll() throws Exception{
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Tag findById(@PathVariable("id") Integer id) throws Exception{
        return service.findById(id);
    }

    @PostMapping
    public Tag save(@RequestBody Tag tag) throws Exception{
        return service.save(tag);
    }

    @PutMapping("/{id}")
    public Tag update(@RequestBody Tag tag, @PathVariable("id") Integer id) throws Exception{
        return service.update(tag, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
    }
}
