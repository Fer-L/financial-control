package com.web.finances.domain.model;

import com.web.finances.api.dto.BankDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Bank_TB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String nameBank;

    @NotNull
    private int febrabanCode;

    @NotNull
    private String cnpj;


    public BankDTO toDto() {
        return new BankDTO(this);
    }
}

