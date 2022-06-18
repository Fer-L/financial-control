package com.web.finances.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "RECEIVE_WRITE_OFF_TB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReceiveWriteOff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String bank;

    @NotNull
    private String availability;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dischargeDate;

    @NotNull
    private Long paidValue;

    @NotNull
    private String residual;
}
