package com.web.finances.api.controller;

import com.web.finances.api.dto.LawDTO;
import com.web.finances.domain.model.Law;
import com.web.finances.domain.service.LawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/law")
public class LawController {
    @Autowired
    LawService service;

    @GetMapping
    public List<LawDTO> listAll(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LawDTO> listById(@PathVariable Long id){
        return service.listById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<LawDTO> create(@RequestBody Law law) {
        return service.create(law);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<LawDTO> update(@RequestBody Law law) {
        return service.update(law);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<LawDTO> findById(@PathVariable Long id) {
        return service.findById(id);
    }
}

