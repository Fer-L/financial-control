package com.web.finances.domain.service;

import com.web.finances.api.dto.BankAccountDTO;
import com.web.finances.domain.model.BankAccount;
import com.web.finances.domain.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountService {

    @Autowired
    BankAccountRepository repository;

    public List<BankAccountDTO> listAll() {
        List<BankAccountDTO> bankAccountDTOList = new ArrayList<>();
        repository.findAll()
                .forEach(bankAccount -> bankAccountDTOList.add(bankAccount.toDto()));
        return bankAccountDTOList;
    }

    public ResponseEntity<BankAccountDTO> listById(Long id) {
        return repository.findById(id)
                .map(bankAccount -> ResponseEntity.ok().body(bankAccount.toDto())
                ).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<BankAccountDTO> findById(Long id) {
        return repository.findById(id)
                .map(bankAccount -> ResponseEntity.ok(bankAccount.toDto()))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<BankAccountDTO> create(BankAccount bankAccount) {
        return new ResponseEntity<>(repository.save(bankAccount).toDto(), HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteById(Long id) {
        return repository.findById(id)
                .map(bankAccount -> {
                    repository.delete(bankAccount);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<BankAccountDTO> update(BankAccount bankAccount) {
        return repository.findById(bankAccount.getId())
                .map(oldBankAccount -> {
                    oldBankAccount.setClassification(bankAccount.getClassification());
                    oldBankAccount.setDescription(bankAccount.getDescription());
                    oldBankAccount.setAccountNumber(bankAccount.getAccountNumber());
                    oldBankAccount.setAgencyNumber(bankAccount.getAgencyNumber());
                    oldBankAccount.setInicialBalanceDate(bankAccount.getInicialBalanceDate());
                    oldBankAccount.setInicialBalance(bankAccount.getInicialBalance());
                    oldBankAccount.setBank(bankAccount.getBank());
                    oldBankAccount.setCnpjCompany(bankAccount.getCnpjCompany());


                    return new ResponseEntity<>(repository.save(oldBankAccount).toDto(), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
