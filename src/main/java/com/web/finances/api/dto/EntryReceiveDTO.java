package com.web.finances.api.dto;
import com.web.finances.domain.model.EntryReceive;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class EntryReceiveDTO {
    private String docNumber;
    private double titleValue;
    private LocalDate dueDate;
    private LocalDate emissionDate;



    public EntryReceiveDTO(EntryReceive entryReceive) {
        this.docNumber = entryReceive.getDocNumber();
        this.titleValue = entryReceive.getTitleValue();
        this.dueDate = entryReceive.getDueDate();
        this.emissionDate = entryReceive.getEmissionDate();
    }
}
