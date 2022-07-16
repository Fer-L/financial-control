package com.web.finances.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.web.finances.domain.model.PaymentForm;
import com.web.finances.domain.service.PaymentFormService;
import com.web.finances.api.dto.PaymentFormDTO;

@RestController
@RequestMapping("/payment-form")
public class PaymentFormController {
    @Autowired
    PaymentFormService service;

    @GetMapping
    public List<PaymentFormDTO> listAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentFormDTO> listById(@PathVariable Long id) {
        return service.listById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<PaymentFormDTO> create(@RequestBody PaymentForm paymentForm) {
        return service.create(paymentForm);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<PaymentFormDTO> update(@RequestBody PaymentForm paymentForm) {
        return service.update(paymentForm);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<PaymentFormDTO> findById(@PathVariable Long id) {
        return service.findById(id);
    }

}
