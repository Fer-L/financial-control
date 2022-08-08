package com.web.finances.api.dto;

import com.web.finances.domain.model.Employee;
import com.web.finances.domain.model.Payroll;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PayrollDTO {
    private Long id;
    private Employee employee;

    public PayrollDTO (Payroll pay) {
        this.id=pay.getId();
        this.employee=pay.getEmployee();
    }
}
