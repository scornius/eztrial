package org.nerdizin.eztrial.xml.odm.admin;

import org.nerdizin.eztrial.xml.Namespaces;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


public class Address {

    @XmlElement(name = "StreetName")
    private String streetName;

    @XmlElement(name = "City")
    private String city;

    @XmlElement(name = "StateProv")
    private String stateProv;

    @XmlElement(name = "Country")
    private String country;

    @XmlElement(name = "PostalCode")
    private String postalCode;


    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProv() {
        return stateProv;
    }

    public void setStateProv(String stateProv) {
        this.stateProv = stateProv;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
