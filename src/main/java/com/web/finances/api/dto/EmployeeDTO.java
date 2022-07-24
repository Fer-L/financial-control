package com.web.finances.api.dto;

import com.web.finances.domain.model.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
public class EmployeeDTO {

    private Long id;

    private PersonalData people;

    private Company company;

    private Professions profession;

    private Funds funds;

    private HealthPlan healthPlan;
    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.people = employee.getPeople();
        this.company = employee.getCompany();
        this.profession = employee.getProfession();
        this.funds = employee.getFunds();
        this.healthPlan=employee.getHealthPlan();
    }


}
