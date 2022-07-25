package com.web.finances.domain.service;


import com.web.finances.api.dto.PayrollDTO;

import com.web.finances.domain.model.Payroll;
import com.web.finances.domain.repository.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PayrollService {

    @Autowired
    PayrollRepository repository;

    public List<PayrollDTO> listAll() {
        List<PayrollDTO> personalDataDTOList = new ArrayList<>();
        repository.findAll()
                .forEach(personalData -> personalDataDTOList.add(personalData.toDto()));
        return personalDataDTOList;
    }

    public ResponseEntity<PayrollDTO> listById(Long id) {
        return repository.findById(id)
                .map(personalData -> ResponseEntity.ok().body(personalData.toDto())
                ).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<PayrollDTO> findById(Long id) {
        return repository.findById(id)
                .map(personalData -> ResponseEntity.ok(personalData.toDto()))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<PayrollDTO> create(Payroll personalData) {
        personalData.setValorLiquido(personalData.getValorBruto()-personalData.getValorDesconto());
        return new ResponseEntity<>(repository.save(personalData).toDto(), HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteById(Long id) {
        return repository.findById(id)
                .map(personalData -> {
                    repository.delete(personalData);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<PayrollDTO> update(Payroll personalData) {
        return repository.findById(personalData.getId())
                .map(oldpersonalData -> {
                    oldpersonalData.setValorBruto(personalData.getValorBruto());
                    oldpersonalData.setValorDesconto(personalData.getValorDesconto());
                    oldpersonalData.setValorLiquido(personalData.getValorBruto()- personalData.getValorDesconto());

                    oldpersonalData.setDataPagamento(personalData.getDataPagamento());
                    return new ResponseEntity<>(repository.save(oldpersonalData).toDto(), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
