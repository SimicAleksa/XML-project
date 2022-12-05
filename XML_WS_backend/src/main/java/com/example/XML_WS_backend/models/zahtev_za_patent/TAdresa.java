
package com.example.XML_WS_backend.models.zahtev_za_patent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TAdresa complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TAdresa"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="ulica" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="broj_objekta" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="postanski_broj" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="mesto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="drzava" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TAdresa", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", propOrder = {

})
public class TAdresa {

    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
    protected String ulica;
    @XmlElement(name = "broj_objekta", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
    protected String brojObjekta;
    @XmlElement(name = "postanski_broj", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
    protected String postanskiBroj;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
    protected String mesto;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/zahtev_za_patent", required = true)
    protected String drzava;

    /**
     * Gets the value of the ulica property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUlica() {
        return ulica;
    }

    /**
     * Sets the value of the ulica property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUlica(String value) {
        this.ulica = value;
    }

    /**
     * Gets the value of the brojObjekta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrojObjekta() {
        return brojObjekta;
    }

    /**
     * Sets the value of the brojObjekta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrojObjekta(String value) {
        this.brojObjekta = value;
    }

    /**
     * Gets the value of the postanskiBroj property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostanskiBroj() {
        return postanskiBroj;
    }

    /**
     * Sets the value of the postanskiBroj property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostanskiBroj(String value) {
        this.postanskiBroj = value;
    }

    /**
     * Gets the value of the mesto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMesto() {
        return mesto;
    }

    /**
     * Sets the value of the mesto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMesto(String value) {
        this.mesto = value;
    }

    /**
     * Gets the value of the drzava property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrzava() {
        return drzava;
    }

    /**
     * Sets the value of the drzava property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrzava(String value) {
        this.drzava = value;
    }


    @Override
    public String toString() {
        return "TAdresa{" +
                "ulica='" + ulica + '\'' +
                ", brojObjekta='" + brojObjekta + '\'' +
                ", postanskiBroj='" + postanskiBroj + '\'' +
                ", mesto='" + mesto + '\'' +
                ", drzava='" + drzava + '\'' +
                '}';
    }
}
