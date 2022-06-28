package com.web.finances.domain.service;

import com.web.finances.domain.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository repository;
}
