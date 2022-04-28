package com.example.project_museum.repositories;

import com.example.project_museum.models.entities.CreditCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CreditCardEntityRepository extends JpaRepository<CreditCardEntity, Integer> {
    @Query(value = "select * from credit_card where card_number=?1 and pin=?2 and expiration_date=?3 and type=?4 and firstname=?5 and lastname=?6", nativeQuery = true)
    public List<CreditCardEntity> verifyCard(int card_number, String pin, String expiration_date, String type, String firstname, String lastname);
}
