package com.example.XML_WS_AuthorRights_backend.DTOs;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "onlyApproved",
        "param"
})
@XmlRootElement(name = "BasicSearchParamsDTO")
public class BasicSearchParamsDTO {
    @XmlElement
    private Boolean onlyApproved;
    @XmlElement
    private List<String> param;
}
