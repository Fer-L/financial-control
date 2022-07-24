package com.web.finances.domain.model;

import com.web.finances.api.dto.EmployeeDTO;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "Employee_TB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employee_id;

    @ManyToOne
    @JoinColumn(name="people_id", nullable=false)
    private PersonalData people;

    @ManyToOne
    @JoinColumn(name="company_id", nullable=false)
    private Company company;

    @ManyToOne
    @JoinColumn(name="profession_id", nullable=false)
    private Professions profession;

    @ManyToOne
    @JoinColumn(name="funds_id", nullable=false)
    private Funds funds;

    public EmployeeDTO toDto() {return new EmployeeDTO(this);}
}
