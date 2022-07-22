package com.web.finances.api.dto;
import com.web.finances.domain.model.BankAccount;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class BankAccountDTO {

    private Long id;
    private String classification;
    private String description;
    private String accountNumber;
    private String agencyNumber;
    private LocalDate inicialBalanceDate;
    private BigDecimal inicialBalance;
    private Long bank;
    private String cnpjCompany;

    public BankAccountDTO(BankAccount bankAccount) {
        this.id = bankAccount.getId();
        this.classification = bankAccount.getClassification();
        this.description = bankAccount.getDescription();
        this.accountNumber = bankAccount.getAccountNumber();
        this.agencyNumber = bankAccount.getAgencyNumber();
        this.inicialBalanceDate = bankAccount.getInicialBalanceDate();
        this.inicialBalance = bankAccount.getInicialBalance();
        this.bank = bankAccount.getBank();
        this.cnpjCompany = bankAccount.getCnpjCompany();
    }
}
