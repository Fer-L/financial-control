package com.web.finances.api.dto;

import com.web.finances.domain.model.Funds;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class FundsDTO {

    private Long funds_id;

    private  String name;

    private String provento;


    public FundsDTO(Funds funds) {
        this.funds_id = funds.getFunds_id();
        this.name = funds.getName();
        this.provento = funds.getProvento();
    }


}
