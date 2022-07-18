package com.web.finances.domain.model;

import com.web.finances.api.dto.EntryPayDTO;
import com.web.finances.api.dto.EntryReceiveDTO;
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
@Table(name = "ENTRY_RECEIVE_TB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntryReceive {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String docNumber;

    @NotNull
    private double titleValue;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dueDate;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate emissionDate;

    @ManyToMany
    Set<EntryPay> entryPays;

    @OneToOne(mappedBy = "entryReceive")
    private Provider provider;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "receiveWriteOff_id", referencedColumnName = "id")
    private ReceiveWriteOff receiveWriteOff;

    @ManyToOne
    @JoinColumn(name="company_id", nullable=false)
    private Company company;

    public EntryReceiveDTO toDto() {
        return new EntryReceiveDTO(this);
    }
}
