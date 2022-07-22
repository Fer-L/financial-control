package com.web.finances.api.dto;

import com.web.finances.domain.model.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class SaleDTO {
    private Long id;
    private double value;
    private Customer customer;
    private Tax tax;
    private LocalDate emissionDate;
    private List<Products> products;
    private PaymentForm paymentForm;

    public SaleDTO(Sale sale) {
        this.id = sale.getId();
        this.value = sale.getValue();
        this.emissionDate = sale.getEmissionDate();
        this.customer = sale.getCustomer();
        this.tax = sale.getTax();
        this.products = sale.getProducts();
        this.paymentForm = sale.getPaymentForm();
    }

}