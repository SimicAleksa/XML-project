package com.example.XML_WS_backend.services;

import com.example.XML_WS_backend.DTOs.RegistrationDTO;
import com.example.XML_WS_backend.custom_utils.mappers.DTO_2_EntityMapper;
import com.example.XML_WS_backend.models.Official;
import com.example.XML_WS_backend.repositories.IOfficialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class OfficialsService {
    @Autowired
    private IOfficialsRepository officialsRepository;

    public ResponseEntity<Official> registerUser(RegistrationDTO registrationDTO) {
        Official official = DTO_2_EntityMapper.RegistrationDTO_2_Official(registrationDTO, true);

        if (official == null)
            return new ResponseEntity<>(null, HttpStatus.UNPROCESSABLE_ENTITY);;

        if (officialsRepository.getByEmail(official.getEmail()) != null)
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);

        officialsRepository.save(official);
        return new ResponseEntity<>(official, HttpStatus.OK);
    }
}
