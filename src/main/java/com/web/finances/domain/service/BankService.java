package com.web.finances.domain.service;

import com.web.finances.api.dto.BankDTO;
import com.web.finances.domain.model.Bank;
import com.web.finances.domain.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankService {

    @Autowired
    BankRepository repository;

    public List<BankDTO> listAll() {
        List<BankDTO> paymentFormDTOList = new ArrayList<>();
        repository.findAll()
                .forEach(paymentForm -> paymentFormDTOList.add(paymentForm.toDto()));
        return paymentFormDTOList;
    }

    public ResponseEntity<BankDTO> listById(Long id) {
        return repository.findById(id)
                .map(accountChart -> ResponseEntity.ok().body(accountChart.toDto())
                ).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<BankDTO> findById(Long id) {
        return repository.findById(id)
                .map(accountChart -> ResponseEntity.ok(accountChart.toDto()))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<BankDTO> create(Bank bank) {
        return new ResponseEntity<>(repository.save(bank).toDto(), HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteById(Long id) {
        return repository.findById(id)
                .map(paymentForm -> {
                    repository.delete(paymentForm);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<BankDTO> update(Bank bank) {
        return repository.findById(bank.getId())
                .map(oldPaymentForm -> {
                    oldPaymentForm.setCnpj(bank.getCnpj());
                    oldPaymentForm.setNameBank(bank.getNameBank());
                    oldPaymentForm.setFebrabanCode(bank.getFebrabanCode());

                    return new ResponseEntity<>(repository.save(oldPaymentForm).toDto(), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }



}
