package com.web.finances.domain.model;

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
@Table(name = "ACCOUNT_CHART_TB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountChart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String classification;

    @NotNull
    private String accountType;

    @NotNull
    private String description;

    @NotNull
    private Long bank;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate resourceEntry;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate resourceDeparture;

    @ManyToOne
    @JoinColumn(name="bankAccount_id", nullable=false)
    private BankAccount bankAccount;

    @OneToMany(mappedBy="accountChart")
    private Set<Treasury> treasurySet;
}
