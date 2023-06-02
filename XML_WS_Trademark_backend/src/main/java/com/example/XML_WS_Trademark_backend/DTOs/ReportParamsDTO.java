package com.example.XML_WS_Trademark_backend.DTOs;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "startDate",
        "endDate"
})
@XmlRootElement(name = "ReportParamsDTO")
public class ReportParamsDTO {
    @XmlElement
    private String startDate;
    @XmlElement
    private String endDate;
}
