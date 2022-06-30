package com.web.finances.api.dto;
import com.web.finances.domain.model.Company;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    public CompanyDTO(Company company) {
        this.id = company.getId();
        this.corporateName = company.getCorporateName();
        this.cnpj = company.getCnpj();
        this.address = company.getAddress();
        this.county = company.getCounty();
        this.zipCode = company.getZipCode();
        this.phone = company.getPhone();
        this.mail = company.getMail();
        this.titularName = company.getTitularName();
        this.cpf = company.getCpf();
    }
}
