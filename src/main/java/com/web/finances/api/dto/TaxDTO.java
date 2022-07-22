package com.web.finances.api.dto;

import com.web.finances.domain.model.Tax;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaxDTO {
    private Long id;
    private double percent;
    private String nameTax;
    private String scope;

    public TaxDTO(Tax products) {
        this.id = products.getId();
        this.percent = products.getPercent();
        this.nameTax = products.getNameTax();
        this.scope = products.getScope();
    }

}