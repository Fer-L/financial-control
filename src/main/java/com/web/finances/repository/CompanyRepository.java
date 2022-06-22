package com.web.finances.repository;

import com.web.finances.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository
        extends JpaRepository<Company, Long> {
}
