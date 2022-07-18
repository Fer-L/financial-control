package com.web.finances.api.dto;

import com.web.finances.domain.model.Products;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductsDTO {

    private Long id;
    private double value;
    private Long qtde;
    private String nameProduct;
    private String description;
    private Long provider;

    public ProductsDTO(Products products) {
        this.id = products.getId();
        this.value = products.getValue();
        this.qtde = products.getQtde();
        this.nameProduct = products.getNameProduct();
        this.description = products.getDescription();
        this.provider = products.getProvider();

    }

}
