package com.web.finances.api.controller;



import com.web.finances.api.dto.PersonalDataDTO;
import com.web.finances.domain.model.PersonalData;
import com.web.finances.domain.service.PersonalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PersonalData")
public class PersonalDataController {
    @Autowired
    PersonalDataService service;

    @GetMapping
    public List<PersonalDataDTO> listAll(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalDataDTO> listById(@PathVariable Long id){
        return service.listById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<PersonalDataDTO> create(@RequestBody PersonalData people) {
        return service.create(
                people
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<PersonalDataDTO> update(@RequestBody  PersonalData people) {
        return service.update(people);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<PersonalDataDTO> findById(@PathVariable Long id) {
        return service.findById(id);
    }

}
