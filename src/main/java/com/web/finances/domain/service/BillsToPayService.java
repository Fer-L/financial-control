package com.web.finances.domain.service;

import com.web.finances.api.dto.BillsToPayDTO;
import com.web.finances.domain.model.BillsToPay;
import com.web.finances.domain.repository.BillsToPayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillsToPayService {

    @Autowired
    BillsToPayRepository repository;


    public List<BillsToPayDTO> listAll() {
        List<BillsToPayDTO> billsToPayDTOList = new ArrayList<>();
        repository.findAll()
                .forEach(entryPay -> billsToPayDTOList.add(entryPay.toDto()));
        return billsToPayDTOList;
    }

    public ResponseEntity<BillsToPayDTO> listById(Long id) {
        return repository.findById(id)
                .map(billsToPay -> ResponseEntity.ok().body(billsToPay.toDto())
                ).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<BillsToPayDTO> findById(Long id) {
        return repository.findById(id)
                .map(entryPay -> ResponseEntity.ok(entryPay.toDto()))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<BillsToPayDTO> create(BillsToPay billsToPay) {
        return new ResponseEntity<>(repository.save(billsToPay).toDto(), HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteById(Long id) {
        return repository.findById(id)
                .map(entryPay -> {
                    repository.delete(entryPay);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<BillsToPayDTO> update(BillsToPay billsToPay) {
        return repository.findById(billsToPay.getId())
                .map(oldBillsToPay -> {
                    oldBillsToPay.setDocNumber(billsToPay.getDocNumber());
                    oldBillsToPay.setTitleValue(billsToPay.getTitleValue());
                    oldBillsToPay.setDueDate(billsToPay.getDueDate());
                    oldBillsToPay.setEmissionDate(billsToPay.getEmissionDate());
                    oldBillsToPay.setCompany(billsToPay.getCompany());
                    oldBillsToPay.setProvider(billsToPay.getProvider());

                    return new ResponseEntity<>(repository.save(oldBillsToPay).toDto(), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
