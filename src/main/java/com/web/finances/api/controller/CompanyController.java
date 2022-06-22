package com.web.finances.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.finances.api.dto.CompanyDTO;
import com.web.finances.domain.model.Company;

import com.web.finances.domain.repository.CompanyRepository;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyRepository rep;

    @GetMapping
    public List<Company> index() {
        return rep.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> get(@PathVariable Long id) {
        Optional<Company> _company = rep.findById(id);

        if (_company.isEmpty()) {
            return ResponseEntity.status(
                    HttpStatus.NOT_FOUND).body("body");
        }

        return ResponseEntity.ok().body(_company);
    }

    // @PostMapping
    // public ResponseEntity<Object> autenticarUsuario(@RequestBody CompanyDTO company) {
    //     System.out.println(company.getId());

    //     Optional<Company> _Company = rep.findById(company.getId());
    //     return ResponseEntity.ok(_Company);

    // }

    @PostMapping
    public ResponseEntity<Company> salvar(
            @RequestBody @Valid CompanyDTO dto) {
        Company _newCompany = new Company();
        _newCompany.setCorporateName(dto.getCorporateName());
        _newCompany.setCnpj(dto.getCnpj());
        _newCompany.setAddress(dto.getAddress());
        _newCompany.setCounty(dto.getCounty());
        _newCompany.setZipCode(dto.getZipCode());
        _newCompany.setPhone(dto.getPhone());
        _newCompany.setMail(dto.getMail());
        _newCompany.setTitularName(dto.getTitularName());
        _newCompany.setCpf(dto.getCpf());

        _newCompany = rep.save(_newCompany);
        return ResponseEntity.ok().body(_newCompany);
    }
}
