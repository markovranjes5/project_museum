package com.example.project_museum.repositories;

import com.example.project_museum.models.entities.MuseumEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MuseumEntityRepository extends JpaRepository<MuseumEntity,Integer> {

    @Query(value = "select * from museum where name = ?1", nativeQuery = true)
    List<MuseumEntity> findByName(String name);

    @Query(value = "select * from museum where city = ?1", nativeQuery = true)
    List<MuseumEntity> findByCity(String city);

}
