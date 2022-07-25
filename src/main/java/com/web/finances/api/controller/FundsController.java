package com.web.finances.api.controller;

import com.web.finances.api.dto.FundsDTO;
import com.web.finances.domain.model.Funds;
import com.web.finances.domain.service.FundsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funds")
public class FundsController {
    @Autowired
    FundsService service;

    @GetMapping
    public List<FundsDTO> listAll(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FundsDTO> listById(@PathVariable Long id){
        return service.listById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<FundsDTO> create(@RequestBody Funds funds) {
        return service.create(
                funds
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<FundsDTO> update(@RequestBody  Funds funds) {
        System.out.println("id"+funds.getId());
        System.out.println("name"+funds.getName());
        System.out.println("prov"+funds.getProvento());
        return service.update(funds);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<FundsDTO> findById(@PathVariable Long id) {
        return service.findById(id);
    }

}
