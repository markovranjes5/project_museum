package com.example.project_museum.security.service;



import com.example.project_museum.models.entities.UserEntity;
import com.example.project_museum.repositories.UserEntityRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserEntityRepository userEntiryRepository;

    public UserService(UserEntityRepository userEntiryRepository) {
        this.userEntiryRepository = userEntiryRepository;
    }

    public List<UserEntity> findAll(){
        return userEntiryRepository.findAll();
    }

    public UserEntity findByUsername(String usernameFromToken) {
        UserEntity userEntity = userEntiryRepository.findByUsername(usernameFromToken);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userEntity.setPassword(encoder.encode(userEntity.getPassword()));
        return userEntiryRepository.findByUsername(usernameFromToken);
    }
}