package com.web.finances.api.controller;

import com.web.finances.api.dto.SaleDTO;
import com.web.finances.domain.model.Sale;
import com.web.finances.domain.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    SaleService service;

    @GetMapping
    public List<SaleDTO> listAll(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleDTO> listById(@PathVariable Long id){
        return service.listById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<SaleDTO> create(@RequestBody Sale sale) {
        return service.create(
                sale
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<SaleDTO> update(@RequestBody  Sale sale) {
        return service.update(sale);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<SaleDTO> findById(@PathVariable Long id) {
        return service.findById(id);
    }

}
