package com.web.finances.domain.repository;

import com.web.finances.domain.model.Tax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxRepository  extends JpaRepository<Tax, Long> {
}
