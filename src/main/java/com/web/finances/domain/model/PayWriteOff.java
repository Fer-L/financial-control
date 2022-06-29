package com.web.finances.domain.model;

import com.web.finances.api.dto.PayWriteOffDTO;
import com.web.finances.api.dto.PaymentFormDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "PAY_WRITE_OFF_TB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PayWriteOff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String bank;

    @NotNull
    private String availability;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dischargeDate;

    @NotNull
    private Long paidValue;

    @NotNull
    private String residual;

    @ManyToOne
    @JoinColumn(name="entryPay_id", nullable=false)
    private EntryPay entryPay;

    @OneToOne(mappedBy = "payWriteOff")
    private PaymentForm paymentForm;

    public PayWriteOffDTO toDto() {
        return new PayWriteOffDTO(this);
    }
}
