package com.example.XML_WS_backend.repositories;

import com.example.XML_WS_backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, String> {
}
