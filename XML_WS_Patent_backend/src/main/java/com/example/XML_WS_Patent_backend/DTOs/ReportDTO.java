package com.example.XML_WS_Patent_backend.DTOs;

import com.example.XML_WS_Patent_backend.models.ZahtevZaPatent;
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
@XmlType(name = "", propOrder = { "prihvaceni","odbijeni","podneti"})
@XmlRootElement(name = "ReportDTO")
public class ReportDTO {
    @XmlElement(name = "prihvaceni")
    private String prihvaceni;
    @XmlElement(name = "odbijeni")
    private String odbijeni;
    @XmlElement(name = "podneti")
    private String podneti;
}
