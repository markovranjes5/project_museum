package com.example.project_museum.repositories;

import com.example.project_museum.models.entities.TransactionEntity;
import com.example.project_museum.models.entities.TransactionEntityId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionEntityRepository extends JpaRepository<TransactionEntity, TransactionEntityId> {
}
