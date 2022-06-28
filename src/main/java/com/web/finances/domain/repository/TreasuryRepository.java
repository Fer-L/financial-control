package com.web.finances.domain.repository;

import com.web.finances.domain.model.Treasury;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreasuryRepository extends JpaRepository<Treasury, Long> {
}
