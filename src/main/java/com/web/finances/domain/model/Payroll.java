package com.web.finances.domain.model;

import com.web.finances.api.dto.PayrollDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PAYROLL_TB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private int payYear;

    @NotNull
    private int payMount;

    @ManyToOne
    @JoinColumn(name="employee_id", nullable=false)
    private Employee employee;

//    @OneToMany(mappedBy = "payroll")
//    private Set<ItemPay> itemPays;

    public PayrollDTO toDto() {
        return new PayrollDTO(this);
    }
}
