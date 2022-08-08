package com.web.finances.api.controller;

import com.web.finances.api.dto.ItemPayDTO;
import com.web.finances.domain.model.ItemPay;
import com.web.finances.domain.service.ItemPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itempay")
public class ItemPayController {
    @Autowired
    ItemPayService service;

    @GetMapping
    public List<ItemPayDTO> listAll(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPayDTO> listById(@PathVariable Long id){
        return service.listById(id);
    }

//    @GetMapping("/listable/{id}")
//    public ResponseEntity<ItemPayDTO> listByPayroll(@PathVariable Long id){
//        return service.listByPayroll(id);
//    }

    @PostMapping("/new")
    public ResponseEntity<ItemPayDTO> create(@RequestBody ItemPay law) {
        return service.create(law);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<ItemPayDTO> update(@RequestBody ItemPay law) {
        return service.update(law);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<ItemPayDTO> findById(@PathVariable Long id) {
        return service.findById(id);
    }
}

