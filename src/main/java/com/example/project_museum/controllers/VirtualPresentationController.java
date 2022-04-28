package com.example.project_museum.controllers;

import com.example.project_museum.models.entities.VirtualPresentationEntity;
import com.example.project_museum.models.entities.VirtualPresentationId;
import com.example.project_museum.models.entities.VirtualVisitEntity;
import com.example.project_museum.models.requests.VirtualPresentationRequest;
import com.example.project_museum.repositories.VirtualPresentationEntityRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/hub/virtual-presentations")
public class VirtualPresentationController {
    private final VirtualPresentationEntityRepository virtualPresentationEntityRepository;

    public VirtualPresentationController(VirtualPresentationEntityRepository virtualPresentationEntityRepository){
        this.virtualPresentationEntityRepository = virtualPresentationEntityRepository;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @GetMapping
    public List<VirtualPresentationEntity> findAll(){
        return virtualPresentationEntityRepository.findAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @GetMapping("/{museum_id}")
    public VirtualPresentationEntity findByMuseum(@PathVariable("museum_id") Integer museum_id){
        return virtualPresentationEntityRepository.findByMuseum(museum_id).get(0);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public VirtualPresentationEntity save(@RequestBody VirtualPresentationRequest virtualPresentationRequest){
        VirtualPresentationEntity virtualPresentationEntity= new VirtualPresentationEntity();
        VirtualPresentationId virtualPresentationEntityId=new VirtualPresentationId();
        virtualPresentationEntityId.setMuseumId(virtualPresentationRequest.getMuseum_id());
        virtualPresentationEntity.setId(virtualPresentationEntityId);
        virtualPresentationEntity.setImg1(virtualPresentationRequest.getImg1());
        virtualPresentationEntity.setImg2(virtualPresentationRequest.getImg2());
        virtualPresentationEntity.setImg3(virtualPresentationRequest.getImg3());
        virtualPresentationEntity.setImg4(virtualPresentationRequest.getImg4());
        virtualPresentationEntity.setImg5(virtualPresentationRequest.getImg5());
        virtualPresentationEntity.setImg6(virtualPresentationRequest.getImg6());
        virtualPresentationEntity.setImg7(virtualPresentationRequest.getImg7());
        virtualPresentationEntity.setImg8(virtualPresentationRequest.getImg8());
        virtualPresentationEntity.setImg9(virtualPresentationRequest.getImg9());
        virtualPresentationEntity.setImg10(virtualPresentationRequest.getImg10());
        virtualPresentationEntity.setVideo(virtualPresentationRequest.getVideo());
        return virtualPresentationEntityRepository.save(virtualPresentationEntity);
    }
}
