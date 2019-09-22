package org.nerdizin.eztrial.xml.odm.admin;

import org.nerdizin.eztrial.xml.odm.base.OdmElement;

import javax.xml.bind.annotation.XmlElement;


public class Address implements OdmElement {

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

    public void setStreetName(final String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getStateProv() {
        return stateProv;
    }

    public void setStateProv(final String stateProv) {
        this.stateProv = stateProv;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(final String postalCode) {
        this.postalCode = postalCode;
    }
}
