package com.web.finances.domain.model;


import com.web.finances.api.dto.ProductsDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


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
    private String nameProduct;

    @NotNull
    private String description;

    @ManyToOne
    @JoinColumn(name="company_id", nullable=false)
    private Company company;

    @ManyToOne
    @JoinColumn(name="provider_id", nullable=true)
    private Provider provider;


    public ProductsDTO toDto() {
        return new ProductsDTO(this);
    }

}
