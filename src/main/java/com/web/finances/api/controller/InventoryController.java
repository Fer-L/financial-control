package com.web.finances.api.controller;

import com.web.finances.api.dto.InventoryDTO;
import com.web.finances.domain.model.Inventory;
import com.web.finances.domain.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    InventoryService service;

    @GetMapping
    public List<InventoryDTO> listAll(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryDTO> listById(@PathVariable Long id){
        return service.listById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<InventoryDTO> create(@RequestBody Inventory inventory) {
        return service.create(
                inventory
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<InventoryDTO> update(@RequestBody  Inventory inventory) {
        return service.update(inventory);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<InventoryDTO> findById(@PathVariable Long id) {
        return service.findById(id);
    }
}
