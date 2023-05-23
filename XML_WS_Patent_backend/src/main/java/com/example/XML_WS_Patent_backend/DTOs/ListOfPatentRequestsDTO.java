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
@XmlType(name = "", propOrder = { "tmReqs" })
@XmlRootElement(name = "ListOfPatentRequestsDTO")
public class ListOfPatentRequestsDTO {
    @XmlElement(name = "ZahtevZaPatent")
    private List<ZahtevZaPatent> tmReqs;
}
