package com.web.finances.api.dto;
import com.web.finances.domain.model.PayWriteOff;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class PayWriteOffDTO {
    private String bank;
    private String availability;
    private LocalDate dischargeDate;
    private double paidValue;
    private String residual;

    public PayWriteOffDTO(PayWriteOff payWriteOff) {
        this.bank = payWriteOff.getBank();
        this.availability = payWriteOff.getAvailability();
        this.dischargeDate = payWriteOff.getDischargeDate();
        this.paidValue = payWriteOff.getPaidValue();
        this.residual = payWriteOff.getResidual();
    }
}
