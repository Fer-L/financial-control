package com.web.finances.domain.repository;

import com.web.finances.domain.model.Law;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LawRepository extends JpaRepository<Law, Long> {
}