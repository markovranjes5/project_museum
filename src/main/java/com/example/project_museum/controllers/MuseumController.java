package com.example.project_museum.controllers;

import com.example.project_museum.models.entities.MuseumEntity;
import com.example.project_museum.repositories.MuseumEntityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/hub/museums")
public class MuseumController {

    private final MuseumEntityRepository museumEntityRepository;
    private final ModelMapper modelMapper;


    public MuseumController(MuseumEntityRepository museumEntityRepository, ModelMapper modelMapper){
        this.museumEntityRepository = museumEntityRepository;
        this.modelMapper = modelMapper;
    }


    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @GetMapping
    public List<MuseumEntity> getAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String city
    ){

        if(name != null)
            return museumEntityRepository.findByName(name);
        else if(city != null)
            return museumEntityRepository.findByCity(city);
        else
            return museumEntityRepository.findAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @GetMapping("/{id}")
    public Optional<MuseumEntity> getById(@PathVariable("id") Integer id){
        return museumEntityRepository.findById(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public MuseumEntity insert(@RequestBody MuseumEntity museumEntity){
        return museumEntityRepository.save(museumEntity);
    }

}
