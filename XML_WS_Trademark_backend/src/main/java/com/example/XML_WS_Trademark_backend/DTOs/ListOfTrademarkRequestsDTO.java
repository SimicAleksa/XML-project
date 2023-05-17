package com.example.XML_WS_Trademark_backend.DTOs;

import com.example.XML_WS_Trademark_backend.models.ZahtevZaPriznanjeZiga;
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
@XmlRootElement(name = "ListOfTrademarkRequestsDTO")
public class ListOfTrademarkRequestsDTO {
    @XmlElement(name = "ZahtevZaPriznanjeZiga")
    private List<ZahtevZaPriznanjeZiga> tmReqs;
}
