package com.web.finances.api.dto;



import com.web.finances.domain.model.Professions;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class ProfessionsDTO {

    private Long id;

    private String professionName;

    private  int workload;

    public ProfessionsDTO(Professions profession) {
        this.id = profession.getId();
        this.professionName = profession.getProfessionName();
        this.workload = profession.getWorkload();
    }


}
