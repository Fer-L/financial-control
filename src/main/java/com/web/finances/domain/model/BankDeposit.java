package com.web.finances.domain.model;

import com.web.finances.api.dto.BankDepositDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "BANK_DEPOSIT_TB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankDeposit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private double value;

    @NotNull
    private int isDeposit;

    @ManyToOne
    @JoinColumn(name="bankAccount_id", nullable=false)
    private BankAccount bankAccount;


    public BankDepositDTO toDto() {
        return new BankDepositDTO(this);
    }
}

