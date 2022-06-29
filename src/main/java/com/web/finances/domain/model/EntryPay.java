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
    private Long titleValue;

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

    @ManyToOne
    @JoinColumn(name="company_id", nullable=false)
    private Company company;

    public EntryPayDTO toDto() {
        return new EntryPayDTO(this);
    }
}
