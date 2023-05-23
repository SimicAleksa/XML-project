package com.example.XML_WS_Trademark_backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "brojPrijave",
        "datumPodnosenjaResenja",
        "sluzbenikImeIPrezime",
        "jePrihvacen",
        "obrazlozenje",
})
@XmlRootElement(name = "ResenjeZahteva")
public class ResenjeZahteva {
    @XmlElement(required = true)
    protected String brojPrijave;
    @XmlElement(required = true)
    protected String datumPodnosenjaResenja;
    @XmlElement(required = true)
    protected String sluzbenikImeIPrezime;
    @XmlElement(required = true)
    protected Boolean jePrihvacen;
    @XmlElement(required = true)
    protected String obrazlozenje;
}
