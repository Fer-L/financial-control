package com.web.finances.domain.repository;

import com.web.finances.domain.model.PersonalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalDataRepository extends JpaRepository<PersonalData, Long> {
}
