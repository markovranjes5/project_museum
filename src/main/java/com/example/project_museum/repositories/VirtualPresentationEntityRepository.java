package com.example.project_museum.repositories;

import com.example.project_museum.models.entities.VirtualPresentationEntity;
import com.example.project_museum.models.entities.VirtualPresentationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VirtualPresentationEntityRepository extends JpaRepository<VirtualPresentationEntity, VirtualPresentationId> {

    @Query(value = "select * from virtual_presentation where museum_id=?", nativeQuery = true)
    public List<VirtualPresentationEntity> findByMuseum(Integer museum_id);
}
