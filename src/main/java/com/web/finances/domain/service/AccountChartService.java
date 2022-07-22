package com.web.finances.domain.service;

import com.web.finances.api.dto.AccountChartDTO;
import com.web.finances.domain.model.AccountChart;
import com.web.finances.domain.repository.AccountChartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountChartService {
    @Autowired
    AccountChartRepository repository;

    public List<AccountChartDTO> listAll() {
        List<AccountChartDTO> accountChartDTOList = new ArrayList<>();
        repository.findAll()
                .forEach(accountChart -> accountChartDTOList.add(accountChart.toDto()));
        return accountChartDTOList;
    }

    public ResponseEntity<AccountChartDTO> listById(Long id) {
        return repository.findById(id)
                .map(accountChart -> ResponseEntity.ok().body(accountChart.toDto())
                ).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<AccountChartDTO> findById(Long id) {
        return repository.findById(id)
                .map(accountChart -> ResponseEntity.ok(accountChart.toDto()))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<AccountChartDTO> create(AccountChart accountChart) {
        return new ResponseEntity<>(repository.save(accountChart).toDto(), HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteById(Long id) {
        return repository.findById(id)
                .map(accountChart -> {
                    repository.delete(accountChart);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<AccountChartDTO> update(AccountChart accountChart) {
        return repository.findById(accountChart.getId())
                .map(oldAccountChart -> {
                    oldAccountChart.setClassification(accountChart.getClassification());
                    oldAccountChart.setAccountType(accountChart.getAccountType());
                    oldAccountChart.setDescription(accountChart.getDescription());
                    oldAccountChart.setAspect(accountChart.getAspect());
                    oldAccountChart.setBankAccount(accountChart.getBankAccount());

                    return new ResponseEntity<>(repository.save(oldAccountChart).toDto(), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
