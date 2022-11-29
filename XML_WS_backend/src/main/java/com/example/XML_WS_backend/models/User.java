package com.example.XML_WS_backend.models;

import com.example.XML_WS_backend.enumerations.UserRole;
import jakarta.persistence.*;


@Entity
public class User {
    @Id
    public Long id;

    @Column
    public String name;

    @Column
    public String surname;

    @Column
    public String email;

    @Column
    public String password;

    @Column
    @Enumerated(EnumType.STRING)
    public UserRole role;

    public User() {
    }

    public User(Long id, String name, String surname, String email, String password, UserRole role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
