package com.example.XML_WS_backend.custom_utils.mappers;

import com.example.XML_WS_backend.DTOs.RegistrationDTO;
import com.example.XML_WS_backend.custom_utils.validator.DataValidator;
import com.example.XML_WS_backend.models.Official;

import javax.xml.crypto.Data;

public class DTO_2_EntityMapper {
    public static Official RegistrationDTO_2_Official(RegistrationDTO registrationDTO, boolean validate) {
        if (validate)
            if ( !DataValidator.valNameOrSurname(registrationDTO.getName()) ||
                !DataValidator.valNameOrSurname(registrationDTO.getSurname()) ||
                !DataValidator.valEmail(registrationDTO.getEmail()) ||
                !DataValidator.valPassword(registrationDTO.getPassword())
            )
                return null;

        Official official = new Official();
        official.setName(registrationDTO.getName());
        official.setSurname(registrationDTO.getSurname());
        official.setEmail(registrationDTO.getEmail());
        official.setPassword(registrationDTO.getPassword());
        return official;
    }
}
