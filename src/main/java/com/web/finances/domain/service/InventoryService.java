package com.web.finances.domain.service;

import com.web.finances.api.dto.InventoryDTO;
import com.web.finances.domain.model.Inventory;
import com.web.finances.domain.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryService {
    @Autowired
    InventoryRepository repository;

    public List<InventoryDTO> listAll() {
        List<InventoryDTO> inventoryDTOSList = new ArrayList<>();
        repository.findAll()
                .forEach(inventory -> inventoryDTOSList.add(inventory.toDto()));
        return inventoryDTOSList;
    }

    public ResponseEntity<InventoryDTO> listById(Long id) {
        return repository.findById(id)
                .map(inventory -> ResponseEntity.ok().body(inventory.toDto())
                ).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<InventoryDTO> findById(Long id) {
        return repository.findById(id)
                .map(inventory -> ResponseEntity.ok(inventory.toDto()))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<InventoryDTO> create(Inventory inventory) {
        return new ResponseEntity<>(repository.save(inventory).toDto(), HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteById(Long id) {
        return repository.findById(id)
                .map(products -> {
                    repository.delete(products);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<InventoryDTO> update(Inventory inventory) {
        return repository.findById(inventory.getId())
                .map(oldInventory -> {
                    oldInventory.setEstimatedSalePrice(inventory.getEstimatedSalePrice());
                    oldInventory.setQtde(inventory.getQtde());
                    oldInventory.setProducts(inventory.getProducts());

                    return new ResponseEntity<>(repository.save(oldInventory).toDto(), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
