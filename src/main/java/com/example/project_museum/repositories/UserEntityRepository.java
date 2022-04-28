package com.example.project_museum.repositories;

import com.example.project_museum.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserEntityRepository extends JpaRepository<UserEntity,Integer> {

    @Query(value = "select * from user where username=?1 and password=?2", nativeQuery = true)
    public UserEntity findByUsernameAndPassword(String username, String password);

    public UserEntity findByUsername(String username);
}
