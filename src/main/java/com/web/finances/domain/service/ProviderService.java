package com.web.finances.domain.service;

import com.web.finances.api.dto.ProviderDTO;

import com.web.finances.domain.model.Provider;
import com.web.finances.domain.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProviderService {

    @Autowired
    ProviderRepository repository;

    public List<ProviderDTO> listAll() {
        List<ProviderDTO> providerDTOSList = new ArrayList<>();
        repository.findAll()
                .forEach(provider -> providerDTOSList.add(provider.toDto()));
        return providerDTOSList;
    }

    public ResponseEntity<ProviderDTO> listById(Long id) {
        return repository.findById(id)
                .map(provider -> ResponseEntity.ok().body(provider.toDto())
                ).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<ProviderDTO> findById(Long id) {
        return repository.findById(id)
                .map(provider -> ResponseEntity.ok(provider.toDto()))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<ProviderDTO> create(Provider provider) {
        return new ResponseEntity<>(repository.save(provider).toDto(), HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteById(Long id) {
        return repository.findById(id)
                .map(provider -> {
                    repository.delete(provider);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<ProviderDTO> update(Provider provider) {
        return repository.findById(provider.getId())
                .map(oldProvider -> {
                    oldProvider.setCorporateName(provider.getCorporateName());
                    oldProvider.setCnpjCpf(provider.getCnpjCpf());
                    oldProvider.setAddress(provider.getAddress());
                    oldProvider.setCounty(provider.getCounty());
                    oldProvider.setZipCode(provider.getZipCode());
                    oldProvider.setPhone(provider.getPhone());
                    oldProvider.setMail(provider.getMail());


                    return new ResponseEntity<>(repository.save(oldProvider).toDto(), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
