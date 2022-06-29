package com.web.finances.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.web.finances.domain.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.web.finances.api.dto.CompanyDTO;
import com.web.finances.domain.model.Company;

import com.web.finances.domain.repository.CompanyRepository;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService service;

    @GetMapping
    public List<CompanyDTO> listAll(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDTO> listById(@PathVariable Long id){
        return service.listById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<CompanyDTO> create(@RequestBody Company company) {
        return service.create(company);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<CompanyDTO> update(@RequestBody Company company) {
        return service.update(company);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<CompanyDTO> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    // @PostMapping
    // public ResponseEntity<Object> autenticarUsuario(@RequestBody CompanyDTO company) {
    //     System.out.println(company.getId());

    //     Optional<Company> _Company = rep.findById(company.getId());
    //     return ResponseEntity.ok(_Company);

    // }
}
