package com.xplorelatam.controller;

import com.xplorelatam.model.Traveler;
import com.xplorelatam.service.ITravelerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/travelers")
@RequiredArgsConstructor
public class TravelerController {

    private final ITravelerService service;

    @GetMapping
    public ResponseEntity<List<Traveler>> findAll() throws Exception {
        List<Traveler> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Traveler> findById(@PathVariable("id") Integer id) throws Exception {
        Traveler obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Traveler traveler) throws Exception {
        Traveler obj = service.save(traveler);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdTraveler()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Traveler> update(@RequestBody Traveler traveler, @PathVariable("id") Integer id) throws Exception {
        Traveler obj = service.update(traveler, id);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
