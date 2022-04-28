package com.example.project_museum.repositories;

import com.example.project_museum.models.entities.VirtualTicketEntity;
import com.example.project_museum.models.entities.VirtualVisitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VirtualTicketEntityRepository extends JpaRepository<VirtualTicketEntity, Integer> {

    @Query(value = "select * from virtual_ticket where user_id = ?1", nativeQuery = true)
    List<VirtualTicketEntity> findByUser_id(Integer user_id);
}
