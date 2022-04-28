package com.example.project_museum.controllers;

import com.example.project_museum.models.entities.AdminEntity;
import com.example.project_museum.models.entities.CreditCardEntity;
import com.example.project_museum.repositories.AdminEntityRepository;
import com.example.project_museum.repositories.CreditCardEntityRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/credit-cards")
public class CreditCardController {

    private final CreditCardEntityRepository creditCardEntityRepository;

    public CreditCardController(CreditCardEntityRepository creditCardEntityRepository){
        this.creditCardEntityRepository = creditCardEntityRepository;
    }

    @GetMapping
    public List<CreditCardEntity> findAll(){
        return creditCardEntityRepository.findAll();
    }
}
