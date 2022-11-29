package com.example.XML_WS_backend.services;

import com.example.XML_WS_backend.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    public void registerUser() {

    }
}
