package com.web.finances.api.dto;
import com.web.finances.domain.model.Company;
import com.web.finances.domain.model.Customer;
import com.web.finances.domain.model.EntryPay;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class EntryPayDTO {
    private Long id;
    private String docNumber;
    private double titleValue;
    private LocalDate dueDate;
    private LocalDate emissionDate;
    private Company company;
    private Customer customer;


    public EntryPayDTO(EntryPay entryPay) {
        this.id = entryPay.getId();
        this.docNumber = entryPay.getDocNumber();
        this.titleValue = entryPay.getTitleValue();
        this.dueDate = entryPay.getDueDate();
        this.emissionDate = entryPay.getEmissionDate();
        this.company = entryPay.getCompany();
        this.customer = entryPay.getCustomer();
    }
}
