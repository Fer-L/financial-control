package com.web.finances.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.web.finances.domain.model.Bank;
import com.web.finances.domain.service.BankService;
import com.web.finances.api.dto.BankDTO;

@RestController
@RequestMapping("/bank")
public class BankController {
    @Autowired
    BankService service;

    @GetMapping
    public List<BankDTO> listAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankDTO> listById(@PathVariable Long id) {
        return service.listById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<BankDTO> create(@RequestBody Bank bank) {
        return service.create( bank);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<BankDTO> update(@RequestBody Bank bank) {
        return service.update(bank);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<BankDTO> findById(@PathVariable Long id) {
        return service.findById(id);
    }

}


