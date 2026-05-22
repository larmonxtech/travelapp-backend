package com.xplorelatam.controller;

import com.xplorelatam.model.Tag;
import com.xplorelatam.service.ITagService;
import lombok.RequiredArgsConstructor;
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

    @GetMapping // GET, POST, PUT, DELETE
    public ResponseEntity<List<Tag>> findAll() throws Exception{
        List<Tag> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tag> findById(@PathVariable("id") Integer id) throws Exception{
        Tag obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Tag tag) throws Exception{
        Tag obj = service.save(tag);
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
}
