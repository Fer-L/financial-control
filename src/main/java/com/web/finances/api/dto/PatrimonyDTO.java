package com.web.finances.api.dto;
import com.web.finances.domain.model.Patrimony;
import com.web.finances.domain.model.AccountChart;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PatrimonyDTO {
    private Long id;
    private String namePatrimony;
    private LocalDate buyDate;
    private double valuePatrimony;
    private int lifespan;
    private AccountChart accountChart;

    public PatrimonyDTO(Patrimony patrimony) {
        this.id = patrimony.getId();
        this.namePatrimony = patrimony.getNamePatrimony();
        this.buyDate = patrimony.getBuyDate();
        this.valuePatrimony = patrimony.getValuePatrimony();
        this.lifespan = patrimony.getLifespan();
        this.accountChart = patrimony.getAccountChart();
    }
}
