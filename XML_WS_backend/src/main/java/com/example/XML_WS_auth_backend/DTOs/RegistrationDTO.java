package com.example.XML_WS_auth_backend.DTOs;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "firstname",
        "lastname",
        "email",
        "password"
})
@XmlRootElement(name = "RegistrationDTO")
public class RegistrationDTO {
    @XmlElement(required = true)
    private String firstname;
    @XmlElement(required = true)
    private String lastname;
    @XmlElement(required = true)
    private String email;
    @XmlElement(required = true)
    private String password;
}
