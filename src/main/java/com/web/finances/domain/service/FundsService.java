package com.web.finances.domain.service;

import com.web.finances.api.dto.FundsDTO;
import com.web.finances.domain.model.Funds;
import com.web.finances.domain.repository.FundsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FundsService {

    @Autowired
    FundsRepository repository;

    public List<FundsDTO> listAll() {
        List<FundsDTO> fundsDTOList = new ArrayList<>();
        repository.findAll()
                .forEach(funds -> fundsDTOList.add(funds.toDto()));
        return fundsDTOList;
    }

    public ResponseEntity<FundsDTO> listById(Long id) {
        return repository.findById(id)
                .map(funds -> ResponseEntity.ok().body(funds.toDto())
                ).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<FundsDTO> findById(Long id) {
        return repository.findById(id)
                .map(funds -> ResponseEntity.ok(funds.toDto()))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<FundsDTO> create(Funds funds) {
        return new ResponseEntity<>(repository.save(funds).toDto(), HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteById(Long id) {
        return repository.findById(id)
                .map(funds -> {
                    repository.delete(funds);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<FundsDTO> update(Funds funds) {
        return repository.findById(funds.getFunds_id())
                .map(oldFunds -> {
                    oldFunds.setName(oldFunds.getName());
                    oldFunds.setProvento(oldFunds.getProvento());
                    return new ResponseEntity<>(repository.save(oldFunds).toDto(), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }



}
