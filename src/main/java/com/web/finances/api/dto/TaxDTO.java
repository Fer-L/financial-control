package com.web.finances.api.dto;

import com.web.finances.domain.model.Law;
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
    private Law law;
    public TaxDTO(Tax tax) {
        this.id = tax.getId();
        this.percent = tax.getPercent();
        this.nameTax = tax.getNameTax();
        this.scope = tax.getScope();
        this.law = tax.getLaw();
    }

}