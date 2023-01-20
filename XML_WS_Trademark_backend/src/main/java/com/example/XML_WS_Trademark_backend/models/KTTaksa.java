
package com.example.XML_WS_Trademark_backend.models;


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
@XmlType(name = "KTTaksa", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_zig", propOrder = {
    "osnovnaTaksa",
    "taksaZaBrojKlasa",
    "taksaZaGrafickoResenje",
    "ukupno"
})
public class KTTaksa {

    @XmlElement(name = "OsnovnaTaksa", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_zig")
    protected float osnovnaTaksa;
    @XmlElement(name = "TaksaZaBrojKlasa", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_zig")
    protected float taksaZaBrojKlasa;
    @XmlElement(name = "TaksaZaGrafickoResenje", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_zig")
    protected float taksaZaGrafickoResenje;
    @XmlElement(name = "Ukupno", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_zig")
    protected float ukupno;

    /**
     * Gets the value of the osnovnaTaksa property.
     * 
     */
    public float getOsnovnaTaksa() {
        return osnovnaTaksa;
    }

    /**
     * Sets the value of the osnovnaTaksa property.
     * 
     */
    public void setOsnovnaTaksa(float value) {
        this.osnovnaTaksa = value;
    }

    /**
     * Gets the value of the taksaZaBrojKlasa property.
     * 
     */
    public float getTaksaZaBrojKlasa() {
        return taksaZaBrojKlasa;
    }

    /**
     * Sets the value of the taksaZaBrojKlasa property.
     * 
     */
    public void setTaksaZaBrojKlasa(float value) {
        this.taksaZaBrojKlasa = value;
    }

    /**
     * Gets the value of the taksaZaGrafickoResenje property.
     * 
     */
    public float getTaksaZaGrafickoResenje() {
        return taksaZaGrafickoResenje;
    }

    /**
     * Sets the value of the taksaZaGrafickoResenje property.
     * 
     */
    public void setTaksaZaGrafickoResenje(float value) {
        this.taksaZaGrafickoResenje = value;
    }

    /**
     * Gets the value of the ukupno property.
     * 
     */
    public float getUkupno() {
        return ukupno;
    }

    /**
     * Sets the value of the ukupno property.
     * 
     */
    public void setUkupno(float value) {
        this.ukupno = value;
    }

}
