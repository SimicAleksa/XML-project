
package com.example.XML_WS_AuthorRights_backend.models;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TAutor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TAutor"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ftn.uns.ac.rs/AutorskaPrava}TPodnosilac"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="godina_smrti" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TAutor", namespace = "http://www.ftn.uns.ac.rs/AutorskaPrava", propOrder = {
    "godinaSmrti"
})
public class TAutor
    extends TPodnosilac
{

    @XmlElement(name = "godina_smrti", namespace = "http://www.ftn.uns.ac.rs/AutorskaPrava")
    protected String godinaSmrti;

    /**
     * Gets the value of the godinaSmrti property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public String getGodinaSmrti() {
        return godinaSmrti;
    }

    /**
     * Sets the value of the godinaSmrti property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGodinaSmrti(String value) {
        this.godinaSmrti = value;
    }

}
