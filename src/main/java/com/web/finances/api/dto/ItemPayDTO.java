package com.web.finances.api.dto;


import com.web.finances.domain.model.*;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ItemPayDTO {

    private Long id;
    private Funds funds;
    private double valor;
    private Payroll payroll;
    public ItemPayDTO(ItemPay pay) {
        this.id = pay.getId();
        this.funds = pay.getFunds();
        this.valor = pay.getValor();
        this.payroll = pay.getPayroll();
    }

}


