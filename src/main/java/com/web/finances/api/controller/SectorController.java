package com.web.finances.api.controller;

import com.web.finances.api.dto.SectorDTO;
import com.web.finances.domain.model.Sector;
import com.web.finances.domain.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sector")
public class SectorController {
    @Autowired
    SectorService service;

    @GetMapping
    public List<SectorDTO> listAll(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SectorDTO> listById(@PathVariable Long id){
        return service.listById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<SectorDTO> create(@RequestBody Sector products) {
        return service.create(
                products
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<SectorDTO> update(@RequestBody  Sector products) {
        return service.update(products);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<SectorDTO> findById(@PathVariable Long id) {
        return service.findById(id);
    }

}
