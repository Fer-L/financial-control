package com.web.finances.domain.repository;

import com.web.finances.domain.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
