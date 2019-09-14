package org.nerdizin.eztrial.xml.odm.admin;

import org.nerdizin.eztrial.xml.odm.Namespaces;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Address {

    @XmlElement(name = "StreetName", namespace = Namespaces.ODM)
    private String streetName;

    @XmlElement(name = "City", namespace = Namespaces.ODM)
    private String city;

    @XmlElement(name = "StateProv", namespace = Namespaces.ODM)
    private String stateProv;

    @XmlElement(name = "Country", namespace = Namespaces.ODM)
    private String country;

    @XmlElement(name = "PostalCode", namespace = Namespaces.ODM)
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
