package com.web.finances.domain.model;

import com.web.finances.api.dto.HealthPlanDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;
@Entity
@Table(name = "HEALTH_PLAN_TB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HealthPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String operadora;

    private String codigoAns;


    public HealthPlanDTO toDto() {
        return new HealthPlanDTO(this);
    }
}

