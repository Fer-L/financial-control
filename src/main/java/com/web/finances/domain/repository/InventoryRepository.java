package com.web.finances.domain.repository;

import com.web.finances.domain.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}