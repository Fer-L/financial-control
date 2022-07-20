package com.web.finances.domain.model;

import com.web.finances.api.dto.ReceiveWriteOffDTO;
import com.web.finances.api.dto.TreasuryDTO;
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
@Table(name = "TREASURY_DB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Treasury {
    //TESOURARIA
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private double value;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate emissionDate;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dueDate;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate availabilityDate;

    @NotNull
    private Long accountChart;

    @NotNull
    private Long provider;



    public TreasuryDTO toDto() {
        return new TreasuryDTO(this);
    }
}
