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
@Table(name = "PAYMENT_FORM_TB")
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


    public PaymentFormDTO toDto() {
        return new PaymentFormDTO(this);
    }
}
