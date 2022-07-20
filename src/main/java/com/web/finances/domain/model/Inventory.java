package com.web.finances.domain.model;

import com.web.finances.api.dto.InventoryDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "INVENTORY_TB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private double estimatedSalePrice;

    @NotNull
    private int qtde;

    @ManyToOne
    @JoinColumn(name="provider_id", nullable=false)
    private Products products;

    public InventoryDTO toDto() {
        return new InventoryDTO(this);
    }
}
