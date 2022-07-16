package com.web.finances.domain.service;

import com.web.finances.api.dto.CustomerDTO;
import com.web.finances.domain.model.Customer;
import com.web.finances.domain.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    CustomerRepository repository;

    public List<CustomerDTO> listAll() {
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        repository.findAll()
                .forEach(customer -> customerDTOList.add(customer.toDto()));
        return customerDTOList;
    }

    public ResponseEntity<CustomerDTO> listById(Long id) {
        return repository.findById(id)
                .map(customer -> ResponseEntity.ok().body(customer.toDto())
                ).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<CustomerDTO> findById(Long id) {
        return repository.findById(id)
                .map(customer -> ResponseEntity.ok(customer.toDto()))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<CustomerDTO> create(Customer customer) {
        return new ResponseEntity<>(repository.save(customer).toDto(), HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteById(Long id) {
        return repository.findById(id)
                .map(customer -> {
                    repository.delete(customer);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<CustomerDTO> update(Customer customer) {
        return repository.findById(customer.getId())
                .map(oldCustomer -> {
                    oldCustomer.setCorporateName(customer.getCorporateName());
                    oldCustomer.setCnpjCpf(customer.getCnpjCpf());
                    oldCustomer.setAddress(customer.getAddress());
                    oldCustomer.setCounty(customer.getCounty());
                    oldCustomer.setZipCode(customer.getZipCode());
                    oldCustomer.setPhone(customer.getPhone());
                    oldCustomer.setMail(customer.getMail());

                    return new ResponseEntity<>(repository.save(oldCustomer).toDto(), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
