package com.web.finances.api.dto;

import com.web.finances.domain.model.Bank;
import com.web.finances.domain.model.BankAccountEmployee;
import com.web.finances.domain.model.Employee;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankAccountEmployeeDTO {

    private Long id;

    private Bank bank;

    private Employee employee;

    private String conta;

    private String agencia;

    private String dvAgencia;

    private String dvConta;

    public BankAccountEmployeeDTO(BankAccountEmployee bk) {
        this.id=bk.getId();
        this.bank=bk.getBank();
        this.employee=bk.getEmployee();
        this.conta=bk.getConta();
        this.agencia=bk.getAgencia();
        this.dvAgencia=bk.getDvAgencia();
        this.dvConta=bk.getDvConta();
    }

    }