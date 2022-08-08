package com.web.finances.domain.model;

import com.web.finances.api.dto.ItemPayDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.el.stream.Optional;
import org.springframework.http.ResponseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Map;

@Entity
@Table(name = "ITEM_PAY_TB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemPay {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="funds_id", nullable=false)
    private Funds funds;

    @NotNull
    private double valor;

    @ManyToOne
    @JoinColumn(name = "payroll")
    private Payroll payroll;

    public ItemPayDTO toDto() {
        return new ItemPayDTO(this);
    }

}
