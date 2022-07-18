package com.web.finances.api.controller;

import com.web.finances.api.dto.TreasuryDTO;
import com.web.finances.domain.model.Treasury;
import com.web.finances.domain.service.TreasuryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ProductsController {


    @Autowired
    TreasuryService service;

    @GetMapping
    public List<TreasuryDTO> listAll(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreasuryDTO> listById(@PathVariable Long id){
        return service.listById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<TreasuryDTO> create(@RequestBody Treasury treasury) {
        return service.create(treasury);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<TreasuryDTO> update(@RequestBody  Treasury treasury) {
        return service.update(treasury);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<TreasuryDTO> findById(@PathVariable Long id) {
        return service.findById(id);
    }



}
