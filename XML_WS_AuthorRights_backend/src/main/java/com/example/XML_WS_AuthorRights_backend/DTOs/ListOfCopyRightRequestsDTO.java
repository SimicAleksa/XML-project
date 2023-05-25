package com.example.XML_WS_AuthorRights_backend.DTOs;

import com.example.XML_WS_AuthorRights_backend.models.ZahtevZaAutorskoPravo;
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
@XmlType(name = "", propOrder = { "crReqs" })
@XmlRootElement(name = "ListOfCopyRightRequestsDTO")
public class ListOfCopyRightRequestsDTO {
    @XmlElement(name = "ZahtevZaAutorskoPravo")
    private List<ZahtevZaAutorskoPravo> crReqs;
}
