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
        "ukupno",
        "numOfPrihvaceno",
        "numOfOdbijeno"
})
@XmlRootElement(name = "ReportDTO")
public class ReportDTO {
    @XmlElement
    private Integer ukupno;
    @XmlElement
    private Integer numOfPrihvaceno;
    @XmlElement
    private Integer numOfOdbijeno;

    public void incUkupno() {
        this.ukupno++;
    }

    public void incPrihvaceno() {
        this.numOfPrihvaceno++;
    }
    public void incOdbijeno() {
        this.numOfOdbijeno++;
    }

}
