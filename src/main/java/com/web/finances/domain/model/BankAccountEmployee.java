package com.web.finances.domain.model;

import com.web.finances.api.dto.BankAccountEmployeeDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "BankAccountEmployee_TB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="bank_id", nullable=false)
    private Bank bank;

    @ManyToOne
    @JoinColumn(name="employee_id", nullable=false)
    private Employee employee;

    @NotNull
    private int conta;

    @NotNull
    private String agencia;

    @NotNull
    private int dv_agencia;

    @NotNull
    private int dv_conta;


    public BankAccountEmployeeDTO toDto() {
        return new BankAccountEmployeeDTO(this);
    }
}
