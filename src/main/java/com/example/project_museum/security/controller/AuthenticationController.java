package com.example.project_museum.security.controller;

import com.example.project_museum.models.entities.LogEntity;
import com.example.project_museum.models.requests.LoginRequest;
import com.example.project_museum.repositories.LogEntityRepository;
import com.example.project_museum.security.model.AuthToken;
import com.example.project_museum.security.util.TokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/login")
public class AuthenticationController {


    private final AuthenticationManager authenticationManager;
    private final LogEntityRepository logEntityRepository;
    private final TokenProvider jwtTokenUtil;

    public AuthenticationController(AuthenticationManager authenticationManager, LogEntityRepository logEntityRepository, TokenProvider jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.logEntityRepository = logEntityRepository;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping
    public ResponseEntity register(@RequestBody LoginRequest loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }

}