package com.example.project_museum.models.entities;



import javax.persistence.*;
import java.util.Objects;
import java.util.Optional;

@Entity
@Table(name = "user")
public class UserEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "firstname", nullable = false, length = 50)
    private String firstname;

    @Column(name = "lastname", nullable = false, length = 50)
    private String lastname;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "role", nullable = false, length = 50)
    private String role;

    @Column(name = "token", nullable = false, length = 50)
    private String token;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(email, that.email) && Objects.equals(status, that.status) && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(role, that.role) && Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, email, status, username, password, role, token);
    }
}