package com.web.finances.domain.model;


import com.web.finances.api.dto.SaleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "SALE_TB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private double value;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate emissionDate;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="tax_id", nullable=false)
    private Tax tax;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name="products_sale",
            joinColumns={@JoinColumn(name="sale_tb_id")})
    private List<Products> products;

    public SaleDTO toDto() {
        return new SaleDTO(this);
    }

}