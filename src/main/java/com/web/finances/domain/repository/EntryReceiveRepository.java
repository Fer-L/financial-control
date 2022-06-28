package com.web.finances.domain.repository;

import com.web.finances.domain.model.EntryReceive;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryReceiveRepository extends JpaRepository<EntryReceive, Long> {
}
