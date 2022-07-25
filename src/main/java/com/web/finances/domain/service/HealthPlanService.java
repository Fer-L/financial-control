package com.web.finances.domain.service;


import com.web.finances.api.dto.HealthPlanDTO;
import com.web.finances.domain.model.HealthPlan;
import com.web.finances.domain.repository.HealthPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HealthPlanService {

    @Autowired
    HealthPlanRepository repository;

    public List<HealthPlanDTO> listAll() {
        List<HealthPlanDTO> paymentFormDTOList = new ArrayList<>();
        repository.findAll()
                .forEach(paymentForm -> paymentFormDTOList.add(paymentForm.toDto()));
        return paymentFormDTOList;
    }

    public ResponseEntity<HealthPlanDTO> listById(Long id) {
        return repository.findById(id)
                .map(accountChart -> ResponseEntity.ok().body(accountChart.toDto())
                ).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<HealthPlanDTO> findById(Long id) {
        return repository.findById(id)
                .map(accountChart -> ResponseEntity.ok(accountChart.toDto()))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<HealthPlanDTO> create(HealthPlan paymentForm) {
        return new ResponseEntity<>(repository.save(paymentForm).toDto(), HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteById(Long id) {
        return repository.findById(id)
                .map(paymentForm -> {
                    repository.delete(paymentForm);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<HealthPlanDTO> update(HealthPlan paymentForm) {
        return repository.findById(paymentForm.getId())
                .map(oldPaymentForm -> {
                    oldPaymentForm.setOperadora(paymentForm.getOperadora());
                    oldPaymentForm.setCodigoAns(paymentForm.getCodigoAns());
                    return new ResponseEntity<>(repository.save(oldPaymentForm).toDto(), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }



}
