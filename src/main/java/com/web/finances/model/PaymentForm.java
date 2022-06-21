package com.web.finances.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
// import javax.validation.constraints.NotNull;
// import java.time.LocalDate;

@Entity
@Table(name = "ENTRY_PAY_TB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentForm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String description;
}
