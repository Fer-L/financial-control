package com.web.finances.api.dto;
import com.web.finances.domain.model.EntryPay;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class EntryPayDTO {
    private String docNumber;
    private Long titleValue;
    private LocalDate dueDate;
    private LocalDate emissionDate;

    public EntryPayDTO(EntryPay entryPay) {
        this.docNumber = entryPay.getDocNumber();
        this.titleValue = entryPay.getTitleValue();
        this.dueDate = entryPay.getDueDate();
        this.emissionDate = entryPay.getEmissionDate();
    }
}
