package com.web.finances.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "BANK_ACCOUNT_TB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String classification;

    @NotNull
    private String description;

    @NotNull
    private String accountNumber;

    @NotNull
    private String agencyNumber;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate inicialBalanceDate;

    @NotNull
    private BigDecimal inicialBalance;

    @NotNull
    private Long bank;
}
