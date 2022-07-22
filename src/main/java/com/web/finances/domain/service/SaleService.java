package com.web.finances.domain.service;

import com.web.finances.api.dto.SaleDTO;
import com.web.finances.domain.model.Sale;
import com.web.finances.domain.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService {
    @Autowired
    SaleRepository repository;

    public List<SaleDTO> listAll() {
        List<SaleDTO> saleDTOSList = new ArrayList<>();
        repository.findAll()
                .forEach(sale -> saleDTOSList.add(sale.toDto()));
        return saleDTOSList;
    }

    public ResponseEntity<SaleDTO> listById(Long id) {
        return repository.findById(id)
                .map(sale -> ResponseEntity.ok().body(sale.toDto())
                ).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<SaleDTO> findById(Long id) {
        return repository.findById(id)
                .map(sale -> ResponseEntity.ok(sale.toDto()))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<SaleDTO> create(Sale sale) {
        return new ResponseEntity<>(repository.save(sale).toDto(), HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteById(Long id) {
        return repository.findById(id)
                .map(sale -> {
                    repository.delete(sale);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<SaleDTO> update(Sale sale) {
        return repository.findById(sale.getId())
                .map(oldSale -> {
                    oldSale.setValue(sale.getValue());
                    oldSale.setEmissionDate(sale.getEmissionDate());
                    oldSale.setCustomer(sale.getCustomer());
                    oldSale.setTax(sale.getTax());
                    oldSale.setProducts(sale.getProducts());


                    return new ResponseEntity<>(repository.save(oldSale).toDto(), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }

}