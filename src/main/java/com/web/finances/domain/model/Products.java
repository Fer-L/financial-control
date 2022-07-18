package com.web.finances.domain.model;


import com.web.finances.api.dto.ProductsDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "PRODUCTS_TB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private double value;

    @NotNull
    private Long qtde;

    @NotNull
    private String nameProduct;

    @NotNull
    private String description;

    @NotNull
    private Long provider;


    public ProductsDTO toDto() {
        return new ProductsDTO(this);
    }

}
