package com.web.finances.api.dto;

import com.web.finances.domain.model.Employee;
import com.web.finances.domain.model.Company;
import com.web.finances.domain.model.Professions;
import com.web.finances.domain.model.Funds;
import com.web.finances.domain.model.PersonalData;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
public class EmployeeDTO {

    private Long employee_id;

    private PersonalData people;

    private Company company;

    private Professions profession;

    private Funds funds;

    public EmployeeDTO(Employee employee) {
        this.employee_id = employee.getEmployee_id();
        this.people = employee.getPeople();
        this.company = employee.getCompany();
        this.profession = employee.getProfession();
        this.funds = employee.getFunds();
    }


}
