package com.web.finances.dtos;
import lombok.Data;

@Data
public class CompanyDTO {
    private Long id;
    private String corporateName;
    private String cnpj;
    private String address;
    private String county;
    private String zipCode;
    private String phone;
    private String mail;
    private String titularName;
    private String cpf;
}
