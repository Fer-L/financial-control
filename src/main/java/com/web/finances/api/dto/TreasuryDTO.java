package com.web.finances.api.dto;
import com.web.finances.domain.model.AccountChart;
import com.web.finances.domain.model.Provider;
import com.web.finances.domain.model.Treasury;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

import com.web.finances.api.dto.AccountChartDTO;

@Getter
@Setter
public class TreasuryDTO {
    private Long id;
    private double value;
    private LocalDate emissionDate;
    private LocalDate dueDate;
    private LocalDate availabilityDate;
    private Long accountChart;
    private Long provider;


    public TreasuryDTO(Treasury treasury) {
        this.id = treasury.getId();
        this.value = treasury.getValue();
        this.emissionDate = treasury.getEmissionDate();
        this.dueDate = treasury.getDueDate();
        this.availabilityDate = treasury.getAvailabilityDate();
        this.provider = treasury.getProvider();
        this.accountChart = treasury.getAccountChart();
    }
}
