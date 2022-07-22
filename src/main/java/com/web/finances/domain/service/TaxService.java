package com.web.finances.domain.service;

import com.web.finances.api.dto.TaxDTO;
import com.web.finances.domain.model.Tax;
import com.web.finances.domain.repository.TaxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaxService {
    @Autowired
    TaxRepository repository;

    public List<TaxDTO> listAll() {
        List<TaxDTO> taxDTOSList = new ArrayList<>();
        repository.findAll()
                .forEach(tax -> taxDTOSList.add(tax.toDto()));
        return taxDTOSList;
    }

    public ResponseEntity<TaxDTO> listById(Long id) {
        return repository.findById(id)
                .map(tax -> ResponseEntity.ok().body(tax.toDto())
                ).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<TaxDTO> findById(Long id) {
        return repository.findById(id)
                .map(tax -> ResponseEntity.ok(tax.toDto()))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<TaxDTO> create(Tax tax) {
        return new ResponseEntity<>(repository.save(tax).toDto(), HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteById(Long id) {
        return repository.findById(id)
                .map(tax -> {
                    repository.delete(tax);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<TaxDTO> update(Tax tax) {
        return repository.findById(tax.getId())
                .map(oldTax -> {
                    oldTax.setPercent(tax.getPercent());
                    oldTax.setNameTax(tax.getNameTax());
                    oldTax.setScope(tax.getScope());



                    return new ResponseEntity<>(repository.save(oldTax).toDto(), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }

}