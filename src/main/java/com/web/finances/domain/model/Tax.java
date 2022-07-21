package com.web.finances.domain.model;

import com.web.finances.api.dto.TaxDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TAX_TB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tax {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private double percent;

    @NotNull
    private String nameTax;

    //esfera (municipal, estadual, federal)
    @NotNull
    private String scope;


    public TaxDTO toDto() {
        return new TaxDTO(this);
    }

}