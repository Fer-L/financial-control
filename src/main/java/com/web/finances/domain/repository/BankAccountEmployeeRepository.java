package com.web.finances.domain.repository;

import com.web.finances.domain.model.BankAccountEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountEmployeeRepository extends JpaRepository<BankAccountEmployee, Long> {
}
