package com.web.finances.api.controller;

import com.web.finances.api.dto.CustomerDTO;
import com.web.finances.domain.model.Customer;
import com.web.finances.domain.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService service;

    @GetMapping
    public List<CustomerDTO> listAll(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> listById(@PathVariable Long id){
        return service.listById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<CustomerDTO> create(@RequestBody Customer custumer) {
        return service.create(custumer);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<CustomerDTO> update(@RequestBody Customer custumer) {
        return service.update(custumer);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<CustomerDTO> findById(@PathVariable Long id) {
        return service.findById(id);
    }


}
