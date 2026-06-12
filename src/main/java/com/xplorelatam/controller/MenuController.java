package com.xplorelatam.controller;

import com.xplorelatam.dto.MenuDTO;
import com.xplorelatam.model.Menu;
import com.xplorelatam.service.IMenuService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/menus")
@RequiredArgsConstructor
public class MenuController {

    private final IMenuService service;
    @Qualifier("defaultMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<Menu>> findAll() throws Exception {
        List<Menu> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> findById(@PathVariable("id") Integer id) throws Exception {
        Menu obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Menu menu) throws Exception {
        Menu obj = service.save(menu);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdMenu()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Menu> update(@RequestBody Menu menu, @PathVariable("id") Integer id) throws Exception {
        Menu obj = service.update(menu, id);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/user")
    public ResponseEntity<List<MenuDTO>> getMenusByUser(){
        List<MenuDTO> menus = service.getMenusByUsername().stream().map(e -> mapper.map(e, MenuDTO.class)).toList();
        return ResponseEntity.ok(menus);
    }
}
