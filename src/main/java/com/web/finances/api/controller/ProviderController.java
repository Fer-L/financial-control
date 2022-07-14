package com.web.finances.api.controller;

import com.web.finances.api.dto.ProviderDTO;
import com.web.finances.domain.model.Provider;
import com.web.finances.domain.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/provider")
public class ProviderController {

    @Autowired
    ProviderService service;

    @GetMapping
    public List<ProviderDTO> listAll(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProviderDTO> listById(@PathVariable Long id){
        return service.listById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<ProviderDTO> create(@RequestBody Provider provider) {
        return service.create(provider);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<ProviderDTO> update(@RequestBody Provider provider) {
        return service.update(provider);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<ProviderDTO> findById(@PathVariable Long id) {
        return service.findById(id);
    }

}
