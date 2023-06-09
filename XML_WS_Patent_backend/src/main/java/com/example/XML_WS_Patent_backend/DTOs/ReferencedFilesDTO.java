package com.example.XML_WS_Patent_backend.DTOs;


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
        "param"
})
@XmlRootElement(name = "ReferencedFilesDTO")
public class ReferencedFilesDTO {
    @XmlElement
    private String param;
}
