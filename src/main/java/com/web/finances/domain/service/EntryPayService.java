package com.web.finances.domain.service;

import com.web.finances.api.dto.EntryPayDTO;
import com.web.finances.domain.model.EntryPay;
import com.web.finances.domain.repository.EntryPayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntryPayService {

    @Autowired
    EntryPayRepository repository;


    public List<EntryPayDTO> listAll() {
        List<EntryPayDTO> entryPayDTOList = new ArrayList<>();
        repository.findAll()
                .forEach(entryPay -> entryPayDTOList.add(entryPay.toDto()));
        return entryPayDTOList;
    }

    public ResponseEntity<EntryPayDTO> listById(Long id) {
        return repository.findById(id)
                .map(entryPay -> ResponseEntity.ok().body(entryPay.toDto())
                ).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<EntryPayDTO> findById(Long id) {
        return repository.findById(id)
                .map(entryPay -> ResponseEntity.ok(entryPay.toDto()))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<EntryPayDTO> create(EntryPay entryPay) {
        return new ResponseEntity<>(repository.save(entryPay).toDto(), HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteById(Long id) {
        return repository.findById(id)
                .map(entryPay -> {
                    repository.delete(entryPay);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<EntryPayDTO> update(EntryPay entryPay) {
        return repository.findById(entryPay.getId())
                .map(oldEntryPay -> {
                    oldEntryPay.setDocNumber(entryPay.getDocNumber());
                    oldEntryPay.setTitleValue(entryPay.getTitleValue());
                    oldEntryPay.setDueDate(entryPay.getDueDate());
                    oldEntryPay.setEmissionDate(entryPay.getEmissionDate());
                    oldEntryPay.setCompany(entryPay.getCompany());
                    oldEntryPay.setCustomer(entryPay.getCustomer());

                    return new ResponseEntity<>(repository.save(oldEntryPay).toDto(), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
