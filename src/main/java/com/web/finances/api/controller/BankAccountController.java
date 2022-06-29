package com.web.finances.api.controller;

import com.web.finances.api.dto.BankAccountDTO;
import com.web.finances.domain.model.BankAccount;
import com.web.finances.domain.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank-account")
public class BankAccountController {
    @Autowired
    BankAccountService service;

    @GetMapping
    public List<BankAccountDTO> listAll(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankAccountDTO> listById(@PathVariable Long id){
        return service.listById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<BankAccountDTO> create(@RequestBody BankAccount bankAccount) {
        return service.create(bankAccount);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<BankAccountDTO> update(@RequestBody BankAccount bankAccount) {
        return service.update(bankAccount);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<BankAccountDTO> findById(@PathVariable Long id) {
        return service.findById(id);
    }
}
