package com.web.finances.domain.repository;

import com.web.finances.domain.model.ItemPay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ItemPayRepository extends JpaRepository<ItemPay, Long> {
    
//    List<ItemPay> findByPayroll(Long payroll);

}
