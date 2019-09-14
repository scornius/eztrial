package org.nerdizin.eztrial.xml.odm.admin;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;


public class SignatureDef {

    @XmlAttribute(name = "OID")
    private String oid;

    @XmlElement(name = "Meaning")
    private String meaning;

    @XmlElement(name = "LegalReason")
    private String legalReason;


    public String getOid() {
        return oid;
    }

    public void setOid(final String oid) {
        this.oid = oid;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(final String meaning) {
        this.meaning = meaning;
    }

    public String getLegalReason() {
        return legalReason;
    }

    public void setLegalReason(final String legalReason) {
        this.legalReason = legalReason;
    }
}
