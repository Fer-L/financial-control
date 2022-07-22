package com.web.finances.api.dto;


import com.web.finances.domain.model.BankAccount;
import com.web.finances.domain.model.BankDeposit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankDepositDTO {
    private long id;
    private double value;
    private int isDeposit;
    private BankAccount bankAccount;
    public BankDepositDTO(BankDeposit bankDeposit) {
        this.id = bankDeposit.getId();
        this.value = bankDeposit.getValue();
        this.isDeposit = bankDeposit.getIsDeposit();
        this.bankAccount = bankDeposit.getBankAccount();

    }

}

