package com.web.finances.domain.service;

import com.web.finances.api.dto.SectorDTO;
import com.web.finances.domain.model.Sector;
import com.web.finances.domain.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SectorService {
    @Autowired
    SectorRepository repository;

    public List<SectorDTO> listAll() {
        List<SectorDTO> taxDTOSList = new ArrayList<>();
        repository.findAll()
                .forEach(tax -> taxDTOSList.add(tax.toDto()));
        return taxDTOSList;
    }

    public ResponseEntity<SectorDTO> listById(Long id) {
        return repository.findById(id)
                .map(tax -> ResponseEntity.ok().body(tax.toDto())
                ).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<SectorDTO> findById(Long id) {
        return repository.findById(id)
                .map(tax -> ResponseEntity.ok(tax.toDto()))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<SectorDTO> create(Sector tax) {
        return new ResponseEntity<>(repository.save(tax).toDto(), HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteById(Long id) {
        return repository.findById(id)
                .map(tax -> {
                    repository.delete(tax);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<SectorDTO> update(Sector tax) {
        return repository.findById(tax.getId())
                .map(oldTax -> {
                    oldTax.setNameSector(tax.getNameSector());
                    oldTax.setCompany(tax.getCompany());

                    return new ResponseEntity<>(repository.save(oldTax).toDto(), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }

}

