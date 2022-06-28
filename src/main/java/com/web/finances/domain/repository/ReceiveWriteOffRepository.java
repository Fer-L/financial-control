package com.web.finances.domain.repository;

import com.web.finances.domain.model.ReceiveWriteOff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiveWriteOffRepository extends JpaRepository<ReceiveWriteOff, Long> {
}
