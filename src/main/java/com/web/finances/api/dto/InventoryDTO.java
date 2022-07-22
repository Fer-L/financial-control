package com.web.finances.api.dto;

import com.web.finances.domain.model.Products;
import com.web.finances.domain.model.Inventory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryDTO {
    private Long id;
    private double estimatedSalePrice;
    private int qtde;
    private Products products;

    public InventoryDTO(Inventory inventory) {
        this.id = inventory.getId();
        this.estimatedSalePrice = inventory.getEstimatedSalePrice();
        this.qtde = inventory.getQtde();
        this.products = inventory.getProducts();
    }
}
