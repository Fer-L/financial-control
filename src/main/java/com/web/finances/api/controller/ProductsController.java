package com.web.finances.api.controller;

import com.web.finances.api.dto.ProductsDTO;
import com.web.finances.domain.model.Products;
import com.web.finances.domain.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ProductsController {
    @Autowired
    ProductsService service;

    @GetMapping
    public List<ProductsDTO> listAll(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductsDTO> listById(@PathVariable Long id){
        return service.listById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<ProductsDTO> create(@RequestBody Products products) {
        return service.create(
                products
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<ProductsDTO> update(@RequestBody  Products products) {
        return service.update(products);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<ProductsDTO> findById(@PathVariable Long id) {
        return service.findById(id);
    }

}
