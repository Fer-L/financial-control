package com.web.finances.domain.model;

import com.web.finances.api.dto.PatrimonyDTO;
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
@Table(name = "PATRIMONY_TB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patrimony {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String namePatrimony;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate buyDate;

    @NotNull
    private double valuePatrimony;

    //vida útil
    @NotNull
    private int lifespan;

    @ManyToOne
    @JoinColumn(name="account_chart_id", nullable=false)
    private AccountChart accountChart;

    public PatrimonyDTO toDto() {
        return new PatrimonyDTO(this);
    }
}