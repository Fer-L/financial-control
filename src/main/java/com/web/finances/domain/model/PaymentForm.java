package com.web.finances.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "ENTRY_PAY_TB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentForm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String description;

    @ManyToMany
    Set<Treasury> treasurySet;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "entryPay_id", referencedColumnName = "id")
    private EntryPay entryPay;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payWriteOff_id", referencedColumnName = "id")
    private PayWriteOff payWriteOff;
}