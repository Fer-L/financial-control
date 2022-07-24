package com.web.finances.api.dto;

import com.web.finances.domain.model.Bank;
import com.web.finances.domain.model.BankAccountEmployee;
import com.web.finances.domain.model.Employee;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

public class BankAccountEmployeeDTO {

    private Long id;

    private Bank bank;

    private Employee employee;

    private int conta;

    private String agencia;

    private int dv_agencia;

    private int dv_conta;


    public BankAccountEmployeeDTO(BankAccountEmployee bk) {
        this.id=bk.getId();
        this.bank=bk.getBank();
        this.employee=bk.getEmployee();
        this.agencia=bk.getAgencia();
        this.dv_agencia=bk.getDv_agencia();
    }

    }