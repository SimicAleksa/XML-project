package com.example.XML_WS_auth_backend.DTOs;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "authToken",
        "role",
        "email"
})
@XmlRootElement(name = "AuthTokenDTO")
public class AuthTokenDTO {
    private String authToken;
    private String role;
    private String email;
}
