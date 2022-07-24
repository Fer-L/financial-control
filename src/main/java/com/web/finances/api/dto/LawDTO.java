package com.web.finances.api.dto;
import com.web.finances.domain.model.Law;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LawDTO {
    private Long id;
    private String lawNumber;
    private String lawDescription;

    public LawDTO(Law law) {
        this.id = law.getId();
        this.lawNumber = law.getLawNumber();
        this.lawDescription = law.getLawDescription();
    }
}


