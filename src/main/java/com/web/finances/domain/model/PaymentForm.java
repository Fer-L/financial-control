package com.web.finances.domain.model;

import com.web.finances.api.dto.EntryReceiveDTO;
import com.web.finances.api.dto.PaymentFormDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    private Long id;

    @NotNull
    private String description;

    @ManyToMany
    Set<Treasury> treasurySet;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "entryPay_id", referencedColumnName = "id")
    private EntryPay entryPay;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payWriteOff_id", referencedColumnName = "id")
    private PayWriteOff payWriteOff;

    public PaymentFormDTO toDto() {
        return new PaymentFormDTO(this);
    }
}
