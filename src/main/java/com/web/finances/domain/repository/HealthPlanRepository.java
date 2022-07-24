package com.web.finances.domain.repository;

import com.web.finances.domain.model.HealthPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthPlanRepository extends JpaRepository<HealthPlan, Long> {

}
