
package com.example.XML_WS_backend.models.zahtev_za_autorska_prava;

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
 *       &lt;sequence&gt;
 *         &lt;element name="ulica" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="broj" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="grad" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TAdresa", namespace = "http://www.ftn.uns.ac.rs/AutorskaPravaLatinica", propOrder = {
    "ulica",
    "broj",
    "grad"
})
public class TAdresa {

    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/AutorskaPravaLatinica", required = true)
    protected String ulica;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/AutorskaPravaLatinica")
    protected int broj;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/AutorskaPravaLatinica", required = true)
    protected String grad;

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
     * Gets the value of the broj property.
     * 
     */
    public int getBroj() {
        return broj;
    }

    /**
     * Sets the value of the broj property.
     * 
     */
    public void setBroj(int value) {
        this.broj = value;
    }

    /**
     * Gets the value of the grad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGrad() {
        return grad;
    }

    /**
     * Sets the value of the grad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGrad(String value) {
        this.grad = value;
    }

    @Override
    public String toString() {
        System.out.println("Bila sam u adresi");
        return
                "ulica='" + ulica + "\' \n" +
                ", broj=" + broj +
                ", grad='" + grad + '\'';
    }
}
