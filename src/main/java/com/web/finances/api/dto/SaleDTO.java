package com.web.finances.api.dto;

import com.web.finances.domain.model.Customer;
import com.web.finances.domain.model.Products;
import com.web.finances.domain.model.Sale;

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

    private LocalDate emissionDate;
    private List<Products> products;

    public SaleDTO(Sale sale) {
        this.id = sale.getId();
        this.value = sale.getValue();
        this.emissionDate = sale.getEmissionDate();
        this.customer = sale.getCustomer();
        this.products = sale.getProducts();
    }

}