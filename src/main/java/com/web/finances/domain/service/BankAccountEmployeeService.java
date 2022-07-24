package com.web.finances.domain.service;

import com.web.finances.api.dto.BankAccountEmployeeDTO;
import com.web.finances.domain.model.BankAccountEmployee;
import com.web.finances.domain.repository.BankAccountEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountEmployeeService {

    @Autowired
    BankAccountEmployeeRepository repository;

    public List<BankAccountEmployeeDTO> listAll() {
        List<BankAccountEmployeeDTO> bankAccountEmployeeDTOList = new ArrayList<>();
        repository.findAll()
                .forEach(bankAccountEmployee -> bankAccountEmployeeDTOList.add(bankAccountEmployee.toDto()));
        return bankAccountEmployeeDTOList;
    }

    public ResponseEntity<BankAccountEmployeeDTO> listById(Long id) {
        return repository.findById(id)
                .map(bankAccountEmployee -> ResponseEntity.ok().body(bankAccountEmployee.toDto())
                ).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<BankAccountEmployeeDTO> findById(Long id) {
        return repository.findById(id)
                .map(bankAccountEmployee -> ResponseEntity.ok(bankAccountEmployee.toDto()))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<BankAccountEmployeeDTO> create(BankAccountEmployee bankAccountEmployee) {
        return new ResponseEntity<>(repository.save(bankAccountEmployee).toDto(), HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteById(Long id) {
        return repository.findById(id)
                .map(bankAccountEmployee -> {
                    repository.delete(bankAccountEmployee);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<BankAccountEmployeeDTO> update(BankAccountEmployee bankAccountEmployee) {
        return repository.findById(bankAccountEmployee.getId())
                .map(oldbankAccountEmployee -> {
                    oldbankAccountEmployee.setBank(bankAccountEmployee.getBank());
                    oldbankAccountEmployee.setAgencia(bankAccountEmployee.getAgencia());
                    oldbankAccountEmployee.setDv_agencia(bankAccountEmployee.getDv_agencia());
                    oldbankAccountEmployee.setConta(bankAccountEmployee.getConta());
                    oldbankAccountEmployee.setDv_conta(bankAccountEmployee.getDv_conta());
                    return new ResponseEntity<>(repository.save(oldbankAccountEmployee).toDto(), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }



}
