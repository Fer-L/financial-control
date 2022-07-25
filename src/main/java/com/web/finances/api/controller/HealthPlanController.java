package com.web.finances.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.web.finances.domain.model.HealthPlan;
import com.web.finances.domain.service.HealthPlanService;
import com.web.finances.api.dto.HealthPlanDTO;

@RestController
@RequestMapping("/healthplan")
public class HealthPlanController {
    @Autowired
    HealthPlanService service;

    @GetMapping
    public List<HealthPlanDTO> listAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HealthPlanDTO> listById(@PathVariable Long id) {
        return service.listById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<HealthPlanDTO> create(@RequestBody HealthPlan paymentForm) {
        return service.create(paymentForm);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<HealthPlanDTO> update(@RequestBody HealthPlan paymentForm) {
        return service.update(paymentForm);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<HealthPlanDTO> findById(@PathVariable Long id) {
        return service.findById(id);
    }

}


