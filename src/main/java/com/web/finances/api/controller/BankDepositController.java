package com.web.finances.api.controller;

import com.web.finances.api.dto.BankDepositDTO;
import com.web.finances.domain.model.BankDeposit;
import com.web.finances.domain.service.BankDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank-deposit")
public class BankDepositController {
    @Autowired
    BankDepositService service;

    @GetMapping
    public List<BankDepositDTO> listAll(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankDepositDTO> listById(@PathVariable Long id){
        return service.listById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<BankDepositDTO> create(@RequestBody BankDeposit products) {
        return service.create(
                products
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<BankDepositDTO> update(@RequestBody  BankDeposit products) {
        return service.update(products);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<BankDepositDTO> findById(@PathVariable Long id) {
        return service.findById(id);
    }

}
