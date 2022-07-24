package com.web.finances.domain.service;

import com.web.finances.api.dto.EmployeeDTO;
import com.web.finances.domain.model.Employee;
import com.web.finances.domain.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    public List<EmployeeDTO> listAll() {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        repository.findAll()
                .forEach(personalData -> employeeDTOList.add(personalData.toDto()));
        return employeeDTOList;
    }

    public ResponseEntity<EmployeeDTO> listById(Long id) {
        return repository.findById(id)
                .map(employeeData -> ResponseEntity.ok().body(employeeData.toDto())
                ).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<EmployeeDTO> findById(Long id) {
        return repository.findById(id)
                .map(employeeData -> ResponseEntity.ok(employeeData.toDto()))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<EmployeeDTO> create(Employee employeeData) {
        return new ResponseEntity<>(repository.save(employeeData).toDto(), HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteById(Long id) {
        return repository.findById(id)
                .map(employeeData -> {
                    repository.delete(employeeData);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<EmployeeDTO> update(Employee employeeData) {
        return repository.findById(employeeData.getEmployee_id())
                .map(oldemployeeData -> {
                    oldemployeeData.setCompany(employeeData.getCompany());
                    oldemployeeData.setProfession(employeeData.getProfession());
                    oldemployeeData.setFunds(employeeData.getFunds());


                    return new ResponseEntity<>(repository.save(oldemployeeData).toDto(), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }



}
