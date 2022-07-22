package com.web.finances.api.controller;

import com.web.finances.api.dto.PatrimonyDTO;
import com.web.finances.domain.model.Patrimony;
import com.web.finances.domain.service.PatrimonyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patrimony")
public class PatrimonyController {
    @Autowired
    PatrimonyService service;

    @GetMapping
    public List<PatrimonyDTO> listAll(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatrimonyDTO> listById(@PathVariable Long id){
        return service.listById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<PatrimonyDTO> create(@RequestBody Patrimony patrimony) {
        return service.create(patrimony);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<PatrimonyDTO> update(@RequestBody Patrimony patrimony) {
        return service.update(patrimony);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<PatrimonyDTO> findById(@PathVariable Long id) {
        return service.findById(id);
    }
}

