package com.example.project_museum.models.requests;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequest {

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
}
