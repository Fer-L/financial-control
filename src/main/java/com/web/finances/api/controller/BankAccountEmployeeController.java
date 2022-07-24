package com.web.finances.api.controller;

import com.web.finances.api.dto.BankAccountEmployeeDTO;
import com.web.finances.domain.model.BankAccountEmployee;
import com.web.finances.domain.service.BankAccountEmployeeService;
import com.web.finances.domain.repository.BankAccountEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bankaccountemployee")
public class BankAccountEmployeeController {
    @Autowired
    BankAccountEmployeeService service;

    @GetMapping
    public List<BankAccountEmployeeDTO> listAll(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankAccountEmployeeDTO> listById(@PathVariable Long id){
        return service.listById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<BankAccountEmployeeDTO> create(@RequestBody BankAccountEmployee bankAccount) {
        return service.create(bankAccount);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<BankAccountEmployeeDTO> update(@RequestBody BankAccountEmployee bankAccount) {
        return service.update(bankAccount);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<BankAccountEmployeeDTO> findById(@PathVariable Long id) {
        return service.findById(id);
    }
}
