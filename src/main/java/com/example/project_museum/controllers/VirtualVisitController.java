package com.example.project_museum.controllers;

import com.example.project_museum.models.entities.MuseumEntity;
import com.example.project_museum.models.entities.VirtualTicketEntity;
import com.example.project_museum.models.entities.VirtualVisitEntity;
import com.example.project_museum.models.responses.VisitResponse;
import com.example.project_museum.repositories.MuseumEntityRepository;
import com.example.project_museum.repositories.VirtualTicketEntityRepository;
import com.example.project_museum.repositories.VirtualVisitEntityRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/hub/virtual-visits")
public class VirtualVisitController{

    private final VirtualVisitEntityRepository virtualVisitEntityRepository;
    private final VirtualTicketEntityRepository virtualTicketEntityRepository;
    private final MuseumEntityRepository museumEntityRepository;

    public VirtualVisitController(VirtualVisitEntityRepository virtualVisitEntityRepository, VirtualTicketEntityRepository virtualTicketEntityRepository, MuseumEntityRepository museumEntityRepository){
        this.virtualVisitEntityRepository = virtualVisitEntityRepository;
        this.virtualTicketEntityRepository = virtualTicketEntityRepository;

        this.museumEntityRepository = museumEntityRepository;
    }

    @GetMapping
    public List<VirtualVisitEntity> findAll(){
        return virtualVisitEntityRepository.findAll();
    }

    @GetMapping("/museum/{museum_id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public List<VirtualVisitEntity> findByMuseumId(@PathVariable("museum_id") Integer museum_id){
        return virtualVisitEntityRepository.findByMuseum_id(museum_id);
    }

    @GetMapping("/user/{user_id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public List<VisitResponse> findByTicketId(@PathVariable("user_id") Integer user_id){
        List<VirtualTicketEntity> tickets = virtualTicketEntityRepository.findByUser_id(user_id);
        List<VisitResponse> visits = new ArrayList<>();
        for(VirtualTicketEntity virtualTicketEntity : tickets){
            VirtualVisitEntity virtualVisit = virtualVisitEntityRepository.getById(virtualTicketEntity.getVirtual_visit_id());
            MuseumEntity museumEntity = museumEntityRepository.findById(virtualVisit.getMuseum_id()).get();
            visits.add(new VisitResponse(virtualTicketEntity.getId(), museumEntity.getId(), museumEntity.getName(), virtualVisit));;
        }

        return visits;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public VirtualVisitEntity findById(@PathVariable("id") Integer id){
        return virtualVisitEntityRepository.findById(id).get();
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public VirtualVisitEntity insert(@RequestBody VirtualVisitEntity virtualVisitEntity){
        System.out.println(virtualVisitEntity.getStart_time());
        System.out.println(virtualVisitEntity.getEnd_time());
        System.out.println(virtualVisitEntity.getPrice());
        System.out.println(virtualVisitEntity.getMuseum_id());
        return  virtualVisitEntityRepository.save(virtualVisitEntity);
    }
}
