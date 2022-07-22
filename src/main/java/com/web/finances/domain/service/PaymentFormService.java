package com.web.finances.domain.service;

import com.web.finances.api.dto.AccountChartDTO;
import com.web.finances.api.dto.PaymentFormDTO;
import com.web.finances.domain.model.AccountChart;
import com.web.finances.domain.model.PaymentForm;
import com.web.finances.domain.repository.AccountChartRepository;
import com.web.finances.domain.repository.PaymentFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentFormService {

    @Autowired
    PaymentFormRepository repository;

    public List<PaymentFormDTO> listAll() {
        List<PaymentFormDTO> paymentFormDTOList = new ArrayList<>();
        repository.findAll()
                .forEach(paymentForm -> paymentFormDTOList.add(paymentForm.toDto()));
        return paymentFormDTOList;
    }

    public ResponseEntity<PaymentFormDTO> listById(Long id) {
        return repository.findById(id)
                .map(accountChart -> ResponseEntity.ok().body(accountChart.toDto())
                ).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<PaymentFormDTO> findById(Long id) {
        return repository.findById(id)
                .map(accountChart -> ResponseEntity.ok(accountChart.toDto()))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<PaymentFormDTO> create(PaymentForm paymentForm) {
        return new ResponseEntity<>(repository.save(paymentForm).toDto(), HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteById(Long id) {
        return repository.findById(id)
                .map(paymentForm -> {
                    repository.delete(paymentForm);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<PaymentFormDTO> update(PaymentForm paymentForm) {
        return repository.findById(paymentForm.getId())
                .map(oldPaymentForm -> {
                    oldPaymentForm.setDescription(paymentForm.getDescription());
                    return new ResponseEntity<>(repository.save(oldPaymentForm).toDto(), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }



}
