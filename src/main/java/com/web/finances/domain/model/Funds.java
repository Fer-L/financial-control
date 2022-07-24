package com.web.finances.domain.model;

import com.web.finances.api.dto.FundsDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "Funds_TB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Funds {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long funds_id;

    @NotNull
    private  String name;

    @NotNull
    private String provento;



    public FundsDTO toDto() {
        return new FundsDTO(this);
    }
}
