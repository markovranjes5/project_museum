package com.example.project_museum.repositories;

import com.example.project_museum.models.entities.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminEntityRepository extends JpaRepository<AdminEntity, Integer> {

    public AdminEntity findByUsername(String username);
}
