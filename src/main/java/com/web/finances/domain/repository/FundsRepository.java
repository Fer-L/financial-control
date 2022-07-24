package com.web.finances.domain.repository;

import com.web.finances.domain.model.Funds;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FundsRepository extends JpaRepository<Funds, Long> {
}
