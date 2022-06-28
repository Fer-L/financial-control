package com.web.finances.domain.repository;

import com.web.finances.domain.model.EntryPay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryPayRepository extends JpaRepository<EntryPay, Long> {
}
