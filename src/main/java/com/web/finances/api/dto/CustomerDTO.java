package com.web.finances.api.dto;
import com.web.finances.domain.model.Customer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
    private String corporateName;
    private String cnpjCpf;
    private String address;
    private String county;
    private String zipCode;
    private String phone;
    private String mail;

    public CustomerDTO(Customer customer) {
        this.corporateName = customer.getCorporateName();
        this.cnpjCpf = customer.getCnpjCpf();
        this.address = customer.getAddress();
        this.county = customer.getCounty();
        this.zipCode = customer.getZipCode();
        this.phone = customer.getPhone();
        this.mail = customer.getMail();
    }
}

