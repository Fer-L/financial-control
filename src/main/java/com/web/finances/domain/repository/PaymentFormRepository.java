package com.web.finances.domain.repository;

import com.web.finances.domain.model.PaymentForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentFormRepository extends JpaRepository<PaymentForm, Long> {
}
