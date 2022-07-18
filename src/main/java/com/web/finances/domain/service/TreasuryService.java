package com.web.finances.domain.service;

import com.web.finances.api.dto.TreasuryDTO;
import com.web.finances.domain.model.Treasury;
import com.web.finances.domain.repository.TreasuryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TreasuryService {

    @Autowired
    TreasuryRepository repository;


    public List<TreasuryDTO> listAll() {
        List<TreasuryDTO> treasuryDTOSList = new ArrayList<>();
        repository.findAll()
                .forEach(treasury -> treasuryDTOSList.add(treasury.toDto()));
        return treasuryDTOSList;
    }

   // Treasury treasury

    public ResponseEntity<TreasuryDTO> listById(Long id) {
        return repository.findById(id)
                .map(company -> ResponseEntity.ok().body(company.toDto())
                ).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<TreasuryDTO> findById(Long id) {
        return repository.findById(id)
                .map(treasury -> ResponseEntity.ok(treasury.toDto()))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<TreasuryDTO> create(Treasury treasury) {
        return new ResponseEntity<>(repository.save(treasury).toDto(), HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteById(Long id) {
        return repository.findById(id)
                .map(treasury -> {
                    repository.delete(treasury);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<TreasuryDTO> update(Treasury treasury) {
        return repository.findById(treasury.getId())
                .map(oldTreasury-> {
                    oldTreasury.setValue(treasury.getValue());
                    oldTreasury.setEmissionDate(treasury.getEmissionDate());
                    oldTreasury.setDueDate(treasury.getDueDate());
                    oldTreasury.setAvailabilityDate(treasury.getAvailabilityDate());

                    return new ResponseEntity<>(repository.save(oldTreasury).toDto(), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
