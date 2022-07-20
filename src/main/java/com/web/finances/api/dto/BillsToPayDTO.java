package com.web.finances.api.dto;
import com.web.finances.domain.model.BillsToPay;
import com.web.finances.domain.model.Provider;
import com.web.finances.domain.model.Company;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class BillsToPayDTO {

    private Long id;
    private String docNumber;
    private double titleValue;
    private LocalDate dueDate;
    private LocalDate emissionDate;
    private Company company;
    private Provider provider;

    public BillsToPayDTO(BillsToPay billsToPay) {
        this.id = billsToPay.toDto().getId();
        this.docNumber = billsToPay.getDocNumber();
        this.titleValue = billsToPay.getTitleValue();
        this.dueDate = billsToPay.getDueDate();
        this.emissionDate = billsToPay.getEmissionDate();
        this.company = billsToPay.getCompany();
        this.provider = billsToPay.getProvider();
    }


}
