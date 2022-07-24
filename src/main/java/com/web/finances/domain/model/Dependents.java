//package com.web.finances.domain.model;
//
//import com.web.finances.api.dto.AccountChartDTO;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.springframework.format.annotation.DateTimeFormat;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import java.time.LocalDate;
//import java.util.Set;
//
//
//@Entity
//@Table(name = "Dependents_TB")
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public class Dependents {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long dependent_id;
//
//    @ManyToOne
//    @JoinColumn(name="rsp_people_id", nullable=false)
//    private PersonalData people;
//
//    @ManyToOne
//    @JoinColumn(name="dpd_people_id", nullable=false)
//    private PersonalData people;
//
//    @ManyToOne
//    private boolean dpd_irrf;
//
//    public DependentsDTO toDto() {
//        return new DependentsDTO(this);
//    }
//}
