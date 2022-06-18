package com.web.finances.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "COMPANY_TB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String corporateName;

    @NotNull
    private String cnpj;

    @NotNull
    private String address;

    @NotNull
    private String county;

    @NotNull
    private String zipCode;

    @NotNull
    private String phone;

    @NotNull
    private String mail;

    @NotNull
    private String titularName;

    @NotNull
    private String cpf;


}
