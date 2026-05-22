package com.xplorelatam.controller;

import com.xplorelatam.model.Experience;
import com.xplorelatam.service.IExperienceService;
import lombok.RequiredArgsConstructor;
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

    @GetMapping
    public ResponseEntity<List<Experience>> findAll() throws Exception {
        List<Experience> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Experience> findById(@PathVariable("id") Integer id) throws Exception {
        Experience obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Experience experience) throws Exception {
        Experience obj = service.save(experience);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdExperience()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Experience> update(@RequestBody Experience experience, @PathVariable("id") Integer id) throws Exception {
        Experience obj = service.update(experience, id);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
