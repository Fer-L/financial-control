package com.web.finances.api.dto;
import com.web.finances.domain.model.HealthPlan;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HealthPlanDTO {
    private Long id;
    private String operadora;

    private String codigoAns;
    public HealthPlanDTO(HealthPlan healthPlan) {
        this.id = healthPlan.getId();
        this.operadora = healthPlan.getOperadora();
        this.codigoAns = healthPlan.getCodigoAns();
    }
}
