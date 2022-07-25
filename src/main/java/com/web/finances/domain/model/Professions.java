package com.web.finances.domain.model;

import com.web.finances.api.dto.ProfessionsDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "Professions_TB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Professions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String professionName;

    @NotNull
    private  int workload;

    public ProfessionsDTO toDto() {
        return new ProfessionsDTO(this);
    }
}
