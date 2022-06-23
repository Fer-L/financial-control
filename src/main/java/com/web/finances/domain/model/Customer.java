package com.web.finances.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "CUSTOMER_TB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    //parceiro
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String corporateName;

    @NotNull
    private String cnpjCpf;

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

    @OneToMany(mappedBy="customer")
    private Set<EntryReceive> entryReceives;
}
