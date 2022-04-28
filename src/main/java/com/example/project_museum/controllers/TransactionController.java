package com.example.project_museum.controllers;

import com.example.project_museum.models.entities.TransactionEntity;
import com.example.project_museum.repositories.TransactionEntityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionEntityRepository transactionEntityRepository;

    public TransactionController(TransactionEntityRepository transactionEntityRepository){
        this.transactionEntityRepository = transactionEntityRepository;
    }

    @GetMapping
    public List<TransactionEntity> findAll(){
        return transactionEntityRepository.findAll();
    }

    @PostMapping
    public TransactionEntity insert(TransactionEntity transactionEntity){
        return transactionEntityRepository.save(transactionEntity);
    }
}
