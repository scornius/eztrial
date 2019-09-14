package org.nerdizin.eztrial.xml.odm;

import javax.xml.bind.annotation.XmlAttribute;

public class Study {

    @XmlAttribute(name = "OID")
    private String oid;


    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }
}
