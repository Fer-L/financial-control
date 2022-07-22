package com.web.finances.domain.service;

import com.web.finances.api.dto.PatrimonyDTO;
import com.web.finances.domain.model.Patrimony;
import com.web.finances.domain.repository.PatrimonyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatrimonyService {
    @Autowired
    PatrimonyRepository repository;


    public List<PatrimonyDTO> listAll() {
        List<PatrimonyDTO> PatrimonyDTOList = new ArrayList<>();
        repository.findAll()
                .forEach(entryPay -> PatrimonyDTOList.add(entryPay.toDto()));
        return PatrimonyDTOList;
    }

    public ResponseEntity<PatrimonyDTO> listById(Long id) {
        return repository.findById(id)
                .map(patrimony -> ResponseEntity.ok().body(patrimony.toDto())
                ).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<PatrimonyDTO> findById(Long id) {
        return repository.findById(id)
                .map(patrimony -> ResponseEntity.ok(patrimony.toDto()))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<PatrimonyDTO> create(Patrimony patrimony) {
        return new ResponseEntity<>(repository.save(patrimony).toDto(), HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteById(Long id) {
        return repository.findById(id)
                .map(patrimony -> {
                    repository.delete(patrimony);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<PatrimonyDTO> update(Patrimony patrimony) {
        return repository.findById(patrimony.getId())
                .map(oldPatrimony -> {
                    oldPatrimony.setNamePatrimony(patrimony.getNamePatrimony());
                    oldPatrimony.setValuePatrimony(patrimony.getValuePatrimony());
                    oldPatrimony.setBuyDate(patrimony.getBuyDate());
                    oldPatrimony.setLifespan(patrimony.getLifespan());
                    oldPatrimony.setAccountChart(patrimony.getAccountChart());

                    return new ResponseEntity<>(repository.save(oldPatrimony).toDto(), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }

}