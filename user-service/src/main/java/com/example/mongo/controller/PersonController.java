package com.example.mongo.controller;

import com.example.mongo.core.dto.PersonDto;
import com.example.mongo.service.api.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {
    private final PersonService service;

    @RequestMapping(method = RequestMethod.POST)
    protected ResponseEntity<?> create(@RequestBody @Validated PersonDto person)   {
        service.create(person);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PersonDto> get(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findById(id).get());
    }
}
