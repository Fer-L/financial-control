package com.web.finances.domain.model;

import com.web.finances.api.dto.PayrollDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "Payroll_TB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne
    @JoinColumn(name="employee_id", nullable=false)
    private Employee employee;


    @NotNull
    private double valorBruto;

    private double valorDesconto;

    private double valorLiquido;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPagamento;




    public PayrollDTO toDto() {
        return new PayrollDTO(this);
    }
}
