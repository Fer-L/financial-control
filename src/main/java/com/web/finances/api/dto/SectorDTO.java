package com.web.finances.api.dto;

import com.web.finances.domain.model.Company;
import com.web.finances.domain.model.Sector;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SectorDTO {
    private Long id;
    private String nameSector;
    private Company company;

    public SectorDTO(Sector products) {
        this.id = products.getId();
        this.nameSector = products.getNameSector();
        this.company = products.getCompany();
    }
}
