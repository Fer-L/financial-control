package com.web.finances.domain.service;

import com.web.finances.api.dto.PersonalDataDTO;
import com.web.finances.domain.model.PersonalData;
import com.web.finances.domain.repository.PersonalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonalDataService {

    @Autowired
    PersonalDataRepository repository;

    public List<PersonalDataDTO> listAll() {
        List<PersonalDataDTO> personalDataDTOList = new ArrayList<>();
        repository.findAll()
                .forEach(personalData -> personalDataDTOList.add(personalData.toDto()));
        return personalDataDTOList;
    }

    public ResponseEntity<PersonalDataDTO> listById(Long id) {
        return repository.findById(id)
                .map(personalData -> ResponseEntity.ok().body(personalData.toDto())
                ).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<PersonalDataDTO> findById(Long id) {
        return repository.findById(id)
                .map(personalData -> ResponseEntity.ok(personalData.toDto()))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<PersonalDataDTO> create(PersonalData personalData) {
        return new ResponseEntity<>(repository.save(personalData).toDto(), HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteById(Long id) {
        return repository.findById(id)
                .map(personalData -> {
                    repository.delete(personalData);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<PersonalDataDTO> update(PersonalData personalData) {
        return repository.findById(personalData.getPeople_id())
                .map(oldpersonalData -> {
                    oldpersonalData.setCpf(personalData.getCpf());
                    oldpersonalData.setName(personalData.getName());
                    oldpersonalData.setBirth_date(personalData.getBirth_date());
                    oldpersonalData.setEmail(personalData.getEmail());
                    oldpersonalData.setPhone(personalData.getPhone());
                    oldpersonalData.setRua(personalData.getRua());
                    oldpersonalData.setBairro(personalData.getBairro());
                    oldpersonalData.setCidade(personalData.getCidade());

                    return new ResponseEntity<>(repository.save(oldpersonalData).toDto(), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }



}
