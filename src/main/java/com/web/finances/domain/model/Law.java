package com.web.finances.domain.model;

import com.web.finances.api.dto.LawDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "LAW_TB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Law {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String lawNumber;

    @NotNull
    private String lawDescription;

    public LawDTO toDto() {
        return new LawDTO(this);
    }
}

