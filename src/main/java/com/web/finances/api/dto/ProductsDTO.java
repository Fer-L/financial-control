package com.web.finances.api.dto;

import com.web.finances.domain.model.Company;
import com.web.finances.domain.model.Products;

import com.web.finances.domain.model.Provider;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductsDTO {
    private Long id;
    private double value;
    private String nameProduct;
    private String description;
    private Provider provider;
    private Company company;

    public ProductsDTO(Products products) {
        this.id = products.getId();
        this.value = products.getValue();
        this.nameProduct = products.getNameProduct();
        this.description = products.getDescription();
        this.provider = products.getProvider();
        this.company = products.getCompany();
    }

}
