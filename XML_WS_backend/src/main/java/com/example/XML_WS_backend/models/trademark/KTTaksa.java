
package com.example.XML_WS_backend.models.trademark;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for KTTaksa complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="KTTaksa"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OsnovnaTaksa" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="TaksaZaBrojKlasa" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="TaksaZaGrafickoResenje" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="Ukupno" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KTTaksa", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA", propOrder = {
    "osnovnaTaksa",
    "taksaZaBrojKlasa",
    "taksaZaGrafickoResenje",
    "ukupno"
})
@Data
@NoArgsConstructor
public class KTTaksa {
    @XmlElement(name = "OsnovnaTaksa", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA")
    protected float osnovnaTaksa;
    @XmlElement(name = "TaksaZaBrojKlasa", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA")
    protected float taksaZaBrojKlasa;
    @XmlElement(name = "TaksaZaGrafickoResenje", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA")
    protected float taksaZaGrafickoResenje;
    @XmlElement(name = "Ukupno", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA")
    protected float ukupno;
}
