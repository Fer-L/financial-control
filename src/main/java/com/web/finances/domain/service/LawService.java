package com.web.finances.domain.service;


import com.web.finances.api.dto.LawDTO;
import com.web.finances.domain.model.Law;
import com.web.finances.domain.repository.LawRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LawService {
    @Autowired
    LawRepository repository;

    public List<LawDTO> listAll() {
        List<LawDTO> lawDTOList = new ArrayList<>();
        repository.findAll()
                .forEach(law -> lawDTOList.add(law.toDto()));
        return lawDTOList;
    }

    public ResponseEntity<LawDTO> listById(Long id) {
        return repository.findById(id)
                .map(law -> ResponseEntity.ok().body(law.toDto())
                ).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<LawDTO> findById(Long id) {
        return repository.findById(id)
                .map(law -> ResponseEntity.ok(law.toDto()))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<LawDTO> create(Law law) {
        return new ResponseEntity<>(repository.save(law).toDto(), HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteById(Long id) {
        return repository.findById(id)
                .map(law -> {
                    repository.delete(law);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<LawDTO> update(Law law) {
        return repository.findById(law.getId())
                .map(oldLaw -> {
                    oldLaw.setLawDescription(law.getLawDescription());
                    oldLaw.setLawNumber(law.getLawNumber());

                    return new ResponseEntity<>(repository.save(oldLaw).toDto(), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

