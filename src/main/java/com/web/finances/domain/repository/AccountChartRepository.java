package com.web.finances.domain.repository;

import com.web.finances.domain.model.AccountChart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountChartRepository extends JpaRepository<AccountChart, Long> {
}
