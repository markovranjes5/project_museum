package com.example.project_museum.repositories;

import com.example.project_museum.models.entities.CreditCardEntity;
import com.example.project_museum.models.entities.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LogEntityRepository extends JpaRepository<LogEntity, Integer> {
    @Query(value = "select count(*) from log where action=?", nativeQuery = true)
    Integer countAction(String action);

    @Query(value = "select count(*) from log where (CAST(time as time) >= ? and CAST(time as date) = CAST(NOW() as date) and CAST(time as time) < ? and CAST(time as date) = CAST(NOW() as date)) and action='login'", nativeQuery = true)
    int activeUsersForHourToday(String h1, String h2);

    @Query(value = "select count(*) from log where (CAST(time as time) >= ? and CAST(time as date) = CAST(DATE_SUB(NOW(), INTERVAL 1 DAY) as date) and CAST(time as time) < ? and CAST(time as date) = CAST(DATE_SUB(NOW(), INTERVAL 1 DAY) as date)) and action='login'", nativeQuery = true)
    int activeUsersForHourYesterday(String h1, String h2);
}
