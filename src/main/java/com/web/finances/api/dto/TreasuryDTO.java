package com.web.finances.api.dto;
import com.web.finances.domain.model.Treasury;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class TreasuryDTO {
    private Long value;
    private LocalDate emissionDate;
    private LocalDate dueDate;
    private LocalDate availabilityDate;


    public TreasuryDTO(Treasury treasury) {
        this.value = treasury.getValue();
        this.emissionDate = treasury.getEmissionDate();
        this.dueDate = treasury.getDueDate();
        this.availabilityDate = treasury.getAvailabilityDate();
    }
}
