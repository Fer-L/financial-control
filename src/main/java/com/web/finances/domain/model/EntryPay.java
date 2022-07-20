package com.web.finances.domain.model;

import com.web.finances.api.dto.EntryPayDTO;
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
@Table(name = "ENTRY_PAY_TB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntryPay {
    //usei como contas a receber
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
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;


    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dueDate;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate emissionDate;



    public EntryPayDTO toDto() {
        return new EntryPayDTO(this);
    }
}
