package com.web.finances.api.dto;


import com.web.finances.domain.model.PersonalData;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PersonalDataDTO {

    private Long people_id;

    private String name;

    private String cpf;

    private LocalDate birth_date;

    private String email;

    private String phone;

    private String rua;

    private String bairro;

    private String cidade;

    public PersonalDataDTO(PersonalData pessoa) {
        this.people_id = pessoa.getPeople_id();
        this.name = pessoa.getName();
        this.cpf = pessoa.getCpf();
        this.birth_date = pessoa.getBirth_date();
        this.email = pessoa.getEmail();
        this.phone = pessoa.getPhone();
        this.rua = pessoa.getRua();
        this.bairro = pessoa.getBairro();
        this.cidade = pessoa.getCidade();
    }

}
