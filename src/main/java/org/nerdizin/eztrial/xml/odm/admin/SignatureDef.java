package org.nerdizin.eztrial.xml.odm.admin;

import org.nerdizin.eztrial.xml.odm.base.OdmElement;
import org.nerdizin.eztrial.xml.odm.base.OidElement;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;


public class SignatureDef extends OidElement {

    @XmlElement(name = "Meaning")
    private String meaning;

    @XmlElement(name = "LegalReason")
    private String legalReason;


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
