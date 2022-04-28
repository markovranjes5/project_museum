package com.example.project_museum.controllers;

import com.example.project_museum.models.entities.AdminEntity;
import com.example.project_museum.repositories.AdminEntityRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {

    private final AdminEntityRepository adminEntityRepository;

    public AdminController(AdminEntityRepository adminEntityRepository){
        this.adminEntityRepository = adminEntityRepository;
    }

    @GetMapping
    public List<AdminEntity> findAll(){
        return adminEntityRepository.findAll();
    }
}
