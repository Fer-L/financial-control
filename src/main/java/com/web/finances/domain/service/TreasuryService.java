package com.web.finances.domain.service;

import com.web.finances.domain.repository.TreasuryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreasuryService {

    @Autowired
    TreasuryRepository repository;
}
