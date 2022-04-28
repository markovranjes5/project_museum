package com.example.project_museum.controllers;

import com.example.project_museum.models.entities.MuseumTypeEntity;
import com.example.project_museum.repositories.MuseumTypeEntityRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/hub/museum-types")
public class MuseumTypeController {
    private final MuseumTypeEntityRepository museumTypeEntityRepository;

    public MuseumTypeController(MuseumTypeEntityRepository museumTypeEntityRepository){
        this.museumTypeEntityRepository = museumTypeEntityRepository;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @GetMapping
    public List<MuseumTypeEntity> findAll(@RequestParam(required = false) String name){
        if(name != null)
            return museumTypeEntityRepository.findByName(name);
        else
            return museumTypeEntityRepository.findAll();
    }

}
