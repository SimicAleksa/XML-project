
package com.example.XML_WS_backend.models.trademark;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="PodnosilacPrijave" type="{ZAHTEV_ZA_PRIZNANJE_ZIGA}KTPersona" maxOccurs="unbounded"/&gt;
 *         &lt;element name="Punomocnik" type="{ZAHTEV_ZA_PRIZNANJE_ZIGA}KTPersona"/&gt;
 *         &lt;element name="ZajednickiPredstavnici" type="{ZAHTEV_ZA_PRIZNANJE_ZIGA}KTPersona" minOccurs="0"/&gt;
 *         &lt;element name="Zig" type="{ZAHTEV_ZA_PRIZNANJE_ZIGA}KTZig"/&gt;
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
 *         &lt;element name="Taksa" type="{ZAHTEV_ZA_PRIZNANJE_ZIGA}KTTaksa"/&gt;
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
 *       &lt;attribute name="DatumPodnosenja" type="{http://www.w3.org/2001/XMLSchema}date" /&gt;
 *       &lt;attribute name="BrojPrijave" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "podnosilacPrijave",
    "punomocnik",
    "zajednickiPredstavnici",
    "zig",
    "brojeviKlasaRobeIliUsluga",
    "pravoPrvenstvaIOsnov",
    "taksa",
    "priloziUzZahtev"
})
@XmlRootElement(name = "ZahtevZaPriznanjeZiga", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA")
public class ZahtevZaPriznanjeZiga {

    @XmlElement(name = "PodnosilacPrijave", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA", required = true)
    protected List<KTPersona> podnosilacPrijave;
    @XmlElement(name = "Punomocnik", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA", required = true)
    protected KTPersona punomocnik;
    @XmlElement(name = "ZajednickiPredstavnici", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA")
    protected KTPersona zajednickiPredstavnici;
    @XmlElement(name = "Zig", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA", required = true)
    protected KTZig zig;
    @XmlElement(name = "BrojeviKlasaRobeIliUsluga", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA", required = true)
    protected ZahtevZaPriznanjeZiga.BrojeviKlasaRobeIliUsluga brojeviKlasaRobeIliUsluga;
    @XmlElement(name = "PravoPrvenstvaIOsnov", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA", required = true)
    protected String pravoPrvenstvaIOsnov;
    @XmlElement(name = "Taksa", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA", required = true)
    protected KTTaksa taksa;
    @XmlElement(name = "PriloziUzZahtev", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA", required = true)
    protected ZahtevZaPriznanjeZiga.PriloziUzZahtev priloziUzZahtev;
    @XmlAttribute(name = "DatumPodnosenja")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumPodnosenja;
    @XmlAttribute(name = "BrojPrijave")
    protected Integer brojPrijave;

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
    public List<KTPersona> getPodnosilacPrijave() {
        if (podnosilacPrijave == null) {
            podnosilacPrijave = new ArrayList<KTPersona>();
        }
        return this.podnosilacPrijave;
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
    public KTPersona getZajednickiPredstavnici() {
        return zajednickiPredstavnici;
    }

    /**
     * Sets the value of the zajednickiPredstavnici property.
     * 
     * @param value
     *     allowed object is
     *     {@link KTPersona }
     *     
     */
    public void setZajednickiPredstavnici(KTPersona value) {
        this.zajednickiPredstavnici = value;
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

    /**
     * Gets the value of the datumPodnosenja property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumPodnosenja() {
        return datumPodnosenja;
    }

    /**
     * Sets the value of the datumPodnosenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumPodnosenja(XMLGregorianCalendar value) {
        this.datumPodnosenja = value;
    }

    /**
     * Gets the value of the brojPrijave property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBrojPrijave() {
        return brojPrijave;
    }

    /**
     * Sets the value of the brojPrijave property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBrojPrijave(Integer value) {
        this.brojPrijave = value;
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

        @XmlElement(name = "BrojKlaseRobeIliUsluge", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA", type = Integer.class)
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

        @Override
        public String toString() {
            return "BrojeviKlasaRobeIliUsluga{" +
                    "brojKlaseRobeIliUsluge=" + brojKlaseRobeIliUsluge +
                    '}';
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

        @XmlElement(name = "PrimerakZnaka", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA")
        protected boolean primerakZnaka;
        @XmlElement(name = "SpisakRobeIUsluga", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA")
        protected boolean spisakRobeIUsluga;
        @XmlElement(name = "Punomocje", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA")
        protected boolean punomocje;
        @XmlElement(name = "PunomocjeRanijePrilozeno", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA")
        protected boolean punomocjeRanijePrilozeno;
        @XmlElement(name = "PunomocjeNaknadnoPrilozeno", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA")
        protected boolean punomocjeNaknadnoPrilozeno;
        @XmlElement(name = "OpstiAktOZigu", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA")
        protected boolean opstiAktOZigu;
        @XmlElement(name = "DokazPravaPrvenstva", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA")
        protected boolean dokazPravaPrvenstva;
        @XmlElement(name = "DokazUplateTakse", namespace = "ZAHTEV_ZA_PRIZNANJE_ZIGA")
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

        @Override
        public String toString() {
            return "PriloziUzZahtev{" +
                    "primerakZnaka=" + primerakZnaka +
                    ", spisakRobeIUsluga=" + spisakRobeIUsluga +
                    ", punomocje=" + punomocje +
                    ", punomocjeRanijePrilozeno=" + punomocjeRanijePrilozeno +
                    ", punomocjeNaknadnoPrilozeno=" + punomocjeNaknadnoPrilozeno +
                    ", opstiAktOZigu=" + opstiAktOZigu +
                    ", dokazPravaPrvenstva=" + dokazPravaPrvenstva +
                    ", dokazUplateTakse=" + dokazUplateTakse +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ZahtevZaPriznanjeZiga{" +
                "podnosilacPrijave=" + podnosilacPrijave +
                ", punomocnik=" + punomocnik +
                ", zajednickiPredstavnici=" + zajednickiPredstavnici +
                ", zig=" + zig +
                ", brojeviKlasaRobeIliUsluga=" + brojeviKlasaRobeIliUsluga +
                ", pravoPrvenstvaIOsnov='" + pravoPrvenstvaIOsnov + '\'' +
                ", taksa=" + taksa +
                ", priloziUzZahtev=" + priloziUzZahtev +
                ", datumPodnosenja=" + datumPodnosenja +
                ", brojPrijave=" + brojPrijave +
                '}';
    }
}
