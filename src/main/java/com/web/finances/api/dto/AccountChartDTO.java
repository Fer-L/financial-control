package com.web.finances.api.dto;

import com.web.finances.domain.model.AccountChart;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class AccountChartDTO {
    private String classification;
    private String accountType;
    private String description;
    private Long bank;
    private LocalDate resourceEntry;
    private LocalDate resourceDeparture;

    public AccountChartDTO(AccountChart accountChart) {
        this.classification = accountChart.getClassification();
        this.accountType = accountChart.getAccountType();
        this.description = accountChart.getDescription();
        this.bank = accountChart.getBank();
        this.resourceEntry = accountChart.getResourceEntry();
        this.resourceDeparture = accountChart.getResourceDeparture();
    }

}
