package com.example.XML_WS_backend.services;

import com.example.XML_WS_backend.repositories.IOfficialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfficialsService {
    @Autowired
    private IOfficialsRepository officialsRepository;

    public void registerUser() {

    }
}
