package com.web.finances.api.controller;



import com.web.finances.api.dto.EmployeeDTO;
import com.web.finances.domain.model.Employee;
import com.web.finances.domain.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService service;

    @GetMapping
    public List<EmployeeDTO> listAll(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> listById(@PathVariable Long id){
        return service.listById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<EmployeeDTO> create(@RequestBody Employee employee) {
        return service.create(employee);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<EmployeeDTO> update(@RequestBody  Employee employee) {

        return service.update(employee);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<EmployeeDTO> findById(@PathVariable Long id) {
        return service.findById(id);
    }

}
