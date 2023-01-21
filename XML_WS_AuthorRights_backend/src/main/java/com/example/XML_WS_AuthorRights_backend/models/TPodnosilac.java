
package com.example.XML_WS_AuthorRights_backend.models;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TPodnosilac complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TPodnosilac"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ftn.uns.ac.rs/AutorskaPrava}TPunomocnik"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="drzavljanstvo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TPodnosilac", namespace = "http://www.ftn.uns.ac.rs/AutorskaPrava", propOrder = {
    "drzavljanstvo"
})
@XmlSeeAlso({
    TAutor.class
})
public class TPodnosilac
    extends TPunomocnik
{

    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/AutorskaPrava", required = true)
    protected String drzavljanstvo;

    /**
     * Gets the value of the drzavljanstvo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrzavljanstvo() {
        return drzavljanstvo;
    }

    /**
     * Sets the value of the drzavljanstvo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrzavljanstvo(String value) {
        this.drzavljanstvo = value;
    }

}
