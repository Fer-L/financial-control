package com.web.finances.api.controller;

import com.web.finances.api.dto.TaxDTO;
import com.web.finances.domain.model.Tax;
import com.web.finances.domain.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tax")
public class TaxController {
    @Autowired
    TaxService service;

    @GetMapping
    public List<TaxDTO> listAll(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaxDTO> listById(@PathVariable Long id){
        return service.listById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<TaxDTO> create(@RequestBody Tax tax) {
        return service.create(
                tax
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<TaxDTO> update(@RequestBody  Tax tax) {
        return service.update(tax);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<TaxDTO> findById(@PathVariable Long id) {
        return service.findById(id);
    }

}
