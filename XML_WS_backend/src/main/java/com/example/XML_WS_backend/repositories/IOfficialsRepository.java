package com.example.XML_WS_backend.repositories;

import com.example.XML_WS_backend.models.Official;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOfficialsRepository extends JpaRepository<Official, String> {
}
