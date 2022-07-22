package com.web.finances.domain.service;

import com.web.finances.api.dto.BankDepositDTO;
import com.web.finances.domain.model.BankAccount;
import com.web.finances.domain.model.BankDeposit;
import com.web.finances.domain.repository.BankDepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankDepositService {
    @Autowired
    BankDepositRepository repository;

    public List<BankDepositDTO> listAll() {
        List<BankDepositDTO> accountChartDTOList = new ArrayList<>();
        repository.findAll()
                .forEach(accountChart -> accountChartDTOList.add(accountChart.toDto()));
        return accountChartDTOList;
    }

    public ResponseEntity<BankDepositDTO> listById(Long id) {
        return repository.findById(id)
                .map(accountChart -> ResponseEntity.ok().body(accountChart.toDto())
                ).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<BankDepositDTO> findById(Long id) {
        return repository.findById(id)
                .map(accountChart -> ResponseEntity.ok(accountChart.toDto()))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<BankDepositDTO> create(BankDeposit accountChart) {
        return new ResponseEntity<>(repository.save(accountChart).toDto(), HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteById(Long id) {
        return repository.findById(id)
                .map(accountChart -> {
                    repository.delete(accountChart);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<BankDepositDTO> update(BankDeposit accountChart) {
        return repository.findById(accountChart.getId())
                .map(oldAccountChart -> {
                    oldAccountChart.setValue(accountChart.getValue());
                    oldAccountChart.setIsDeposit(accountChart.getIsDeposit());
                    oldAccountChart.setBankAccount(accountChart.getBankAccount());

                    return new ResponseEntity<>(repository.save(oldAccountChart).toDto(), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
