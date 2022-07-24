package com.web.finances.api.controller;

import com.web.finances.api.dto.PaymentFormDTO;
import com.web.finances.api.dto.PayrollDTO;
import com.web.finances.domain.model.PaymentForm;
import com.web.finances.domain.model.Payroll;
import com.web.finances.domain.service.PaymentFormService;
import com.web.finances.domain.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class PayrollController {

    @Autowired
    PayrollService service;

    @GetMapping
    public List<PayrollDTO> listAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PayrollDTO> listById(@PathVariable Long id) {
        return service.listById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<PayrollDTO> create(@RequestBody Payroll pay) {
        return service.create(pay);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<PayrollDTO> update(@RequestBody Payroll pay) {
        return service.update(pay);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<PayrollDTO> findById(@PathVariable Long id) {
        return service.findById(id);
    }

}
