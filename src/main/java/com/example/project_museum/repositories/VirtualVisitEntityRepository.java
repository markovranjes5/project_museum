package com.example.project_museum.repositories;

import com.example.project_museum.models.entities.MuseumEntity;
import com.example.project_museum.models.entities.VirtualVisitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VirtualVisitEntityRepository extends JpaRepository<VirtualVisitEntity, Integer> {

    @Query(value = "select * from virtual_visit where museum_id = ?1", nativeQuery = true)
    List<VirtualVisitEntity> findByMuseum_id(Integer museum_id);

}
