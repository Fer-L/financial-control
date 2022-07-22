package com.web.finances.domain.repository;

import com.web.finances.domain.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository  extends JpaRepository<Sale, Long> {
}
