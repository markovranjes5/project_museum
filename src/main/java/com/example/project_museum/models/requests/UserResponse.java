package com.example.project_museum.models.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Integer id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String role;
    private String status;
    private String token;
}