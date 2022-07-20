package com.web.finances.api.controller;

import com.web.finances.api.dto.BillsToPayDTO;
import com.web.finances.domain.model.BillsToPay;
import com.web.finances.domain.service.BillsToPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bills-to-pay")
public class BillsToPayController {
    @Autowired
    BillsToPayService service;

    @GetMapping
    public List<BillsToPayDTO> listAll(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillsToPayDTO> listById(@PathVariable Long id){
        return service.listById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<BillsToPayDTO> create(@RequestBody BillsToPay billsToPay) {
        return service.create(billsToPay);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<BillsToPayDTO> update(@RequestBody BillsToPay billsToPay) {
        return service.update(billsToPay);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<BillsToPayDTO> findById(@PathVariable Long id) {
        return service.findById(id);
    }


}
