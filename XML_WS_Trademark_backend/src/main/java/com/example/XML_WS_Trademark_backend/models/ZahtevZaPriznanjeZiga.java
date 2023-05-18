
package com.example.XML_WS_Trademark_backend.models;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{<a href="http://www.w3.org/2001/XMLSchema">...</a>}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MetaData"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="BrojPrijave"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                           &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:BrojPrijave" /&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="DatumPodnosenja"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;date"&gt;
 *                           &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:DatumPodnosenja" /&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="PodnosilacPrijave" type="{http://www.ftn.uns.ac.rs/zahtev_za_zig}KTPersona" maxOccurs="unbounded"/&gt;
 *         &lt;element name="Punomocnik" type="{http://www.ftn.uns.ac.rs/zahtev_za_zig}KTPersona"/&gt;
 *         &lt;element name="ZajednickiPredstavnici" type="{http://www.ftn.uns.ac.rs/zahtev_za_zig}KTPersona" minOccurs="0"/&gt;
 *         &lt;element name="Zig" type="{http://www.ftn.uns.ac.rs/zahtev_za_zig}KTZig"/&gt;
 *         &lt;element name="BrojeviKlasaRobeIliUsluga"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="BrojKlaseRobeIliUsluge" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="PravoPrvenstvaIOsnov" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Taksa" type="{http://www.ftn.uns.ac.rs/zahtev_za_zig}KTTaksa"/&gt;
 *         &lt;element name="PriloziUzZahtev"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="PrimerakZnaka" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="SpisakRobeIUsluga" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="Punomocje" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="PunomocjeRanijePrilozeno" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="PunomocjeNaknadnoPrilozeno" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="OpstiAktOZigu" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="DokazPravaPrvenstva" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="DokazUplateTakse" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "metaData",
    "podnosiociPrijave",
    "punomocnik",
    "zajednickiPredstavnik",
    "zig",
    "brojeviKlasaRobeIliUsluga",
    "pravoPrvenstvaIOsnov",
    "taksa",
    "priloziUzZahtev"
})
@XmlRootElement(name = "ZahtevZaPriznanjeZiga", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_zig")
public class ZahtevZaPriznanjeZiga {

    @XmlElement(name = "MetaData", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_zig", required = true)
    protected ZahtevZaPriznanjeZiga.MetaData metaData;
    @XmlElement(name = "PodnosiociPrijave", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_zig", required = true)
    protected ZahtevZaPriznanjeZiga.PodnosilacPrijave podnosiociPrijave;
    @XmlElement(name = "Punomocnik", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_zig", required = true)
    protected KTPersona punomocnik;
    @XmlElement(name = "ZajednickiPredstavnik", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_zig")
    protected KTPersona zajednickiPredstavnik;
    @XmlElement(name = "Zig", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_zig", required = true)
    protected KTZig zig;
    @XmlElement(name = "BrojeviKlasaRobeIliUsluga", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_zig", required = true)
    protected ZahtevZaPriznanjeZiga.BrojeviKlasaRobeIliUsluga brojeviKlasaRobeIliUsluga;
    @XmlElement(name = "PravoPrvenstvaIOsnov", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_zig", required = true)
    protected String pravoPrvenstvaIOsnov;
    @XmlElement(name = "Taksa", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_zig", required = true)
    protected KTTaksa taksa;
    @XmlElement(name = "PriloziUzZahtev", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_zig", required = true)
    protected ZahtevZaPriznanjeZiga.PriloziUzZahtev priloziUzZahtev;

    /**
     * Gets the value of the metaData property.
     * 
     * @return
     *     possible object is
     *     {@link ZahtevZaPriznanjeZiga.MetaData }
     *     
     */
    public ZahtevZaPriznanjeZiga.MetaData getMetaData() {
        return metaData;
    }

    /**
     * Sets the value of the metaData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZahtevZaPriznanjeZiga.MetaData }
     *     
     */
    public void setMetaData(ZahtevZaPriznanjeZiga.MetaData value) {
        this.metaData = value;
    }

    /**
     * Gets the value of the podnosilacPrijave property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the podnosilacPrijave property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPodnosilacPrijave().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KTPersona }
     * 
     * 
     */
    public ZahtevZaPriznanjeZiga.PodnosilacPrijave getPodnosiociPrijave() {
        return this.podnosiociPrijave;
    }

    /**
     * Gets the value of the punomocnik property.
     * 
     * @return
     *     possible object is
     *     {@link KTPersona }
     *     
     */
    public KTPersona getPunomocnik() {
        return punomocnik;
    }

    /**
     * Sets the value of the punomocnik property.
     * 
     * @param value
     *     allowed object is
     *     {@link KTPersona }
     *     
     */
    public void setPunomocnik(KTPersona value) {
        this.punomocnik = value;
    }

    /**
     * Gets the value of the zajednickiPredstavnici property.
     * 
     * @return
     *     possible object is
     *     {@link KTPersona }
     *     
     */
    public KTPersona getZajednickiPredstavnik() {
        return zajednickiPredstavnik;
    }

    /**
     * Sets the value of the zajednickiPredstavnici property.
     * 
     * @param value
     *     allowed object is
     *     {@link KTPersona }
     *     
     */
    public void setZajednickiPredstavnik(KTPersona value) {
        this.zajednickiPredstavnik = value;
    }

    /**
     * Gets the value of the zig property.
     * 
     * @return
     *     possible object is
     *     {@link KTZig }
     *     
     */
    public KTZig getZig() {
        return zig;
    }

    /**
     * Sets the value of the zig property.
     * 
     * @param value
     *     allowed object is
     *     {@link KTZig }
     *     
     */
    public void setZig(KTZig value) {
        this.zig = value;
    }

    /**
     * Gets the value of the brojeviKlasaRobeIliUsluga property.
     * 
     * @return
     *     possible object is
     *     {@link ZahtevZaPriznanjeZiga.BrojeviKlasaRobeIliUsluga }
     *     
     */
    public ZahtevZaPriznanjeZiga.BrojeviKlasaRobeIliUsluga getBrojeviKlasaRobeIliUsluga() {
        return brojeviKlasaRobeIliUsluga;
    }

    /**
     * Sets the value of the brojeviKlasaRobeIliUsluga property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZahtevZaPriznanjeZiga.BrojeviKlasaRobeIliUsluga }
     *     
     */
    public void setBrojeviKlasaRobeIliUsluga(ZahtevZaPriznanjeZiga.BrojeviKlasaRobeIliUsluga value) {
        this.brojeviKlasaRobeIliUsluga = value;
    }

    /**
     * Gets the value of the pravoPrvenstvaIOsnov property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPravoPrvenstvaIOsnov() {
        return pravoPrvenstvaIOsnov;
    }

    /**
     * Sets the value of the pravoPrvenstvaIOsnov property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPravoPrvenstvaIOsnov(String value) {
        this.pravoPrvenstvaIOsnov = value;
    }

    /**
     * Gets the value of the taksa property.
     * 
     * @return
     *     possible object is
     *     {@link KTTaksa }
     *     
     */
    public KTTaksa getTaksa() {
        return taksa;
    }

    /**
     * Sets the value of the taksa property.
     * 
     * @param value
     *     allowed object is
     *     {@link KTTaksa }
     *     
     */
    public void setTaksa(KTTaksa value) {
        this.taksa = value;
    }

    /**
     * Gets the value of the priloziUzZahtev property.
     * 
     * @return
     *     possible object is
     *     {@link ZahtevZaPriznanjeZiga.PriloziUzZahtev }
     *     
     */
    public ZahtevZaPriznanjeZiga.PriloziUzZahtev getPriloziUzZahtev() {
        return priloziUzZahtev;
    }

    /**
     * Sets the value of the priloziUzZahtev property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZahtevZaPriznanjeZiga.PriloziUzZahtev }
     *     
     */
    public void setPriloziUzZahtev(ZahtevZaPriznanjeZiga.PriloziUzZahtev value) {
        this.priloziUzZahtev = value;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "podnosilacPrijave"
    })
    public static class PodnosilacPrijave {

        @XmlElement(name = "PodnosilacPrijave", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_zig", type = KTPersona.class)
        protected List<KTPersona> podnosilacPrijave;

        /**
         * Gets the value of the brojKlaseRobeIliUsluge property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the brojKlaseRobeIliUsluge property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBrojKlaseRobeIliUsluge().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Integer }
         *
         *
         */
        public List<KTPersona> getPodnosilacPrijave() {
            if (podnosilacPrijave == null) {
                podnosilacPrijave = new ArrayList<KTPersona>();
            }
            return this.podnosilacPrijave;
        }

    }

    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="BrojKlaseRobeIliUsluge" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "brojKlaseRobeIliUsluge"
    })
    public static class BrojeviKlasaRobeIliUsluga {

        @XmlElement(name = "BrojKlaseRobeIliUsluge", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_zig", type = Integer.class)
        protected List<Integer> brojKlaseRobeIliUsluge;

        /**
         * Gets the value of the brojKlaseRobeIliUsluge property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the brojKlaseRobeIliUsluge property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBrojKlaseRobeIliUsluge().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Integer }
         * 
         * 
         */
        public List<Integer> getBrojKlaseRobeIliUsluge() {
            if (brojKlaseRobeIliUsluge == null) {
                brojKlaseRobeIliUsluge = new ArrayList<Integer>();
            }
            return this.brojKlaseRobeIliUsluge;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="BrojPrijave"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:BrojPrijave" /&gt;
     *               &lt;/extension&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="DatumPodnosenja"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;date"&gt;
     *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:DatumPodnosenja" /&gt;
     *               &lt;/extension&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "brojPrijave",
        "emailNalogaPodnosioca",
        "datumPodnosenja",
        "datumPregledanja",
        "status"
    })
    public static class MetaData {

        @XmlElement(name = "BrojPrijave", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_zig", required = true)
        protected ZahtevZaPriznanjeZiga.MetaData.BrojPrijave brojPrijave;
        @XmlElement(name = "EmailNalogaPodnosioca", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_zig", required = true)
        protected ZahtevZaPriznanjeZiga.MetaData.EmailNalogaPodnosioca emailNalogaPodnosioca;
        @XmlElement(name = "DatumPodnosenja", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_zig", required = true)
        protected ZahtevZaPriznanjeZiga.MetaData.DatumPodnosenja datumPodnosenja;
        @XmlElement(name = "DatumPregledanja", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_zig", required = true)
        protected ZahtevZaPriznanjeZiga.MetaData.DatumPregledanja datumPregledanja;
        @XmlElement(name = "Status", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_zig", required = true)
        protected ZahtevZaPriznanjeZiga.MetaData.Status status;


        /**
         * Gets the value of the brojPrijave property.
         * 
         * @return
         *     possible object is
         *     {@link ZahtevZaPriznanjeZiga.MetaData.BrojPrijave }
         *     
         */
        public ZahtevZaPriznanjeZiga.MetaData.BrojPrijave getBrojPrijave() {
            return brojPrijave;
        }

        /**
         * Sets the value of the brojPrijave property.
         * 
         * @param value
         *     allowed object is
         *     {@link ZahtevZaPriznanjeZiga.MetaData.BrojPrijave }
         *     
         */
        public void setBrojPrijave(ZahtevZaPriznanjeZiga.MetaData.BrojPrijave value) {
            this.brojPrijave = value;
        }

        public ZahtevZaPriznanjeZiga.MetaData.EmailNalogaPodnosioca getEmailNalogaPodnosioca() {
            return emailNalogaPodnosioca;
        }

        /**
         * Sets the value of the brojPrijave property.
         *
         * @param value
         *     allowed object is
         *     {@link ZahtevZaPriznanjeZiga.MetaData.EmailNalogaPodnosioca }
         *
         */
        public void setEmailNalogaPodnosioca(ZahtevZaPriznanjeZiga.MetaData.EmailNalogaPodnosioca value) {
            this.emailNalogaPodnosioca = value;
        }

        /**
         * Gets the value of the datumPodnosenja property.
         * 
         * @return
         *     possible object is
         *     {@link ZahtevZaPriznanjeZiga.MetaData.DatumPodnosenja }
         *     
         */
        public ZahtevZaPriznanjeZiga.MetaData.DatumPodnosenja getDatumPodnosenja() {
            return datumPodnosenja;
        }

        /**
         * Sets the value of the datumPodnosenja property.
         * 
         * @param value
         *     allowed object is
         *     {@link ZahtevZaPriznanjeZiga.MetaData.DatumPodnosenja }
         *     
         */
        public void setDatumPodnosenja(ZahtevZaPriznanjeZiga.MetaData.DatumPodnosenja value) {
            this.datumPodnosenja = value;
        }

        public ZahtevZaPriznanjeZiga.MetaData.DatumPregledanja getDatumPregledanja() {
            return datumPregledanja;
        }

        /**
         * Sets the value of the datumPodnosenja property.
         *
         * @param value
         *     allowed object is
         *     {@link ZahtevZaPriznanjeZiga.MetaData.DatumPregledanja }
         *
         */
        public void setDatumPregledanja(ZahtevZaPriznanjeZiga.MetaData.DatumPregledanja value) {
            this.datumPregledanja = value;
        }

        public ZahtevZaPriznanjeZiga.MetaData.Status getStatus() {
            return status;
        }

        /**
         * Sets the value of the status property.
         *
         * @param value
         *     allowed object is
         *     {@link ZahtevZaPriznanjeZiga.MetaData.Status }
         *
         */
        public void setStatus(ZahtevZaPriznanjeZiga.MetaData.Status value) {
            this.status = value;
        }

        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;simpleContent&gt;
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
         *       &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:BrojPrijave" /&gt;
         *     &lt;/extension&gt;
         *   &lt;/simpleContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class BrojPrijave {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "property")
            protected String property;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the property property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProperty() {
                if (property == null) {
                    return "pred:BrojPrijave";
                } else {
                    return property;
                }
            }

            /**
             * Sets the value of the property property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProperty(String value) {
                this.property = value;
            }

        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "value"
        })
        public static class EmailNalogaPodnosioca {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "property")
            protected String property;

            /**
             * Gets the value of the value property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the property property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getProperty() {
                if (property == null) {
                    return "pred:EmailNalogaPodnosioca";
                } else {
                    return property;
                }
            }

            /**
             * Sets the value of the property property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setProperty(String value) {
                this.property = value;
            }

        }

        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;simpleContent&gt;
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;date"&gt;
         *       &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:DatumPodnosenja" /&gt;
         *     &lt;/extension&gt;
         *   &lt;/simpleContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class DatumPodnosenja {

            @XmlValue
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar value;
            @XmlAttribute(name = "property")
            protected String property;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setValue(XMLGregorianCalendar value) {
                this.value = value;
            }

            /**
             * Gets the value of the property property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProperty() {
                if (property == null) {
                    return "pred:DatumPodnosenja";
                } else {
                    return property;
                }
            }

            /**
             * Sets the value of the property property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProperty(String value) {
                this.property = value;
            }

        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "value"
        })
        public static class DatumPregledanja {

            @XmlValue
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar value;
            @XmlAttribute(name = "property")
            protected String property;

            /**
             * Gets the value of the value property.
             *
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *
             */
            public XMLGregorianCalendar getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             *
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *
             */
            public void setValue(XMLGregorianCalendar value) {
                this.value = value;
            }

            /**
             * Gets the value of the property property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getProperty() {
                if (property == null) {
                    return "pred:DatumPregledanja";
                } else {
                    return property;
                }
            }

            /**
             * Sets the value of the property property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setProperty(String value) {
                this.property = value;
            }

        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "value"
        })
        public static class Status {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "property")
            protected String property;

            /**
             * Gets the value of the value property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the property property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getProperty() {
                if (property == null) {
                    return "pred:Status";
                } else {
                    return property;
                }
            }

            /**
             * Sets the value of the property property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setProperty(String value) {
                this.property = value;
            }
        }
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="PrimerakZnaka" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *         &lt;element name="SpisakRobeIUsluga" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *         &lt;element name="Punomocje" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *         &lt;element name="PunomocjeRanijePrilozeno" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *         &lt;element name="PunomocjeNaknadnoPrilozeno" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *         &lt;element name="OpstiAktOZigu" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *         &lt;element name="DokazPravaPrvenstva" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *         &lt;element name="DokazUplateTakse" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "primerakZnaka",
        "spisakRobeIUsluga",
        "punomocje",
        "punomocjeRanijePrilozeno",
        "punomocjeNaknadnoPrilozeno",
        "opstiAktOZigu",
        "dokazPravaPrvenstva",
        "dokazUplateTakse"
    })
    public static class PriloziUzZahtev {

        @XmlElement(name = "PrimerakZnaka", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_zig")
        protected boolean primerakZnaka;
        @XmlElement(name = "SpisakRobeIUsluga", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_zig")
        protected boolean spisakRobeIUsluga;
        @XmlElement(name = "Punomocje", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_zig")
        protected boolean punomocje;
        @XmlElement(name = "PunomocjeRanijePrilozeno", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_zig")
        protected boolean punomocjeRanijePrilozeno;
        @XmlElement(name = "PunomocjeNaknadnoPrilozeno", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_zig")
        protected boolean punomocjeNaknadnoPrilozeno;
        @XmlElement(name = "OpstiAktOZigu", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_zig")
        protected boolean opstiAktOZigu;
        @XmlElement(name = "DokazPravaPrvenstva", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_zig")
        protected boolean dokazPravaPrvenstva;
        @XmlElement(name = "DokazUplateTakse", namespace = "http://www.ftn.uns.ac.rs/zahtev_za_zig")
        protected boolean dokazUplateTakse;

        /**
         * Gets the value of the primerakZnaka property.
         * 
         */
        public boolean isPrimerakZnaka() {
            return primerakZnaka;
        }

        /**
         * Sets the value of the primerakZnaka property.
         * 
         */
        public void setPrimerakZnaka(boolean value) {
            this.primerakZnaka = value;
        }

        /**
         * Gets the value of the spisakRobeIUsluga property.
         * 
         */
        public boolean isSpisakRobeIUsluga() {
            return spisakRobeIUsluga;
        }

        /**
         * Sets the value of the spisakRobeIUsluga property.
         * 
         */
        public void setSpisakRobeIUsluga(boolean value) {
            this.spisakRobeIUsluga = value;
        }

        /**
         * Gets the value of the punomocje property.
         * 
         */
        public boolean isPunomocje() {
            return punomocje;
        }

        /**
         * Sets the value of the punomocje property.
         * 
         */
        public void setPunomocje(boolean value) {
            this.punomocje = value;
        }

        /**
         * Gets the value of the punomocjeRanijePrilozeno property.
         * 
         */
        public boolean isPunomocjeRanijePrilozeno() {
            return punomocjeRanijePrilozeno;
        }

        /**
         * Sets the value of the punomocjeRanijePrilozeno property.
         * 
         */
        public void setPunomocjeRanijePrilozeno(boolean value) {
            this.punomocjeRanijePrilozeno = value;
        }

        /**
         * Gets the value of the punomocjeNaknadnoPrilozeno property.
         * 
         */
        public boolean isPunomocjeNaknadnoPrilozeno() {
            return punomocjeNaknadnoPrilozeno;
        }

        /**
         * Sets the value of the punomocjeNaknadnoPrilozeno property.
         * 
         */
        public void setPunomocjeNaknadnoPrilozeno(boolean value) {
            this.punomocjeNaknadnoPrilozeno = value;
        }

        /**
         * Gets the value of the opstiAktOZigu property.
         * 
         */
        public boolean isOpstiAktOZigu() {
            return opstiAktOZigu;
        }

        /**
         * Sets the value of the opstiAktOZigu property.
         * 
         */
        public void setOpstiAktOZigu(boolean value) {
            this.opstiAktOZigu = value;
        }

        /**
         * Gets the value of the dokazPravaPrvenstva property.
         * 
         */
        public boolean isDokazPravaPrvenstva() {
            return dokazPravaPrvenstva;
        }

        /**
         * Sets the value of the dokazPravaPrvenstva property.
         * 
         */
        public void setDokazPravaPrvenstva(boolean value) {
            this.dokazPravaPrvenstva = value;
        }

        /**
         * Gets the value of the dokazUplateTakse property.
         * 
         */
        public boolean isDokazUplateTakse() {
            return dokazUplateTakse;
        }

        /**
         * Sets the value of the dokazUplateTakse property.
         * 
         */
        public void setDokazUplateTakse(boolean value) {
            this.dokazUplateTakse = value;
        }

    }

}
