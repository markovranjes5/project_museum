package com.example.project_museum.controllers;

import com.example.project_museum.models.entities.UserEntity;
import com.example.project_museum.models.requests.UserRequest;
import com.example.project_museum.models.requests.UserResponse;
import com.example.project_museum.repositories.UserEntityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/hub/users")
public class UserController {

    private final UserEntityRepository userEntityRepository;
    private final ModelMapper modelMapper;

    public UserController(UserEntityRepository userEntityRepository, ModelMapper modelMapper){
        this.userEntityRepository = userEntityRepository;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(required = false) String username)
    {
        if(username != null){
            UserEntity userEntity = userEntityRepository.findByUsername(username);
            UserResponse userResponse = modelMapper.map(userEntity, UserResponse.class);
            return ResponseEntity.ok(userResponse);

        }

        else
            return  ResponseEntity.ok(userEntityRepository.findAll());
    }




    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping()
    public ResponseEntity<UserEntity> insert(@RequestBody UserRequest userRequest){
        UserEntity userEntity = modelMapper.map(userRequest, UserEntity.class);
        userEntity.setStatus("UNCONFIRMED");
        userEntity.setRole("USER");
        userEntity.setToken("0");
        return ResponseEntity.ok(userEntityRepository.save(userEntity));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/count")
    public ResponseEntity<Long> count(){
        return ResponseEntity.ok(userEntityRepository.count());
    }
}
