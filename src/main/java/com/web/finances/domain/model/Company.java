package com.web.finances.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

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

    @OneToMany(mappedBy="company")
    private Set<EntryPay> entryPays;

    @OneToMany(mappedBy="company")
    private Set<EntryReceive> entryReceives;

    @OneToMany(mappedBy="company")
    private Set<EntryPay> entryPaysCompany;
}