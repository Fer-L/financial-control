package com.web.finances.domain.model;

import com.web.finances.api.dto.BillsToPayDTO;
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
@Table(name = "BILLS_TO_PAY_TB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BillsToPay {
    //usei como contas a pagar
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String docNumber;

    @NotNull
    private double titleValue;

    @ManyToOne
    @JoinColumn(name="company_id", nullable=false)
    private Company company;

    @ManyToOne
    @JoinColumn(name="provider_id", nullable=false)
    private Provider provider;


    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dueDate;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate emissionDate;

//    @ManyToMany
//    Set<Treasury> treasuries;
//
//    @ManyToMany
//    Set<EntryReceive> entryReceives;
//
//    @OneToMany(mappedBy="entryPay")
//    private Set<PayWriteOff> payWriteOffs;
//
//    @OneToOne(mappedBy = "entryPay")
//    private PaymentForm paymentForm;


    public BillsToPayDTO toDto() {
        return new BillsToPayDTO(this);
    }

}
