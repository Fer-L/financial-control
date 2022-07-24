package com.web.finances.api.dto;



import com.web.finances.domain.model.Professions;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
public class ProfessionsDTO {

    private Long profession_id;

    private String profession_name;

    private  int workload;

    public ProfessionsDTO(Professions profession) {
        this.profession_id = profession.getProfession_id();
        this.profession_name = profession.getProfession_name();
        this.workload = profession.getWorkload();
    }


}
