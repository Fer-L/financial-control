package com.web.finances.domain.model;

import com.web.finances.api.dto.CustomerDTO;
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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String docNumber;

    @NotNull
    private double titleValue;

    @NotNull
    private Long companyId;

    @NotNull
    private Long customerId;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dueDate;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate emissionDate;

    @ManyToMany
    Set<Treasury> treasuries;

    @ManyToMany
    Set<EntryReceive> entryReceives;

    @OneToMany(mappedBy="entryPay")
    private Set<PayWriteOff> payWriteOffs;

    @OneToOne(mappedBy = "entryPay")
    private PaymentForm paymentForm;


    public EntryPayDTO toDto() {
        return new EntryPayDTO(this);
    }
}
