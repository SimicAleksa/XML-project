package com.example.XML_WS_backend.custom_utils.mappers;

import com.example.XML_WS_backend.DTOs.RegistrationDTO;
import com.example.XML_WS_backend.custom_utils.validator.DataValidator;
import com.example.XML_WS_backend.models.User;

public class DTO_2_EntityMapper {
    public static User RegistrationDTO_2_User(RegistrationDTO registrationDTO, boolean validate) {
        if (validate)
            if ( !registrationDTO.areAllAttributesNonNull() ||
                    !( DataValidator.valNameOrSurname(registrationDTO.getName()) &&
                        DataValidator.valNameOrSurname(registrationDTO.getSurname()) &&
                        DataValidator.valEmail(registrationDTO.getEmail()) &&
                        DataValidator.valPassword(registrationDTO.getPassword())
                    )
            )
                return null;

        User user = new User();
        user.setName(registrationDTO.getName());
        user.setSurname(registrationDTO.getSurname());
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(registrationDTO.getPassword());
        return user;
    }
}
