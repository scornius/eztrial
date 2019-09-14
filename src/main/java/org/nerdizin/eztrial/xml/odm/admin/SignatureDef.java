package org.nerdizin.eztrial.xml.odm.admin;

import org.nerdizin.eztrial.xml.odm.Namespaces;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class SignatureDef {

    @XmlAttribute(name = "OID")
    private String oid;

    @XmlElement(name = "Meaning", namespace = Namespaces.ODM)
    private String meaning;

    @XmlElement(name = "LegalReason", namespace = Namespaces.ODM)
    private String legalReason;


    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getLegalReason() {
        return legalReason;
    }

    public void setLegalReason(String legalReason) {
        this.legalReason = legalReason;
    }
}
