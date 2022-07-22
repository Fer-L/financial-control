package com.web.finances.domain.repository;

import com.web.finances.domain.model.BankDeposit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankDepositRepository extends JpaRepository<BankDeposit, Long> {
}

