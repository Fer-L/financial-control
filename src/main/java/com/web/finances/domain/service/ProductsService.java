package com.web.finances.domain.service;


import com.web.finances.api.dto.ProductsDTO;
import com.web.finances.domain.model.Products;
import com.web.finances.domain.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;


public class ProductsService {

    @Autowired
    ProductsRepository repository;

    public List<ProductsDTO> listAll() {
        List<ProductsDTO> providerDTOSList = new ArrayList<>();
        repository.findAll()
                .forEach(provider -> providerDTOSList.add(provider.toDto()));
        return providerDTOSList;
    }

    public ResponseEntity<ProductsDTO> listById(Long id) {
        return repository.findById(id)
                .map(products -> ResponseEntity.ok().body(products.toDto())
                ).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<ProductsDTO> findById(Long id) {
        return repository.findById(id)
                .map(products -> ResponseEntity.ok(products.toDto()))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<ProductsDTO> create(Products products) {
        return new ResponseEntity<>(repository.save(products).toDto(), HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteById(Long id) {
        return repository.findById(id)
                .map(products -> {
                    repository.delete(products);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<ProductsDTO> update(Products products) {
        return repository.findById(products.getId())
                .map(oldProducts -> {
                    oldProducts.setValue(products.getValue());
                    oldProducts.setQtde(products.getQtde());
                    oldProducts.setNameProduct(products.getNameProduct());
                    oldProducts.setDescription(products.getDescription());
                    oldProducts.setProvider(products.getProvider());

                    return new ResponseEntity<>(repository.save(oldProducts).toDto(), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
