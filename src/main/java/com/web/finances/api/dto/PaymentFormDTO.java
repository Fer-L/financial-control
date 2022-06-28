package com.web.finances.api.dto;
import com.web.finances.domain.model.PaymentForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentFormDTO {
    private String description;

    public PaymentFormDTO(PaymentForm paymentForm) {
        this.description = paymentForm.getDescription();
    }
}
