package com.web.finances.domain.model;

import com.web.finances.api.dto.ProviderDTO;
import com.web.finances.api.dto.ReceiveWriteOffDTO;
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
    //RECEBER ESCRITURA

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

//    @OneToOne(mappedBy = "receiveWriteOff")
//    private EntryReceive entryReceive;

    public ReceiveWriteOffDTO toDto() {
        return new ReceiveWriteOffDTO(this);
    }
}
