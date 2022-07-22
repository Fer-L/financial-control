package com.web.finances.api.dto;

import com.web.finances.domain.model.AccountChart;
import com.web.finances.domain.model.BankAccount;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class AccountChartDTO {
    private long id;
    private String classification;
    private String accountType;
    private String description;
    private Long aspect;
    private BankAccount bankAccount;
    public AccountChartDTO(AccountChart accountChart) {
        this.id = accountChart.getId();
        this.classification = accountChart.getClassification();
        this.accountType = accountChart.getAccountType();
        this.description = accountChart.getDescription();
        this.aspect = accountChart.getAspect();
        this.bankAccount=accountChart.getBankAccount();
    }

}
