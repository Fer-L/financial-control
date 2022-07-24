package com.web.finances.api.dto;

import com.web.finances.domain.model.Employee;
import com.web.finances.domain.model.Funds;
import com.web.finances.domain.model.Payroll;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

public class PayrollDTO {

    private Long payroll_id;

    private Employee employee;

    private Funds funds;

    private double valor;

    private String referencia;


    private String ano;


    private  String mes;


    public PayrollDTO (Payroll pay) {
        this.payroll_id=pay.getPayroll_id();
        this.employee=pay.getEmployee();
        this.funds=pay.getFunds();
        this.valor=pay.getValor();
        this.referencia=pay.getReferencia();
        this.ano=pay.getAno();
        this.mes=pay.getMes();
        this.referencia=pay.getReferencia();
    }

}
