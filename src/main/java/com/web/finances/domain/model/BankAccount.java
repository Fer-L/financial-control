package com.web.finances.domain.model;

import com.web.finances.api.dto.AccountChartDTO;
import com.web.finances.api.dto.BankAccountDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

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
    private String cnpjCompany;

    @NotNull
    private Long bank;



    @OneToMany(mappedBy="bankAccount")
    private Set<AccountChart> accountChartSet;

    public BankAccountDTO toDto() {
        return new BankAccountDTO(this);
    }
}
