package com.example.XML_WS_auth_backend.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "firstname",
        "lastname",
        "email",
        "role"
})
@XmlRootElement(name = "UserInfoDTO")
public class UserInfoDTO {
    @XmlElement(required = true)
    private String firstname;
    @XmlElement(required = true)
    private String lastname;
    @XmlElement(required = true)
    private String email;
    @XmlElement(required = true)
    private String role;
}
