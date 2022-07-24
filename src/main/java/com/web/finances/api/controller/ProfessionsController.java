package com.web.finances.api.controller;

import com.web.finances.api.dto.ProfessionsDTO;
import com.web.finances.domain.model.Professions;
import com.web.finances.domain.service.ProfessionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Professions")
public class ProfessionsController {
    @Autowired
    ProfessionsService service;

    @GetMapping
    public List<ProfessionsDTO> listAll(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessionsDTO> listById(@PathVariable Long id){
        return service.listById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<ProfessionsDTO> create(@RequestBody Professions profession) {
        return service.create(
                profession
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<ProfessionsDTO> update(@RequestBody  Professions profession) {
        return service.update(profession);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<ProfessionsDTO> findById(@PathVariable Long id) {
        return service.findById(id);
    }

}
