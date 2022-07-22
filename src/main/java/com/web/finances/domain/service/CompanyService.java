package com.web.finances.domain.service;

import com.web.finances.api.dto.CompanyDTO;
import com.web.finances.domain.model.Company;
import com.web.finances.domain.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository repository;

    public List<CompanyDTO> listAll() {
        List<CompanyDTO> companyDTOSList = new ArrayList<>();
        repository.findAll()
                .forEach(company -> companyDTOSList.add(company.toDto()));
        return companyDTOSList;
    }

    public ResponseEntity<CompanyDTO> listById(Long id) {
        return repository.findById(id)
                .map(company -> ResponseEntity.ok().body(company.toDto())
                ).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<CompanyDTO> findById(Long id) {
        return repository.findById(id)
                .map(company -> ResponseEntity.ok(company.toDto()))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<CompanyDTO> create(Company company) {
        return new ResponseEntity<>(repository.save(company).toDto(), HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteById(Long id) {
        return repository.findById(id)
            .map(company -> {
                repository.delete(company);
                return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<CompanyDTO> update(Company company) {
        return repository.findById(company.getId())
                .map(oldCompany -> {
                    oldCompany.setCorporateName(company.getCorporateName());
                    oldCompany.setCnpj(company.getCnpj());
                    oldCompany.setAddress(company.getAddress());
                    oldCompany.setCounty(company.getCounty());
                    oldCompany.setZipCode(company.getZipCode());
                    oldCompany.setPhone(company.getPhone());
                    oldCompany.setMail(company.getMail());
                    oldCompany.setTitularName(company.getTitularName());
                    oldCompany.setCpf(company.getCpf());

                    return new ResponseEntity<>(repository.save(oldCompany).toDto(), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
