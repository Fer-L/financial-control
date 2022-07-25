package com.web.finances.api.dto;
import com.web.finances.domain.model.Bank;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class BankDTO {
    private Long id;
    private String nameBank;
    private int febrabanCode;
    private String cnpj;

    public BankDTO(Bank bank) {
        this.id = bank.getId();
        this.nameBank = bank.getNameBank();
        this.febrabanCode = bank.getFebrabanCode();
        this.cnpj = bank.getCnpj();

    }
}

