package com.web.finances.api.dto;
import com.web.finances.domain.model.ReceiveWriteOff;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class ReceiveWriteOffDTO {
    private String bank;
    private String availability;
    private LocalDate dischargeDate;
    private Long paidValue;
    private String residual;

    public ReceiveWriteOffDTO(ReceiveWriteOff receiveWriteOff) {
        this.bank = receiveWriteOff.getBank();
        this.availability = receiveWriteOff.getAvailability();
        this.dischargeDate = receiveWriteOff.getDischargeDate();
        this.paidValue = receiveWriteOff.getPaidValue();
        this.residual = receiveWriteOff.getResidual();
    }
}
