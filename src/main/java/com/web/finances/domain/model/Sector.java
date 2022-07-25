package com.web.finances.domain.model;


import com.web.finances.api.dto.SectorDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "SECTOR_TB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String nameSector;

    @ManyToOne
    @JoinColumn(name="company_id", nullable=false)
    private Company company;




    public SectorDTO toDto() {
        return new SectorDTO(this);
    }

}



