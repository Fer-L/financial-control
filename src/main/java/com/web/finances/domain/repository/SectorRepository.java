package com.web.finances.domain.repository;

import com.web.finances.domain.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectorRepository  extends JpaRepository<Sector, Long> {
}

