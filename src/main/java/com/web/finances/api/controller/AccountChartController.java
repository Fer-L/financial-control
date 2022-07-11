package com.web.finances.api.controller;

import com.web.finances.api.dto.AccountChartDTO;
import com.web.finances.api.dto.CompanyDTO;
import com.web.finances.domain.model.AccountChart;
import com.web.finances.domain.model.Company;
import com.web.finances.domain.service.AccountChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account-chart")
public class AccountChartController {

    @Autowired
    AccountChartService service;

    @GetMapping
    public List<AccountChartDTO> listAll(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountChartDTO> listById(@PathVariable Long id){
        return service.listById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<AccountChartDTO> create(@RequestBody AccountChart accountChart) {
        return service.create(accountChart);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<AccountChartDTO> update(@RequestBody AccountChart accountChart) {
        return service.update(accountChart);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<AccountChartDTO> findById(@PathVariable Long id) {
        return service.findById(id);
    }


}
