package com.web.finances.api.dto;

import com.web.finances.domain.model.Employee;
import com.web.finances.domain.model.Funds;
import com.web.finances.domain.model.Payroll;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Getter
@Setter
public class PayrollDTO {

    private Long id;

    private Employee employee;


    private double valorBruto;

    private double valorDesconto;


    private double valorLiquido;

    private LocalDate dataPagamento;


    public PayrollDTO (Payroll pay) {
        this.id=pay.getId();
        this.employee=pay.getEmployee();
        this.valorBruto=pay.getValorBruto();
        this.valorDesconto=pay.getValorDesconto();
        this.valorLiquido=pay.getValorBruto()-pay.getValorDesconto();
        this.dataPagamento=pay.getDataPagamento();
    }

}
