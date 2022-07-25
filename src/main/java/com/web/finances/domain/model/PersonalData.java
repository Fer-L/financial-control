package com.web.finances.domain.model;

import com.web.finances.api.dto.PersonalDataDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;



@Entity
@Table(name = "PersonalData_TB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonalData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String cpf;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    private String email;

    private String phone;

    private String rua;

    private String bairro;

    private String cidade;


    public PersonalDataDTO toDto() {
        return new PersonalDataDTO(this);
    }
}
