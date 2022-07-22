package com.web.finances.api.dto;
import com.web.finances.domain.model.PaymentForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentFormDTO {
    private Long id;
    private String description;

    public PaymentFormDTO(PaymentForm paymentForm) {
        this.id = paymentForm.getId();
        this.description = paymentForm.getDescription();
    }
}
