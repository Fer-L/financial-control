package com.web.finances.domain.service;

import com.web.finances.api.dto.ProfessionsDTO;
import com.web.finances.domain.model.Professions;
import com.web.finances.domain.repository.ProfessionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessionsService {

    @Autowired
    ProfessionsRepository repository;

    public List<ProfessionsDTO> listAll() {
        List<ProfessionsDTO> professionsDTOList = new ArrayList<>();
        repository.findAll()
                .forEach(professionData -> professionsDTOList.add(professionData.toDto()));
        return professionsDTOList;
    }

    public ResponseEntity<ProfessionsDTO> listById(Long id) {
        return repository.findById(id)
                .map(professionData -> ResponseEntity.ok().body(professionData.toDto())
                ).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<ProfessionsDTO> findById(Long id) {
        return repository.findById(id)
                .map(professionData -> ResponseEntity.ok(professionData.toDto()))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<ProfessionsDTO> create(Professions professionData) {
        return new ResponseEntity<>(repository.save(professionData).toDto(), HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteById(Long id) {
        return repository.findById(id)
                .map(professionData -> {
                    repository.delete(professionData);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<ProfessionsDTO> update(Professions professionData) {
        return repository.findById(professionData.getProfession_id())
                .map(oldProfessionData -> {
                    oldProfessionData.setProfession_name(professionData.getProfession_name());
                    oldProfessionData.setWorkload(professionData.getWorkload());
                    return new ResponseEntity<>(repository.save(oldProfessionData).toDto(), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }



}
