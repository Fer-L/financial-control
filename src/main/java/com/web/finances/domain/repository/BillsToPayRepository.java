package com.web.finances.domain.repository;

import com.web.finances.domain.model.BillsToPay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillsToPayRepository extends JpaRepository<BillsToPay, Long> {
}


