package com.web.finances.api.controller;

import com.web.finances.api.dto.EntryPayDTO;
import com.web.finances.domain.model.EntryPay;
import com.web.finances.domain.service.EntryPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entry-pay")
public class EntryPayControler {

    @Autowired
    EntryPayService service;

    @GetMapping
    public List<EntryPayDTO> listAll(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntryPayDTO> listById(@PathVariable Long id){
        return service.listById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<EntryPayDTO> create(@RequestBody EntryPay entryPay) {
        return service.create(entryPay);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<EntryPayDTO> update(@RequestBody EntryPay entryPay) {
        return service.update(entryPay);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<EntryPayDTO> findById(@PathVariable Long id) {
        return service.findById(id);
    }


}
