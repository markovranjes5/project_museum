package com.example.project_museum.repositories;

import com.example.project_museum.models.entities.MuseumTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MuseumTypeEntityRepository extends JpaRepository<MuseumTypeEntity, Integer> {
    List<MuseumTypeEntity> findByName(String name);
}
