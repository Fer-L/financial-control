package com.web.finances.api.dto;
import com.web.finances.domain.model.Provider;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProviderDTO {

    private long id;
    private String corporateName;
    private String cnpjCpf;
    private String address;
    private String county;
    private String zipCode;
    private String phone;
    private String mail;

    public ProviderDTO(Provider provider) {

        this.id = provider.getId();
        this.corporateName = provider.getCorporateName();
        this.cnpjCpf = provider.getCnpjCpf();
        this.address = provider.getAddress();
        this.county = provider.getCounty();
        this.zipCode = provider.getZipCode();
        this.phone = provider.getPhone();
        this.mail = provider.getMail();
    }
}
