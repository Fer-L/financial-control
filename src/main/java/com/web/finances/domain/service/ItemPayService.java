package com.web.finances.domain.service;

import com.web.finances.api.dto.ItemPayDTO;
import com.web.finances.domain.model.ItemPay;
import com.web.finances.domain.repository.ItemPayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemPayService {
    @Autowired
    ItemPayRepository repository;


    public List<ItemPayDTO> listAll() {
        List<ItemPayDTO> itemPayDTOList = new ArrayList<>();
        repository.findAll()
                .forEach(itemPay -> itemPayDTOList.add(itemPay.toDto()));
        return itemPayDTOList;
    }

    public ResponseEntity<ItemPayDTO> listById(Long id) {
        return repository.findById(id)
                .map(itemPay -> ResponseEntity.ok().body(itemPay.toDto())
                ).orElse(ResponseEntity.notFound().build());
    }


//    public ResponseEntity<ItemPayDTO> listByIdaAll(Long id) {
//        return repository.findAll().stream().filter(p)
//                .map(itemPay -> ResponseEntity.ok().body(itemPay.toDto())
//                ).orElse(ResponseEntity.notFound().build());
//    }
//
//    public ResponseEntity<ItemPayDTO> listByPayroll(Long id) {
//        return (ResponseEntity<ItemPayDTO>) repository.findByPayroll(id);
//    }



    public ResponseEntity<ItemPayDTO> findById(Long id) {
        return repository.findById(id)
                .map(itemPay -> ResponseEntity.ok(itemPay.toDto()))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<ItemPayDTO> create(ItemPay itemPay) {
        return new ResponseEntity<>(repository.save(itemPay).toDto(), HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteById(Long id) {
        return repository.findById(id)
                .map(law -> {
                    repository.delete(law);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<ItemPayDTO> update(ItemPay itemPay) {
        return repository.findById(itemPay.getId())
                .map(oldItemPay -> {
                    oldItemPay.setFunds(itemPay.getFunds());
                    oldItemPay.setPayroll(itemPay.getPayroll());
                    oldItemPay.setFunds(itemPay.getFunds());
                    oldItemPay.setValor(itemPay.getValor());

                    return new ResponseEntity<>(repository.save(oldItemPay).toDto(), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}